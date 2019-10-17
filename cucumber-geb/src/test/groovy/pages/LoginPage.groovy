package pages

import org.openqa.selenium.By
import pages.base.BasePage

class LoginPage extends BasePage {

	static content = {

		//submitButton {$(By.xpath("//*[@id='form:j_idt24']/span"))} 
		//campo usuário
		user {$(By.cssSelector("input[id*='TextUsername']"))}  
       //campo senha
	   password {$(By.cssSelector("input[id*='TextPassword']"))} //password {$(By.xpath("//*[@id='form:inputTextPassword']"))}
    
		//botão entrar
		submitButton {$(By.xpath("//button[.='Entrar']"))}  //By.xpath("//button[.='"+texto+"']")
	}

	//Javascript para intergir com o input type='password'
	def mudainputpassword(){
		
	  browser.driver.executeScript("document.getElementById('j_password').setAttribute('type', 'text');");
	  Thread.sleep(500)
	  browser.driver.executeScript("document.getElementById('j_password').type = 'text';");
	  Thread.sleep(500)
	  browser.driver.executeScript("document.getElementById('j_password').focus();");
	  Thread.sleep(500)
	}

	def maximixar(){
		
	  browser.driver.manage().window().maximize();
	}







}
