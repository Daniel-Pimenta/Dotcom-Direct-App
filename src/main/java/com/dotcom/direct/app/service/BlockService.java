/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dotcom.direct.app.service;

import com.dotcom.direct.app.model.Block;
import com.dotcom.direct.app.model.Eu;
import com.dotcom.direct.app.util.KeyPairGen;
//
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.ProcessingException;
//
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

  private Block connect(String url, KeyPairGen key) {
    System.out.println("connect");
    try {
      Block newBlock = new Block();
      newBlock.setPublicKey(key.getPub());
      System.out.println("1");
      Client client = ClientBuilder.newClient();
      WebTarget target = client.target(url);
      System.out.println("2");
      Block block = target.request(MediaType.APPLICATION_JSON_TYPE)
          .post(Entity.entity(newBlock, MediaType.APPLICATION_JSON_TYPE), Block.class);
      return block;
    } catch (ProcessingException e) {
      System.out.println(e.toString());
    }
    return null;
  }

  public Block getId(KeyPairGen key) {
    System.out.println("getID");
    try {
      Block jsonBlock = connect("http://localhost:8080/api/id", key);
      if (jsonBlock == null)
        return null;
      //
      System.out.println(jsonBlock);
      //
      // ObjectMapper mapper = new ObjectMapper();
      // Block block = mapper.readValue(jsonStr, Block.class);
      return jsonBlock;
    } catch (Exception e) {
      System.out.println(e.toString());
    }
    return null;
  }

}
