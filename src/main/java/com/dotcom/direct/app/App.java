/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotcom.direct.app;

import com.dotcom.direct.app.db.DataBase;
import com.dotcom.direct.app.model.Contatos;
import io.jsondb.JsonDBTemplate;

/**
 *
 * @author Daniel Pimenta
 */
public class App {

  public static void main(String args[]) {
    System.out.println("INICIO");
    App app = new App();
    app.init();
  }

  public void App() {
    
  }
  
  public void init() {
    DataBase db = new DataBase();
    JsonDBTemplate jsonDBTemplate = db.init();
    if (jsonDBTemplate == null) {
      System.out.println("Erro de Coneção:"+db.getMsgErr());
    } else {
      jsonDBTemplate.createCollection(Contatos.class);
      //
      Contatos c = new Contatos();
      c.setId("11");
      c.setIp("ec2-54-191-11");
      //c.setPrivateKey("b87eb02f5dd7e5232d7b0fc30a5015e4");
      jsonDBTemplate.insert(c);
    }
  }

}
