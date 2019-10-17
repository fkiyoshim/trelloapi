import pages.*
import geb.*
import db.*
import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By





Quando(/preenche o filtro Título '(.*)'/) { String titulo ->
   Thread.sleep(5000);
   at FiltrosBilhetePage
   waitFor(30){  
     page.filtroTitulo.value(titulo);
   }
   Thread.sleep(1000);
}

Então(/o sistema exibe o bilhete criado '(.*)'/) {String resultado  ->

  at ListaPage
  assert waitFor(30){page.resultadoBusca_1_4.text()}==resultado
  
}

Dado(/que foi importado uma janela MCI/) {  ->
    def queryJanela_3 = db.execute2("UPDATE Process p SET p.active=0 WHERE p.processname='Siloms-Maintenance-Window-Mediator'")

}

