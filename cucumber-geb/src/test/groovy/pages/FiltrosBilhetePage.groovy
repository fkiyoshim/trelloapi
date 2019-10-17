package pages

import org.openqa.selenium.By
import pages.base.BasePage

class FiltrosBilhetePage extends BasePage {
    static at = { title == "CPqD Intelligent Management" }
	static content = {

		//Filtro titulo
		filtroTitulo {$(By.cssSelector("input[id*='colTitle']"))} 


		
		
	}
}