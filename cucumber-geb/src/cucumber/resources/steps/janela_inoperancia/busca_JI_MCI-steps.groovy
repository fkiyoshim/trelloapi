import pages.*
import geb.*
import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By

E(/que o processo Siloms-Maintenance-Window-Mediador esteja ativo/) {  ->
    
}

E(/clique no menu Configuração/) {  ->
    Thread.sleep(1000);
    waitFor(30){
    
      page.menuConfiguracao.jquery.mouseover()
   }
}

Dado(/clique no submenu Janela inoperância/) {  ->
   Thread.sleep(1000);
   waitFor(30){  
      page.submenuJanelaInoperancia.click()
   }
}

Dado(/na tela de lista de janelas filtrar pela inoperância '(.*)'/) { String inoperancia ->
   Thread.sleep(5000);
   at JanelaInoperanciaPage
   waitFor(30){  
      page.filtroInoperancia.value(inoperancia);
   }
   Thread.sleep(5000);
}

Então(/o sistema exibe a janela de inoperancia '(.*)'/) { String resultado ->
  Thread.sleep(4000)
  at ListaPage
  assert page.resultadoBusca_1_1.text() == resultado
  Thread.sleep(5000)
}

