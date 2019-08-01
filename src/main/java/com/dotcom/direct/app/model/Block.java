/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotcom.direct.app.model;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

import java.security.PublicKey;
import java.util.Date;

/**
 *
 * @author Daniel Pimenta
 */
@Document(collection = "block", schemaVersion= "1.0")
public class Block {

  @Id
  private String    id;
  private Date      data;
  private String    ip;
  private int       porta;
  private String    mensagem;
  private String    hash;
  private String    hashAnt;
  private String    publicKey;
  public String getId() {
    return id;
  }
  public Date getData() {
    return data;
  }
  public String getIp() {
    return ip;
  }
  public int getPorta() {
    return porta;
  }
  public String getMensagem() {
    return mensagem;
  }
  public String getHash() {
    return hash;
  }
  public String getHashAnt() {
    return hashAnt;
  }
  public String getPublicKey() {
    return publicKey;
  }
  public void setId(String id) {
    this.id = id;
  }
  public void setData(Date data) {
    this.data = data;
  }
  public void setIp(String ip) {
    this.ip = ip;
  }
  public void setPorta(int porta) {
    this.porta = porta;
  }
  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }
  public void setHash(String hash) {
    this.hash = hash;
  }
  public void setHashAnt(String hashAnt) {
    this.hashAnt = hashAnt;
  }
  public void setPublicKey(String publicKey) {
    this.publicKey = publicKey;
  }
  



  
}
