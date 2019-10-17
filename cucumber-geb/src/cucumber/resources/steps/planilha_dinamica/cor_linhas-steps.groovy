import pages.*
import geb.*
import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By

def temp=8000

Dado(/clique no menu Recurso/) {  ->
    waitFor(temp){
      page.menuRecurso.jquery.mouseover()
   }
}

Dado(/clique no submenu Planilha dinâmica recurso, janela e bilhete/) {  ->
    waitFor(temp){
      page.submenuPlanilhaDinamica.click()
   }
}

Quando(/o recurso '(.*)' não possui janela de inoperância/) {String recurso  ->
   Thread.sleep(5000);
   at PlanilhaDinamicaPage
   waitFor(30){  
     page.filtroRecurso.value(recurso);
   }
   Thread.sleep(5000);
}

Então(/o sistema não colore a linha/) {  ->
       Thread.sleep(5000);
       //assert $(By.xpath("//tbody/tr[contains(@class, 'setColor')]")) ==

}

Quando(/o recurso da janela '(.*)' possui janela de inoperância e ação igual a Inclusão/) {String janela  ->
   Thread.sleep(5000);
   at PlanilhaDinamicaPage
   waitFor(30){  
     page.filtroInoperancia.value(janela);
   }
   Thread.sleep(5000);
}

Então(/o sistema colore a linha com fundo Laranja/) {  ->
       Thread.sleep(5000);
       $(By.xpath("//tbody/tr[contains(@class, 'setColorMajor')]"),0).click()
       assert $(By.xpath("//tbody/tr[contains(@class, 'setColorMajor')]"),0) != null
       assert $(By.xpath("//tr[1]/td[.='Inclusão']")) != null
}

Quando(/o recurso da janela '(.*)' possui janela de inoperância e ação igual a Alteração/) {String janela  ->
   Thread.sleep(5000);
   at PlanilhaDinamicaPage
   waitFor(30){  
     page.filtroInoperancia.value(janela);
   }
   Thread.sleep(5000);
}

Então(/o sistema colore a linha com fundo Amarelo/) {  ->
       Thread.sleep(5000);
       $(By.xpath("//tbody/tr[contains(@class, 'setColorMinor')]"),0).click()
       assert $(By.xpath("//tbody/tr[contains(@class, 'setColorMinor')]"),0) != null
       assert $(By.xpath("//tr[1]/td[.='Alteração']")) != null
}

Quando(/o recurso da janela '(.*)' possui janela de inoperância e ação igual a Finalização/) {String janela  ->
   Thread.sleep(5000);
   at PlanilhaDinamicaPage
   waitFor(30){  
     page.filtroInoperancia.value(janela);
   }
   Thread.sleep(5000);
}

Então(/o sistema colore a linha com fundo Verde/) {  ->
   Thread.sleep(5000);
   $(By.xpath("//tbody/tr[contains(@class, 'setColorClear')]"),0).click()
   assert $(By.xpath("//tbody/tr[contains(@class, 'setColorClear')]"),0) != null
   assert $(By.xpath("//tr[1]/td[.='Finalização']")) != null
}