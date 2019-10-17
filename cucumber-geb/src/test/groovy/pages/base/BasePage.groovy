package pages.base

import geb.Page

class BasePage extends Page {

  def switchTo(page){

    waitFor(30){
      //Faz o switch na janela aberta como popup
      def newWindow
        browser.drive{
            withWindow{isAt page } {
              newWindow = browser.currentWindow
            }
        }
     browser.switchToWindow(newWindow)
    }
  }


}
