/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotcom.direct.app.model;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;
import io.jsondb.annotation.Secret;
import java.util.Date;


/**
 *
 * @author Daniel Pimenta
 */

@Document(collection = "contatos", schemaVersion= "1.0")
public class Contatos {

  @Id 
  private String  id;
  @Secret
  private String  nome;
  private String  ip;
  private int     porta;
  private boolean onLine;
  private Date    lastOnLine;
  private String  privateKey;  

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public int getPorta() {
    return porta;
  }

  public void setPorta(int porta) {
    this.porta = porta;
  }

  public boolean isOnLine() {
    return onLine;
  }

  public void setOnLine(boolean onLine) {
    this.onLine = onLine;
  }

  public Date getLastOnLine() {
    return lastOnLine;
  }

  public void setLastOnLine(Date lastOnLine) {
    this.lastOnLine = lastOnLine;
  }

  public String getPrivateKey() {
    return privateKey;
  }

  public void setPrivateKey(String privateKey) {
    this.privateKey = privateKey;
  }
  

}
