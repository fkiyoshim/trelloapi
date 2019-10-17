/**
 * Example of writing custom application-specific steps
 */

import pages.*

import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By

Dado(~/que o usuário esteja na tela de login/) { ->
  to LoginPage

  
  }

Quando(~/ele inserir o username '(.*)'/){ String username ->
  waitFor(30){
    page.user.value(username)    
  }
  
}

E(~/ele inserir o password '(.*)'/) { String password ->
  //Javascript para intergir com o input type='password'
  //page.mudainputpassword()

  waitFor(30){
    page.password.value(password)
  
  }
}

E(~/ele acessar o sistema/) {->
  waitFor(30){
    page.submitButton.click()
  }
}

Então(~/ele estará no dasboard/) {->
  Thread.sleep(2000)
  
  //page.browser.driver.manage().window().maximize(); //page.maximixar()
  //page.browser.driver.manage().window().fullscreen();          
  at DashboardPage
}
