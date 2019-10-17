import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By
import geb.*


Dado(/que exista uma janela MCI/) {  ->
    
}

Quando(/o SILOMS encerra a janela '(.*)' com data final e cd_status='(.*)'/) { String inoperancia, Integer cd_status ->
  
    def queryJanela_fechar_04 = db.execute("UPDATE V_INOPERANCIA_CGTEC t SET t.dt_real_restab=TO_DATE(TO_CHAR(sysdate, 'MM/DD/YYYY') || ' 14:30:00', 'MM/DD/YYYY hh24:mi:ss'), t.cd_status=${cd_status} WHERE t.nr_inoperancia='${inoperancia}'")
    

}

Quando(/o SILOMS encerra a janela '(.*)' com cd_status='(.*)'/) { String inoperancia, Integer cd_status ->
     
    def queryJanela_fechar_11 = db.execute("UPDATE V_INOPERANCIA_CGTEC t SET t.cd_status=${cd_status} WHERE t.nr_inoperancia='${inoperancia}'")

}

Então(/o sistema encerra a janela/) {  ->
    
}

Quando(/o SILOMS atualiza a data final planejada da janela '(.*)'/) { String inoperancia ->
    def queryJanela_atualizar = db.execute("UPDATE V_INOPERANCIA_CGTEC t SET t.dt_prev_restab=TO_DATE(TO_CHAR(sysdate, 'MM/DD/YYYY'), 'MM/DD/YYYY') + 7 WHERE t.nr_inoperancia='${inoperancia}'")
}

Então(/o IM altera a data final planejada/) {  ->
    Thread.sleep(5000)
}