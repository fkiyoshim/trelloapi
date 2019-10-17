
import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By
import geb.*

import wslite.rest.*
def clientLogin
def clientDetalhe
def clientAnotacao

Quando(/um token for gerado/) {  ->
    
}

Quando(/que sejam passadas as credenciais para o webserice detalhe da anotacao: na URL '(.*)' bilhete '(.*)' e usuário '(.*)'/) { String url, String codigo_bilhete, String usuario ->
     def token = repo.get("token")
     println "Serviço ticket = ${url}${token}/${codigo_bilhete}/${usuario}\n\n"
     clientAnotacao = new RESTClient("${url}${token}/${codigo_bilhete}/${usuario}")

     def responseAnotacao = clientAnotacao.get()
     repo.add("response anotacao", responseAnotacao)
}

Então(/o serviço retorna a anotação técnica e a anotação operacional/) {  ->

    def responseAnotacao = repo.get("response anotacao")
    println "Anotação = ${responseAnotacao.json}\n\n"

     println "Anotação técnica = ${responseAnotacao.json.technical}\n\n\n"
     println "Anotação operacional = ${responseAnotacao.json.operation}\n\n\n"

     assert responseAnotacao.json.technical != null
     assert responseAnotacao.json.operation != null
    
}

Então(/o serviço retorna a anotação operacional/) {  ->
    def responseAnotacao = repo.get("response anotacao")
    println "Anotação = ${responseAnotacao.json}\n\n"

     
     println "Anotação operacional = ${responseAnotacao.json.operation}\n\n\n"

     assert responseAnotacao.json.technical == null
     assert responseAnotacao.json.operation != null
}

Então(/o serviço retorna a anotação técnica/) {  ->
    def responseAnotacao = repo.get("response anotacao")
    println "Anotação = ${responseAnotacao.json}\n\n"

     
     println "Anotação operacional = ${responseAnotacao.json.operation}\n\n\n"

     assert responseAnotacao.json.technical != null
     assert responseAnotacao.json.operation == null
}


Quando(/que sejam passadas as credenciais para o webserice detalhe da anotacao: na URL '(.*)' bilhete '(.*)' e usuário '(.*)' statusCode '(.*)' é retornado/) { String url, String codigo_bilhete, String usuario, String status ->
    
    
}

Então(/o serviço não retorna nenhuma anotação/) {  ->
 
}




