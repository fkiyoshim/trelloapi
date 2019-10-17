package pages

import org.openqa.selenium.By
import pages.base.BasePage

class JanelaInoperanciaPage extends BasePage {
    static at = { title == "CPqD Intelligent Management" }
	static content = {

		//filtro inoperância
		filtroInoperancia {$(By.cssSelector("input[id*='colName']"))}
		
		
	}
}