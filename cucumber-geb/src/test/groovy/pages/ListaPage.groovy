package pages

import org.openqa.selenium.By
import pages.base.BasePage

class ListaPage extends BasePage {
    static at = { title == "CPqD Intelligent Management" }
	static content = {

		//botão inclusão
		buttonIncluir {$(By.xpath("//button[.='Incluir']"),0)}
		//botão de visualização
		buttonVisualizar {$(By.xpath("//button[.='Visualizar']"),0)} 
		//botão de editar
		buttonEditar {$(By.xpath("//button[.='Editar']"),0)} 
        //botão limpar filtros
		limparFiltro {$(By.xpath(".//button[@title='Limpar filtros']"))} 
        
		//linha 1, coluna 1
		resultadoBusca_1_1 {$(By.xpath("//*[contains(@id, 'DataTableId_data')]/tr[1]/td[1]"))}
		//linha 1, coluna 2
		resultadoBusca_1_2 {$(By.xpath("//*[contains(@id, 'DataTableId_data')]/tr[1]/td[2]"))}
		//linha 1, coluna 3
		resultadoBusca_1_3 {$(By.xpath("//*[contains(@id, 'DataTableId_data')]/tr[1]/td[3]"))}
        //linha 1, coluna 4
		resultadoBusca_1_4 {$(By.xpath("//*[contains(@id, 'DataTableId_data')]/tr[1]/td[4]"))}

        //mensagem de sucesso
	    msg_inclusao_ok {$(By.xpath("//*[contains(text(), 'A operação foi realizada com sucesso')]"),0)}
		
	}
}