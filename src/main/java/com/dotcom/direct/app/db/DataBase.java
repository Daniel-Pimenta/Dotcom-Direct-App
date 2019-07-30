/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotcom.direct.app.db;

import io.jsondb.JsonDBTemplate;
import io.jsondb.crypto.DefaultAESCBCCipher;
import io.jsondb.crypto.ICipher;
import java.io.File;

/**
 *
 * @author Daniel Pimenta
 */
public class DataBase {
  
  private JsonDBTemplate jsonDBTemplate = null;
 

  //Java package name where POJO's are present
  private String baseScanPackage = "com.dotcom.direct.app.model";
  
  private String msgErr;
  
  public void DataBase(){
    
  }

  public JsonDBTemplate init() {
    try {   
      System.out.println("Conectando...");
      ICipher cipher = new DefaultAESCBCCipher("1r8+24pibarAWgS85/Heeg==");
      String dbFilesLocation = System.getProperty("user.home")+ File.separator+"jsondb";
      System.out.println(dbFilesLocation);
      jsonDBTemplate = new JsonDBTemplate(dbFilesLocation, baseScanPackage, cipher);
      return jsonDBTemplate;
    } catch (Exception e) {
      msgErr = e.getMessage();
    }
    return null;
  }
  
  public String getMsgErr(){
    return msgErr;
  }

}
