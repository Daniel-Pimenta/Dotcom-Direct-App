/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotcom.direct.app;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Arrays;

import com.dotcom.direct.app.db.DataBase;
import com.dotcom.direct.app.model.Block;
import com.dotcom.direct.app.model.Contatos;
import com.dotcom.direct.app.repository.ContatosRepository;
import com.dotcom.direct.app.service.BlockService;
import com.dotcom.direct.app.util.KeyPairGen;

import io.jsondb.JsonDBTemplate;

/**
 *
 * @author Daniel Pimenta
 */
public class App {

  private ContatosRepository cr;
  private BlockService bs;
  private KeyPairGen key;

  public void App() {
  }
  
  public static void main(String args[]) {
    System.out.println("INICIO:" + new java.util.Date());
    App app = new App();
    app.init();
  }

  private void init() {
    key = new KeyPairGen();
    key.generate();
    
    String strKeyPub = key.getStrKey(key.getPub().getEncoded());
    String strKeyPri = key.getStrKey(key.getPriv().getEncoded());
    
    System.out.println("strKeyPub :" + strKeyPub);
    System.out.println("strKeyPri :" + strKeyPri);
    
    try {
      //
      byte[] in = key.encryptMsg("Ola Mundo".getBytes(), key.getPrivateKEY(strKeyPri));
      System.out.println("EmCript:" + new String(in, StandardCharsets.UTF_8));
      //
      byte[] out = key.decryptMsg(in, key.getPublicKey(strKeyPub));
      System.out.println("DeCript:" + new String(out));
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
  private void createKey() {
    key = new KeyPairGen();
    key.generate();
  }

  private void newContato() {
    cr = new ContatosRepository();
    cr.init();
    cr.addContato();
  }

}
