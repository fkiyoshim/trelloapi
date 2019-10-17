package db

import geb.ConfigurationLoader
import groovy.sql.Sql

class DBAccess2 {

   def config2

   def user2
   def password2
   def url2
   def driver2

   public DBAccess2(file){
      config2 = new Properties()
      file.withInputStream {
         stream -> config2.load(stream)
      }
      driver2="oracle.jdbc.driver.OracleDriver"
      configAccess()
   }

   def isConfigured(){
      config2.user2 && config2.password2 && config2.url2
   }

   def isReady(){
     if(!isConfigured()){
        throw new RuntimeException("There is no configured connection, check your database.properties")
     }
   }

   private def configAccess(){
     user2=config2.user2
     password2=config2.password2
     url2=config2.url2
     println "Data base access configured for: user2=$user2 password2=$password2 url2=$url2"

   }

   def initialize(user2, password2, url2){
     this.user2=user2
     this.password2=password2
     this.url2=url2
     if(!isConfigured()){
       configAccess()

     }
   }

   def execute2(sqlStatement){
     isReady()
     Sql.withInstance(url2, user2, password2, driver2) { sql ->
        sql.execute(sqlStatement)
     }
   }


   def query(sqlStatement, userNew2, passwordNew2, urlNew2){
     isReady()

     def columnTypes = [:]
     def metaClosure = { metaData ->
       /* I'm called once by Sql.eachRow() with a ResultSetMetaData. */
       columnTypes = (1..metaData.columnCount).collectEntries {
               [(metaData.getColumnName(it)): metaData.getColumnType(it)]
           }
     }

     def result

     if (urlNew2 != null){
       url2 = urlNew2
       user2 = userNew2
       password2 = passwordNew2
     }

     Sql.withInstance(url2, user2, password2, driver2) { sql ->
       def rows = sql.rows(sqlStatement)
       result = rows
     }
    result
   }
}
