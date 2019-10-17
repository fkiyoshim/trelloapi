
import pages.*

import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By



Dado(/que o usuário faça/) {  ->


 Thread.sleep(5000)
  println "texto";
  //$(By.xpath("//span[contains(@class, 'textFontTituloDash')]")).click
  $(By.xpath("//span")).size()

  def texto = $(By.xpath("//span")).size()
  println(texto);

  def texto2 = $(By.xpath("//span"),1).text()
  println("2="+texto2);








  //def csv = new File("Ducumentos\arquivo2.txt")
}
