
import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By
import geb.*

import wslite.rest.*
def clientLogin
def clientDetalhe
def clientBilhete

Dado(/que sejam passadas as credenciais para o webserice de login: username '(.*)' e password '(.*)' na URL '(.*)'/) { String user, String senha, String url ->
    clientLogin = new RESTClient("${url}login/${user}/${senha}")
}

Quando(/o webserice de login for executado/) {  ->
    def response = clientLogin.get()
 
    println "-----------------------------------------------------------------------------------" 
    println "Token = ${response.json.token}"    
    println "-----------------------------------------------------------------------------------" 

    repo.add("token", response.json.token)
    repo.add("response login", response)
}

Então(/deve obter a seguinte resposta: statusCode '(.*)' e um token é gerado/) { int status ->
    def token = repo.get("token")
    def response = repo.get("response login")

    assert response.statusCode == status
    assert token != null
}

Dado(/que sejam passadas as credenciais para o webserice detalhe dos sites: username '(.*)' na URL '(.*)'/) { String user, String url ->
     def token = repo.get("token")
     clientDetalhe = new RESTClient("${url}${token}/${user}")
}

Quando(/o webserice de detalhe do site for executado/) {  ->
     def responseDetalhe = clientDetalhe.get()

     repo.add("response detalhe", responseDetalhe)
}

Então(/deve obter a seguinte resposta: site '(.*)' , '(.*)' e '(.*)'/) { String site1, String site2, String site3 ->
    def responseDetalhe = repo.get("response detalhe")
    
    def impacto = ['SEM IMPACTO','ALTO', 'MÉDIO', 'BAIXO']
    def cor = ['Cinza','Vermelho', 'Laranja', 'Amarelo']

    def tamanho = responseDetalhe.json.size()
    println "-----------------------------------------------------------------------------------\n" 
    println "Quantidade de sites = ${tamanho}\n\n\n"
    println "-----------------------------------------------------------------------------------\n" 
    println "Sites = ${responseDetalhe.json}"

    for(int i=0;i<tamanho;i++){
        println "-----------------------------------------------------------------------------------\n" 

        println "Site = ${responseDetalhe.json[i]}\n"
        println "Site = ${responseDetalhe.json.site[i]}\n"
        println "Quantidade de bilhete = ${responseDetalhe.json.counter[i]}\n"
        println "Dominio administrativo = ${responseDetalhe.json.admindomain[i]}\n"
       
        if(((responseDetalhe.json.impact[i])== '0')){
             println "Impacto = ${impacto[0]}\n"
        }
        if(((responseDetalhe.json.impact[i])== '1')){
             println "Impacto = ${impacto[1]}\n"
        }
        if(((responseDetalhe.json.impact[i])== '2')){
             println "Impacto = ${impacto[2]}\n"
        }
        if(((responseDetalhe.json.impact[i])== '3')){
             println "Impacto = ${impacto[3]}\n"
        }

        println "Cor = ${responseDetalhe.json.color[i]}\n"

        if(((responseDetalhe.json.color[i])== 'grey')){
             println "Impacto = ${cor[0]}\n"
        }
        if(((responseDetalhe.json.color[i])== 'orange')){
             println "Impacto = ${cor[2]}\n"
        }
        if(((responseDetalhe.json.color[i])== 'red')){
             println "Impacto = ${cor[1]}\n"
        }
        if(((responseDetalhe.json.color[i])== 'yellow')){
             println "Impacto = ${cor[3]}\n"
        }
        println "-----------------------------------------------------------------------------------" 
    }
 
    assert responseDetalhe.json.site[0] == site1
    assert responseDetalhe.json.site[1] == site2
    assert responseDetalhe.json.site[2] == site3
}




Dado(/que sejam passadas as credenciais para o webserice detalhe dos bilhete: na URL '(.*)' site '(.*)' e  username '(.*)'/) { String url, String site, String username ->
     def token = repo.get("token")
     println "Serviço ticket = ${url}${token}/${site}/${username}\n\n"
     clientBilhete = new RESTClient("${url}${token}/${site}/${username}")
     
}
Quando(/o webserice de detalhe do bilhete for executado/) {  ->
     def responseBilhete = clientBilhete.get()
     repo.add("response bilhete", responseBilhete)
}



Então(/deve obter as seguintes informações dos bilhetes '(.*)' e '(.*)'/) { String bilhete, String bilhete2 ->

    def responseBilhete = repo.get("response bilhete")
    println "Bilhetes = ${responseBilhete.json}\n\n"
    
    def impacto = ['SEM IMPACTO','ALTO', 'MÉDIO', 'BAIXO']

    def tamanho = responseBilhete.json.size()
    println "Quantidade de bilhetes no site = ${tamanho}\n\n"

    for(int i=0;i<tamanho;i++){
        println "-----------------------------------------------------------------------------------\n" 
        //println "                          -------------Bilhete = ${i+1}--------------              \n\n"
        println "Identificação = ${responseBilhete.json.code[i]}\n\n\n"
        println "Nome do recurso = ${responseBilhete.json.resource[i]}\n"
        println "Dominio administrativo = ${responseBilhete.json.adminDomain[i]}\n"
        println "Dominio tecnológico = ${responseBilhete.json.technologicalDomain[i]}\n"

        if(((responseBilhete.json.impact[i])== '0')){
             println "Impacto = ${impacto[0]}\n\n\n"
        }
        if(((responseBilhete.json.impact[i])== '1')){
             println "Impacto = ${impacto[1]}\n\n\n"
        }
        if(((responseBilhete.json.impact[i])== '2')){
             println "Impacto = ${impacto[2]}\n\n\n"
        }
        if(((responseBilhete.json.impact[i])== '3')){
             println "Impacto = ${impacto[3]}\n\n\n"
        }
        //println "Anotação = ${responseBilhete.json.annotation[i]}\n"

        println "Anotação técnica  = ${responseBilhete.json.annotation[i].technical}\n"
        println "Anotação operacional = ${responseBilhete.json.annotation[i].operation}\n\n"

        
        println "-----------------------------------------------------------------------------------\n" 
       
        
        
    }
     assert responseBilhete.json.code[0] == bilhete
     assert responseBilhete.json.code[1] == bilhete2
     
    
}

Então(/deve obter as seguintes informações do bilhete '(.*)'/) { String bilhete ->
   def responseBilhete = repo.get("response bilhete")
    println "Bilhetes = ${responseBilhete.json}\n\n"
    
    def impacto = ['SEM IMPACTO','ALTO', 'MÉDIO', 'BAIXO']

    def tamanho = responseBilhete.json.size()
    println "Quantidade de bilhetes no site ${responseBilhete.json.site} = ${tamanho}\n\n"

    for(int i=0;i<tamanho;i++){
        println "-----------------------------------------------------------------------------------\n" 
        //println "                          -------------Bilhete = ${i+1}--------------              \n\n"
        println "Identificação = ${responseBilhete.json.code[i]}\n\n\n"
        println "Nome do recurso = ${responseBilhete.json.resource[i]}\n"
        println "Dominio administrativo = ${responseBilhete.json.adminDomain[i]}\n"
        println "Dominio tecnológico = ${responseBilhete.json.technologicalDomain[i]}\n"

        if(((responseBilhete.json.impact[i])== '0')){
             println "Impacto = ${impacto[0]}\n\n\n"
        }
        if(((responseBilhete.json.impact[i])== '1')){
             println "Impacto = ${impacto[1]}\n\n\n"
        }
        if(((responseBilhete.json.impact[i])== '2')){
             println "Impacto = ${impacto[2]}\n\n\n"
        }
        if(((responseBilhete.json.impact[i])== '3')){
             println "Impacto = ${impacto[3]}\n\n\n"
        }
        //println "Anotação = ${responseBilhete.json.annotation[i]}\n"

        println "Anotação técnica  = ${responseBilhete.json.annotation[i].technical}\n"
        println "Anotação operacional = ${responseBilhete.json.annotation[i].operation}\n\n"

        
        println "-----------------------------------------------------------------------------------\n" 
    
    }
     assert responseBilhete.json.code[0] == bilhete
       
}


