/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotcom.direct.app.model;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;
import io.jsondb.annotation.Secret;


/**
 *
 * @author Daniel Pimenta
 */

@Document(collection = "contatos", schemaVersion= "1.0")
public class Contatos {

  @Id 
  private String  id;
  private String  ip;
  private int     porta;
  private boolean onLine;
  private String  PrivateKey;  

  /**
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * @return the ip
   */
  public String getIp() {
    return ip;
  }

  /**
   * @param ip the ip to set
   */
  public void setIp(String ip) {
    this.ip = ip;
  }

  /**
   * @return the porta
   */
  public int getPorta() {
    return porta;
  }

  /**
   * @param porta the porta to set
   */
  public void setPorta(int porta) {
    this.porta = porta;
  }

  /**
   * @return the onLine
   */
  public boolean isOnLine() {
    return onLine;
  }

  /**
   * @param onLine the onLine to set
   */
  public void setOnLine(boolean onLine) {
    this.onLine = onLine;
  }

  /**
   * @return the PrivateKey
   */
  public String getPrivateKey() {
    return PrivateKey;
  }

  /**
   * @param PrivateKey the PrivateKey to set
   */
  public void setPrivateKey(String PrivateKey) {
    this.PrivateKey = PrivateKey;
  }


  
  
}
