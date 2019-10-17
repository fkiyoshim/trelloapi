import pages.*
import geb.*
import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By

def temp=60

Dado(/que o usuário esteja no dasboard/) {  ->
   at DashboardPage
}

E(/clique no menu Bilhete/) { ->
   waitFor(temp){
      page.menuBilhete.jquery.mouseover()
   }

     
}

E(/clique no submenu Bilhete/) { ->
   Thread.sleep(1000);
   waitFor(30){  
      page.submenuBilhete.click()
   }
   
}

Dado(/na tela de lista de bilhetes clique no botão '(.*)'/) { String incluir ->
   Thread.sleep(5000);
   at ListaPage
   waitFor(30){  
     page.buttonIncluir.click()
   }
   Thread.sleep(5000);

   //abrir em tela inteira
   page.browser.driver.manage().window().fullscreen(); 
}

E(/na tela de incluir bilhete preencha o Título '(.*)'/) { String titulo ->
   Thread.sleep(5000);
   at IncluirBilhetePage
   waitFor(30){  
     page.titulo.value(titulo);
   }
   Thread.sleep(1000);
}

E(/selecione o Modelo '(.*)'/) { String modelo ->
   waitFor(30){  
     page.combomodelo.click()
   }
   Thread.sleep(1000);
   $(By.xpath("//li[.='${modelo}']")).click()
   Thread.sleep(5000);
    
}

E(/selecione a Prioridade '(.*)'/) { String prioridade ->

   waitFor(30){  
     page.comboprioridade.click()
   }
   Thread.sleep(1000);
   $(By.xpath("//li[.='${prioridade}']"),0).click()
   Thread.sleep(5000);
    
}

E(/selecione o responsável '(.*)'/) { String responsavel ->
    waitFor(30){  
     page.comboresponsavel.click()
   }
   Thread.sleep(1000);
   $(By.xpath("//li[.='${responsavel}']"),0).click()
   Thread.sleep(5000);
}

E(/dentro da tabela Dados do recurso clicar no botão para incluir recurso/) {  ->
    Thread.sleep(5000);
    //Faz scroll na página até clicar no botão desejado
    lupa = browser.driver.findElementByCssSelector("button[id*='buttonAddResource']")
    browser.driver.executeScript("arguments[0].scrollIntoView();" , lupa)
    
   waitFor(30){ 
     page.botaolupa.click()
   }
   Thread.sleep(5000);
}
E(/na tela de filtrar recursos cadastrados clique no botão Buscar/) {  ->
  
 waitFor(30){ 
  page.botaobuscar.click()
 }
 Thread.sleep(5000);
}

E(/selecione o primeiro item/) {  ->
 Thread.sleep(5000);
 waitFor(30){ 
  page.itemrecurso.click()
 }
 Thread.sleep(5000);
}

E(/selecione o botão Confirmar/) {  -> 
   Thread.sleep(5000);
   waitFor(30){  
    page.botaoconfirmar.click()
   }
   Thread.sleep(5000);
}

Quando(/clicar em Confirmar na tela de incluir bilhete/) {  ->
   waitFor(30){  
    page. botaoconfirmar2.click()
   }
   Thread.sleep(5000);
}

Então(/a mensagem '(.*)' deve ser exibida/) {  String msg_inc_ag_ok ->
   at ListaPage

   Thread.sleep(1000)  
   println $(By.xpath("//*[contains(text(), 'A operação foi realizada com sucesso')]"),0)
   def msg_inc = page.msg_inclusao_ok.text()
   //assert msg_inc_ag_ok == msg_inc
   Thread.sleep(5000)
}

E(/preencho '(.*)'/) { String bilhetes ->
   Thread.sleep(5000);
   at IncluirBilhetePage
   file = YAML.load_file(File.join(Dir.pwd, "steps/fixtures/bilhete.yaml"))
   bilhete = file[bilhetes]
   puts bilhete
}



Dado(/que o item foi excluido do banco de dados/) {  ->
   Thread.sleep(5000)
   def queryINSTANCE_ALERT = db.execute("delete from WF_INSTANCE_ALERT where INSTANCE_ID in (select id from WF_INSTANCE where title like 'bilhete 01')")
   def queryINSTANCE_CHANGE = db.execute("delete from WF_INSTANCE_CHANGE where INSTANCE_ID in (select id from WF_INSTANCE where title like 'bilhete 01')")
   def queryINSTANCE_COMMENT = db.execute("delete from WF_INSTANCE_COMMENT where INSTANCE_ID in (select id from WF_INSTANCE where title like 'bilhete 01')")
   def queryINSTANCE_RESOURCE = db.execute("delete from WF_INSTANCE_RESOURCE where INSTANCE_ID in (select id from WF_INSTANCE where title like 'bilhete 01')")
   def queryINSTANCE_TRANSITION = db.execute("delete from WF_INSTANCE_TRANSITION where INSTANCE_ID in (select id from WF_INSTANCE where title like 'bilhete 01')")
   def queryINSTANCE = db.execute("delete from WF_INSTANCE t where t.title like 'bilhete 01'")
}


