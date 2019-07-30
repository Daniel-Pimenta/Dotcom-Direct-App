/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotcom.direct.app.model;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;
import java.util.Date;

/**
 *
 * @author Daniel Pimenta
 */
@Document(collection = "block", schemaVersion= "1.0")
public class Block {

  @Id
  private String id;
  private Date data;
  private String ip;
  private int porta;
  private String mensagem;
  private String hash;
  private String hashAnt;
  private boolean onLine;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
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

  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }

  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }

  public String getHashAnt() {
    return hashAnt;
  }

  public void setHashAnt(String hashAnt) {
    this.hashAnt = hashAnt;
  }

  public boolean isOnLine() {
    return onLine;
  }

  public void setOnLine(boolean onLine) {
    this.onLine = onLine;
  }
  

  
}
