package pages

import org.openqa.selenium.By
import pages.base.BasePage
import org.junit.AfterClass
import org.junit.Assert
import org.junit.BeforeClass

class IncluirBilhetePage extends BasePage {
	//private static String elemento = null;
    static at = { title == "CPqD Intelligent Management" }
	static content = {
        
		//campo titulo
		titulo {$(By.cssSelector("input[id*='Title']"))}
		//campo modelo
        combomodelo {$(By.xpath("//label[.='* Modelo:']/../../div[2]/div/div[3]"))}
		//campo prioridade
		comboprioridade {$(By.xpath("//*[@id='form:flowPriority']/div[3]/span"))}
		//cmpo responsávels
		comboresponsavel {$(By.xpath("//*[@id='form:txtResponsible']/div[3]/span"))}
		
		//Dados do recurso
		//botão de lupa
		botaolupa {$(By.cssSelector("button[id*='buttonAddResource']"),0)} 

        //Filtrar recursos cadastrados
		//botão buscar
		botaobuscar {$(By.xpath("//span[.='Buscar']"))}
		//selecionar primeira linha
		itemrecurso {$(By.xpath("//*[contains(@id, 'tableSelect')]/tr[1]/td[1]"))}
		//botão confirmar
		botaoconfirmar {$(By.xpath("//*[contains(@id, 'Filter')]/span[.='Confirmar']"))}

        botaoconfirmar2 {$(By.cssSelector("button[id*='btnConfirm']"))}

        //aba anotação
		abaAnotacao {$(By.xpath("//a[.='Anotação']"))}
        //incluir subanotação
		botaoIncluirSubAnotacao {$(By.xpath("//button[contains(@id, 'btnNewSubComment')]"),0)}
        //texto subanotaçao
		textoSubAnotacao {$(By.xpath("//textarea[contains(@id, 'txtareaAnnotation')]"),1)}
		//confirmar subanotação
		botaoConfirmarSubAnotacao {$(By.xpath("//button[contains(@id, 'newAnnotationForm')]/span[.='Confirmar']"))}
	
		
	}
	@BeforeClass
	public static void primeiro() {
		println ""
	}
}