package pages

import org.openqa.selenium.By
import pages.base.BasePage

class Mapa_InoperanciaPage extends BasePage {
    static at = { title == "CPqD Intelligent Management" }
	static content = {

		
		icone_laranja {$(By.xpath("//*[contains(@src, 'site_map_orange.png')]"))}
		
	}
}