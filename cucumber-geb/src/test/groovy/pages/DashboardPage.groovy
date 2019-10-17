package pages

import org.openqa.selenium.By
import pages.base.BasePage

class DashboardPage extends BasePage {
	static at = { title == "CPqD Intelligent Management" }
  static content ={
		    
        //Bilhete
        menuBilhete {$(By.xpath("//span[.='Bilhete']"),0)}
        submenuBilhete {$(By.xpath("//span[.='Bilhete']"),1)}

        //Mapa
        menuMapa {$(By.xpath("//span[.='Mapa']"),0)}
        submenuMapa {$(By.xpath("//span[.='Inoperância']"))}

        //Mapa
        menuConfiguracao {$(By.xpath("//span[.='Configuração']"),2)}
        submenuJanelaInoperancia {$(By.xpath("//span[.='Janela inoperância']"))}

        //Recurso
        menuRecurso {$(By.xpath("//span[.='Recurso']"),0)}
        submenuPlanilhaDinamica {$(By.xpath("//span[.='Planilha dinâmica']"))}



        //Item 1 tabela
        resutadoBusca {$(By.xpath("//tbody[contains(@id, 'DataTableId_data')]/tr[1]"))}
        //botao visualizar
        botaoVisualizar {$(By.xpath("//button/span[.='Visualizar']"))}
        //botão editar
        botaoEditar {$(By.xpath("//button/span[.='Editar']"))}
        //botão limpar
        botaoLimpar {$(By.xpath("//button[contains(@title, 'Limpar filtros')]"))}
        

  }
  
}
