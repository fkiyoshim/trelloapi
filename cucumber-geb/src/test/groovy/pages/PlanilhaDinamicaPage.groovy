package pages

import org.openqa.selenium.By
import pages.base.BasePage

class PlanilhaDinamicaPage extends BasePage {
    static at = { title == "CPqD Intelligent Management" }
	static content = {

		//Filtro inoperancia
       filtroInoperancia {$(By.xpath("//span[.='Inoperância']/../input"))}
        //Filtro recurso
	   filtroRecurso {$(By.xpath("//span[.='Recurso']/../input"))}
		
		
	}
}