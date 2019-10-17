import pages.*
import geb.*
import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By

Quando(/seleciona o botão de Editar/) {  ->
  waitFor(30){  
     page.botaoEditar.click()
   }
   Thread.sleep(1000);
}

Quando(/seleciona a aba Anotação/) {  ->
   at IncluirBilhetePage
   waitFor(30){  
     page.abaAnotacao.click()
   }
   Thread.sleep(1000);
}

Quando(/inclui a subanotação '(.*)'/) { String subanotacao ->
   waitFor(30){  
     page.botaoIncluirSubAnotacao.click()
   }
   Thread.sleep(5000);
  
  waitFor(30){  
     page.textoSubAnotacao.value(subanotacao);
   }
  Thread.sleep(1000);
  page.botaoConfirmarSubAnotacao.click()
  //Thread.sleep(7000);
}
