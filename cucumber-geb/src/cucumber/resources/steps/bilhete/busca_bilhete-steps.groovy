import pages.*
import geb.*
import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By



Quando(/pesquiso pela janela '(.*)'/) {String janela ->
   Thread.sleep(5000);
   at FiltrosBilhetePage
   waitFor(30){  
     page.filtroTitulo.value(janela);
   }
   Thread.sleep(1000);

   at DashboardPage

   waitFor(30){  
     page.resutadoBusca.click()
   }
   Thread.sleep(1000);
  
}

Então(/o sistema terá um bilhete associado a janela '(.*)'/) {String janela  ->
   
   assert $(By.xpath("//tr[1]/td[.='${janela}']")) != null
   page.botaoLimpar.click()
   Thread.sleep(5000)
}