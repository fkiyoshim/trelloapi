
import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By
import geb.*

import wslite.rest.*
def clientLogin
def clientDetalhe

//Cenário: Login WS token recuperado com sucesso
Dado(/que sejam passadas as credenciais para o webserice login: username '(.*)' e password '(.*)' na URL '(.*)'/) {
String user, String senha, String url ->

    clientLogin = new RESTClient("${url}login/${user}/${senha}")

}

Quando(/o webserice login for executado1/) { ->

    def response = clientLogin.get()

    //println "response headers"
    //println response.headers
    
 

    println "Token = ${response.json.token}"    
    //println response.json.token

    repo.add("token", response.json.token)
    repo.add("response login", response)

}

Então(/deve obter a seguinte resposta: statusCode '(.*)' e token gerado/) { int status ->
    
    def token = repo.get("token")
    def response = repo.get("response login")

    assert response.statusCode == status
    assert token != null

}


//Cenário: WS Detalhe do Ticket 
Dado(/que sejam passadas as credenciais para o webserice detalhe ticket: username '(.*)' na URL '(.*)'/) { String user, String url ->

    def token = repo.get("token")
    clientDetalhe = new RESTClient("${url}${token}/${user}")

}

Quando(/o webserice detalhe ticket for executado/) {  ->

    def responseDetalhe = clientDetalhe.get()

    //println "response json"
    //println responseDetalhe.json
    println "Detalhe = ${responseDetalhe.json}"
    repo.add("response detalhe", responseDetalhe)

}

Então(/deve obter a seguinte resposta: site '(.*)' /) { String site1  ->
    def responseDetalhe = repo.get("response detalhe")

    println "response dados"
    
    println responseDetalhe.json.id[0]


    println "Site = ${responseDetalhe.json.site[0]}"


   
    assert responseDetalhe.json.site[0] == site1

}


