/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotcom.direct.app.repository;

import com.dotcom.direct.app.db.DataBase;
import com.dotcom.direct.app.model.Contatos;
import io.jsondb.InvalidJsonDbApiUsageException;
import io.jsondb.JsonDBTemplate;

/**
 *
 * @author Daniel Pimenta
 */
public class ContatosRepository {

  private DataBase db;
  private JsonDBTemplate jsonDBTemplate;

  public void init() {
    db = new DataBase();
    jsonDBTemplate = db.init();
    if (jsonDBTemplate == null) {
      System.out.println("Erro de Coneção:" + db.getMsgErr());
    } else {
      if (!jsonDBTemplate.collectionExists(Contatos.class)) {
        System.out.println("Criando DB Contatos...");
        jsonDBTemplate.createCollection(Contatos.class);
      } else {
        System.out.println("DB Contatos já criado...");
      }
    }
  }

  public void addContato() {
    System.out.println("Add Contato...");

    Contatos c = new Contatos();
    c.setId("PNF1920");
    c.setNome("Contato 2");
    //c.setPrivateKey("b87eb02f5dd7e5232d7b0fc30a5015e4
    try {
      jsonDBTemplate.insert(c);
    } catch (InvalidJsonDbApiUsageException e) {
      System.out.println("Este ID Contato ja existe !");
    }
  }

}
