import pages.*
import geb.*
import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By

Dado(/clique no menu Mapa/) {  ->
  waitFor(30){
      page.menuMapa.jquery.mouseover()
   }
}

Dado(/clique no submenu Inoperância/) {  ->
     waitFor(30){
      page.submenuMapa.click()
   }
}

Dado(/na tela de inoperância clica na consulta personalizada '(.*)'/) { String nome_consulta ->
   Thread.sleep(5000);
   waitFor(30){  
     $(By.xpath("//li[.='${nome_consulta}']"),0).click()
   }
   Thread.sleep(5000);
   
}

Então(/o sistema exibe os seguintes sites '(.*)' '(.*)' '(.*)'/) {String site_1, String site_2, String site_3 ->
   at Mapa_InoperanciaPage

   //Site: DTCEA-YS com impacto laranja
   assert $(By.xpath("//*[contains(@title, '${site_1}')]")) != null
   assert $(By.xpath("//*[contains(@title, '${site_1}')]/img")).getAttribute("src").contains("site_map_orange.png") == true

   //Site: DTCEA-YS com impacto vermelho
   assert $(By.xpath("//*[contains(@title, '${site_2}')]")) != null
   assert $(By.xpath("//*[contains(@title, '${site_2}')]/img")).getAttribute("src").contains("site_map_red.png") == true


   //Site: DTCEA-YS com impacto cinza
   assert $(By.xpath("//*[contains(@title, '${site_3}')]")) != null
   assert $(By.xpath("//*[contains(@title, '${site_3}')]/img")).getAttribute("src").contains("site_map_grey.png") == true

}

Então(/o sistema exibe o seguinte site '(.*)' com impacto '(.*)'/) { String site_1, String impacto->
 
   assert $(By.xpath("//*[contains(@title, '${site_1}')]")) != null
   assert $(By.xpath("//*[contains(@title, '${site_1}')]/img")).getAttribute("src").contains("site_map_${impacto}.png") == true

}

