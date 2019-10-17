
import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By
import geb.*

import wslite.rest.*
//def clientLogin
def clientDetalhe

//Cenário: Login WS token recuperado com sucesso
Dado(/que sejam passadas as credenciais/) { ->


    //clientLogin = new RESTClient("https://api.trello.com/1/members/me/?key=ad3cb8118c2688a49b8e4a1482c1c631&token=9f0f9037dc4f03d3ae5b60d9f21d630a04fb46b43919e8a849fa981be9a24f7e")

}

Quando(/o webserice login for executado/) { ->
Thread.sleep(30)
    def clientLogin = new RESTClient("https://api.trello.com/1/members/me/?key=ad3cb8118c2688a49b8e4a1482c1c631&token=9f0f9037dc4f03d3ae5b60d9f21d630a04fb46b43919e8a849fa981be9a24f7e")
    def response = clientLogin.get()

    //println "response headers"
    //println response.headers
    
 

    println "Token = ${response.json.token}"    
    //println response.json.token

    repo.add("token", response.json.token)
    repo.add("response login", response)

}

Então(/deve obter a seguinte resposta: statusCode '(.*)' e token gerado1/) { int status ->
    
    def token = repo.get("token")
    def response = repo.get("response login")

    assert response.statusCode == status
    assert token != null

}


//Cenário: WS Detalhe do Ticket 
Dado(/que sejam passadas as credenciais para o webserice detalhe ticket: username '(.*)' na URL '(.*)1'/) { String user, String url ->

    def token = repo.get("token")
    clientDetalhe = new RESTClient("${url}${token}/${user}")

}

Quando(/o webserice detalhe ticket for executado1/) {  ->

    def responseDetalhe = clientDetalhe.get()

    //println "response json"
    //println responseDetalhe.json
    println "Detalhe = ${responseDetalhe.json}"
    repo.add("response detalhe", responseDetalhe)

}

Então(/deve obter a seguinte resposta: site '(.*)'1 /) { String site1  ->
    def responseDetalhe = repo.get("response detalhe")

    println "response dados"
    
    println responseDetalhe.json.id[0]


    println "Site = ${responseDetalhe.json.site[0]}"


   
    assert responseDetalhe.json.site[0] == site1

}


