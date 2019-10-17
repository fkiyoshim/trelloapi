import pages.*
import geb.*
import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By


Dado(/que esteja conecto no banco de dados/) {  ->

}

Dado(/queira excluir o bilhete com título '(.*)'/) { String titulo ->
    Thread.sleep(5000)
    def queryINSTANCE_ALERT = db.execute("delete from WF_INSTANCE_ALERT where INSTANCE_ID in (select id from WF_INSTANCE where title like '${titulo}')")
    def queryINSTANCE_CHANGE = db.execute("delete from WF_INSTANCE_CHANGE where INSTANCE_ID in (select id from WF_INSTANCE where title like '${titulo}')")
    def queryINSTANCE_COMMENT = db.execute("delete from WF_INSTANCE_COMMENT where INSTANCE_ID in (select id from WF_INSTANCE where title like '${titulo}')")
    def queryINSTANCE_RESOURCE = db.execute("delete from WF_INSTANCE_RESOURCE where INSTANCE_ID in (select id from WF_INSTANCE where title like '${titulo}')")
    def queryINSTANCE_TRANSITION = db.execute("delete from WF_INSTANCE_TRANSITION where INSTANCE_ID in (select id from WF_INSTANCE where title like '${titulo}')")
    def queryINSTANCE = db.execute("delete from WF_INSTANCE t where t.title like '${titulo}'")
}

