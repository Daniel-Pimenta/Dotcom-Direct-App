/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotcom.direct.app.service;

import com.dotcom.direct.app.model.Block;
import com.dotcom.direct.app.model.Eu;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author Daniel Pimenta
 */
public class BlockService {

  private String connect(String url) {
    Client client = ClientBuilder.newClient();
    WebTarget target = client.target(url);
    String json = target.request().get(String.class);
    return json;
  }

  public Eu getId() {
    try {
      String json = connect("http://localhost:8080/api/id");
      ObjectMapper mapper = new ObjectMapper();
      Block block = mapper.readValue(json, Block.class);
      Eu eu = new Eu();
      eu.setId(block.getId());
      eu.setIp(block.getIp());
      eu.setPorta(63065);
      eu.setHashBlock(block.getHash());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

}
