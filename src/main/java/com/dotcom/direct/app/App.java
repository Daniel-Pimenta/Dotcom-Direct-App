/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotcom.direct.app;

import com.dotcom.direct.app.db.DataBase;
import com.dotcom.direct.app.model.Contatos;
import com.dotcom.direct.app.repository.ContatosRepository;
import io.jsondb.JsonDBTemplate;

/**
 *
 * @author Daniel Pimenta
 */
public class App {

  ContatosRepository cr;
  
  public static void main(String args[]) {
    System.out.println("INICIO");
    App app = new App();
    app.init();
  }

 public void App() {  }
  
  private void init(){
    cr = new ContatosRepository();
    cr.init();
    cr.addContato();
  }

}
