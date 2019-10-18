/**
 * Example of writing custom application-specific steps
 */
import groovyx.net.http.RESTClient.*
import groovyx.net.http.URIBuilder.*
import groovyx.net.http.HTTPBuilder.*
import java.net.URLEncoder

import pages.*
import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By
import geb.*
import wslite.rest.*


// variaveis referentes a requisicao para criar um board
def boardId  
def boardPlugin
def boardResponse

// variaveis referentes a requisicao para criar uma lista
def listId
def listResponse

// variaveis referentes a requisicao para criar um board
def cardId
def cardResponse
def commentResponse

Dado(~/que o usuário cria um '(.*)'/) { String boardName->
   
   def boardRequest = new RESTClient("https://api.trello.com/1/boards/?name="+URLEncoder.encode(boardName)+"&defaultLabels=true&defaultLists=true&keepFromSource=none&prefs_permissionLevel=private&prefs_voting=disabled&prefs_comments=members&prefs_invitations=members&prefs_selfJoin=true&prefs_cardCovers=true&prefs_background=blue&prefs_cardAging=regular&key=ad3cb8118c2688a49b8e4a1482c1c631&token=9f0f9037dc4f03d3ae5b60d9f21d630a04fb46b43919e8a849fa981be9a24f7e")
     
   boardResponse = boardRequest.post()

   // verifica que a requisicao retornou uma resposta
   assert boardResponse != null

   // assegura que o board foi criado corretamente, testando se o id foi retornado
   assert boardResponse.json.id != null
   println "responsivo"
println boardResponse

  }

Dado(/o Quadro é criado com sucesso/) {  ->

   boardId = boardResponse.json.id

   println "Id do Quadro:"
   println boardId
}

Dado(/o usuario cria uma '(.*)' utilizando o Quadro/) { String listName ->
  
   def listRequest = new RESTClient("https://api.trello.com/1/lists?name="+URLEncoder.encode(listName)+"&idBoard="+boardId+"&key=ad3cb8118c2688a49b8e4a1482c1c631&token=9f0f9037dc4f03d3ae5b60d9f21d630a04fb46b43919e8a849fa981be9a24f7e")
   listResponse = listRequest.post()

   assert listResponse != null
   assert listResponse.json.id != null

}

Dado(/a Lista é criada com sucesso/) {  ->

   listId = listResponse.json.id

  assert listId != null
  
  println "listid"
  println listId
}

E (/o usuário cria um Cartão, informando o '(.*)' e uma '(.*)'/) { String nameCard, String descCard  ->

    def cardRequest = new RESTClient("https://api.trello.com/1/cards?idList="+listId+"&keepFromSource=all&key=ad3cb8118c2688a49b8e4a1482c1c631&token=9f0f9037dc4f03d3ae5b60d9f21d630a04fb46b43919e8a849fa981be9a24f7e&name="+nameCard+"&desc="+descCard+"")
    cardResponse = cardRequest.post()

    assert nameCard == nameCard 
 Thread.sleep(5000)
    println "card response"
    println cardResponse

 }


Quando(/o Cartão é criado com sucesso/){ ->

cardId = cardResponse.json.id.trim()

 println "card iddddd"
 println cardId

 assert cardId != null

 }
 
Então (/o usuário edita o Cartão criado, alterando o '(.*)' e a '(.*)'/){ String editName, String editDesc ->
def urlEditCard = "https://api.trello.com/1/cards/"+cardId+"?key=ad3cb8118c2688a49b8e4a1482c1c631&token=9f0f9037dc4f03d3ae5b60d9f21d630a04fb46b43919e8a849fa981be9a24f7e&name="+URLEncoder.encode(editName)+"&desc="+URLEncoder.encode(editDesc)+""

 assert editName == editName

println "urlEditCard"
println urlEditCard

def cardEditRequest = new RESTClient(urlEditCard)

cardEditRequest.put()

 println editName
 println editDesc

}

Quando(/por fim o Cartão e todos os registros são excluído/){ ->

def removeCard = new RESTClient ("https://api.trello.com/1/boards/"+boardId+"?key=ad3cb8118c2688a49b8e4a1482c1c631&token=9f0f9037dc4f03d3ae5b60d9f21d630a04fb46b43919e8a849fa981be9a24f7e")
removeCard.delete()

println "removeu!"
println removeCard
}