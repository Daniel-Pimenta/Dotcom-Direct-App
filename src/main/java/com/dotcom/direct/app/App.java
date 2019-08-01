/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotcom.direct.app;

import com.dotcom.direct.app.model.Block;
import com.dotcom.direct.app.model.Eu;
import com.dotcom.direct.app.repository.ContatosRepository;
import com.dotcom.direct.app.repository.EuRepository;
import com.dotcom.direct.app.service.BlockService;
import com.dotcom.direct.app.util.KeyPairGen;


/**
 *
 * @author Daniel Pimenta
 */
public class App {

  private ContatosRepository cr;
  private EuRepository er;
  
  private BlockService bs;
  
  private KeyPairGen key;

  public App() {
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

    try {
      //
      String msg = "Ola Mundo";

      byte[] crptMsg = key.encryptMsg( msg.getBytes(), key.getPrivateKEY(strKeyPri));
      byte[] dcrptMsg = key.decryptMsg(crptMsg, key.getPublicKey(strKeyPub));

     
      bs = new BlockService();
      
      Block b = new Block();
      b.setPublicKey(strKeyPub);
      Block newBlock = this.bs.getBlock(b);
      System.out.println(newBlock.getId());
      
      Eu eu = new Eu();
      eu.setId(newBlock.getId());
      eu.setIp(newBlock.getIp());
      eu.setPorta(63210);
      eu.setHashBlock(newBlock.getHash());
      eu.setPrivateKey(strKeyPri);
      eu.setPublicKey(strKeyPub);
      eu.setNome("DANIEL S PIMENTA");
      er = new EuRepository();
      er.init();
      er.save(eu);
      
    } catch (Exception e) {
      System.out.println("ERRO:"+e.toString());
    }
  }
  
  private void createKey() {
    key = new KeyPairGen();
    key.generate();
  }

  private void newContato() {

  }

}
