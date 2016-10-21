package com.medical.DAO;

import com.mongodb.DB;
import com.mongodb.MongoClient;
 
public class DataConnect {
	
	 private static DB db;  
     
     //JDBCSingleton prevents the instantiation from any other class.  
       private  DataConnect() {}
		
         public static DB getdb() {    
          if (db==null)  
          {  
        	  try { 		
        		  MongoClient mongo = new MongoClient("localhost", 27017);
        		//  MongoClient mongo = new MongoClient("213.136.88.136", 27017);
                        db = mongo.getDB("swe");  
                        return db;
                   }  
              catch (Exception ex) {
                                   System.out.println("Database.getConnection() Error -->"
                                   + ex.getMessage());
                                   return null;
                                   }
           }
           else
               return db;
                         
             
         }
    }

