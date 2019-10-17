/**
 * Example of writing custom application-specific steps
 */

import pages.*
import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By
import geb.*
import wslite.rest.*

// constantes
def boardName = "boardFK"
def listName = "listFK"

// variaveis referentes a requisicao para criar um board
def boardId  
def boardResponse

// variaveis referentes a requisicao para criar uma lista
def listId
def listResponse

// variaveis referentes a requisicao para criar um board
def cardId
def cardResponse

Dado(~/que o usuário cria um Board/) { ->
   
   def boardRequest = new RESTClient("https://api.trello.com/1/boards/?name="+boardName+"&defaultLabels=true&defaultLists=true&keepFromSource=none&prefs_permissionLevel=private&prefs_voting=disabled&prefs_comments=members&prefs_invitations=members&prefs_selfJoin=true&prefs_cardCovers=true&prefs_background=blue&prefs_cardAging=regular&key=ad3cb8118c2688a49b8e4a1482c1c631&token=9f0f9037dc4f03d3ae5b60d9f21d630a04fb46b43919e8a849fa981be9a24f7e")
   boardResponse = boardRequest.post()

   // verifica que a requisicao retornou uma resposta
   assert boardResponse != null

   // assegura que o board foi criado corretamente, testando se o id foi retornado
   assert boardResponse.json.id != null


  }

Dado(/o id do board é guardado/) {  ->

   boardId = boardResponse.json.id
   println boardId
}

Dado(/o usuario cria uma lista a partir do id do board/) {  ->
  
   def listRequest = new RESTClient("https://api.trello.com/1/lists?name="+listName+"&idBoard="+boardId+"&key=ad3cb8118c2688a49b8e4a1482c1c631&token=9f0f9037dc4f03d3ae5b60d9f21d630a04fb46b43919e8a849fa981be9a24f7e")
   listResponse = listRequest.post()

   assert listResponse != null

   assert listResponse.json.id != null
}

Dado(/o id da lista é guardado/) {  ->

   listId = listResponse.json.id
}

