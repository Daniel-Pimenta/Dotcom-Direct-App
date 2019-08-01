/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotcom.direct.app.service;

import com.dotcom.direct.app.model.Block;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Daniel Pimenta
 */
public class BlockService {

  
  
  private Block connect(String url, Block b) {
    System.out.println("connect");
    try {
      Client client = ClientBuilder.newClient();
      WebTarget target = client.target(url);
      Block block = target.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(b, MediaType.APPLICATION_JSON_TYPE), Block.class);
      return block;
    } catch (Exception e) {
      System.out.println("ERRO connect:"+e.toString());
    }
    return null;
  }

  public Block getBlock(Block b) {
    System.out.println("getBlock");
    try {
      Block jsonBlock = connect("http://localhost:8080/api/id", b);
      if (jsonBlock == null) {
        return null;
      }
      // ObjectMapper mapper = new ObjectMapper();
      // Block block = mapper.readValue(jsonStr, Block.class);
      return jsonBlock;
    } catch (Exception e) {
      System.out.println("ERRO getBlock:"+e.toString());
    }
    return null;
  }

}
