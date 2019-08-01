/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotcom.direct.app.repository;

import com.dotcom.direct.app.db.DataBase;
import com.dotcom.direct.app.model.Eu;
import io.jsondb.JsonDBTemplate;

/**
 *
 * @author Daniel Pimenta
 */
public class EuRepository {
  
  private DataBase db;
  private JsonDBTemplate jsonDBTemplate;

  public void init() {
    db = new DataBase();
    jsonDBTemplate = db.init();
    if (jsonDBTemplate == null) {
      System.out.println("Erro de Coneção:" + db.getMsgErr());
    } else {
      if (!jsonDBTemplate.collectionExists(Eu.class)) {
        System.out.println("Criando DB Eu...");
        jsonDBTemplate.createCollection(Eu.class);
      } else {
        System.out.println("Eu Contatos já criado...");
      }
    }
  }
  
  public void save(Eu eu) {
    System.out.println("Add Eu...");
    try {
      jsonDBTemplate.upsert(eu);
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }
  
}
