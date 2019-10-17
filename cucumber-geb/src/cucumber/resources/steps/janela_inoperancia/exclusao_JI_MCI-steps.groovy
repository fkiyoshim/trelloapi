
import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By
import geb.*

Dado(/que foi excluido as janelas de inoperancia existentes/) {  ->

    def queryJanela_1 = db.execute("DELETE V_PROVIDENCIA_INOP_CGTEC where nr_inoperancia like '%1000%'")
    def queryJanela_2 = db.execute("DELETE V_INOPERANCIA_CGTEC where nr_inoperancia like '%1000%'")
    def queryJanela_3 = db.execute("UPDATE WF_INSTANCE SET parentid=null WHERE parentid is not null")
    def queryJanela_4 = db.execute("DELETE WF_INSTANCE_ALERT where INSTANCE_ID in (select id from WF_INSTANCE where title like '%1000%')")
    def queryJanela_5 = db.execute("DELETE WF_INSTANCE_CHANGE where INSTANCE_ID in (select id from WF_INSTANCE where title like '%1000%')")
    def queryJanela_6 = db.execute("UPDATE WF_INSTANCE_COMMENT SET parent=null WHERE parent is not null and INSTANCE_ID in (select id from WF_INSTANCE where identifier like '%MCI%')")
    def queryJanela_7 = db.execute("DELETE WF_INSTANCE_COMMENT where INSTANCE_ID in (select id from WF_INSTANCE where title like '%1000%')")
    def queryJanela_8 = db.execute("DELETE WF_INSTANCE_RESOURCE where INSTANCE_ID in (select id from WF_INSTANCE where title like '%1000%')")
    def queryJanela_9 = db.execute("DELETE WF_INSTANCE_TRANSITION where INSTANCE_ID in (select id from WF_INSTANCE where title like '%1000%')")
    def queryJanela_10 = db.execute("DELETE WF_INSTANCE where title like '%1000%'")
    def queryJanela_11 = db.execute("DELETE RESOURCES_MAINTENANCE where maintenance_ID in (select id from maintenance where name like '%1000%')")
    def queryJanela_12 = db.execute("DELETE MAINTENANCE_COMMENT where maintenance_ID in (select id from maintenance where name like '%1000%')")
    def queryJanela_13 = db.execute("DELETE MAINTENANCE where name like '%1000%'")
    def queryJanela_14 = db.execute("UPDATE Equipment t SET t.maintenance=0 WHERE t.maintenance=1")
    def queryJanela_15 = db.execute("UPDATE corr_alert t SET t.maintenance=0 WHERE t.maintenance=1")
    Thread.sleep(5000)
}