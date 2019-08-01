package com.dotcom.direct.app.util;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class KeyPairGen {

  private PrivateKey priv;
  private PublicKey  pub;
  private Cipher     cipher;

  public KeyPairGen() {
    
  }
  
  
  public byte[] encryptMsg(byte[] input, PrivateKey key) {
    //System.out.println("encryptMsg");
    if (key == null) return null;
    try {
      cipher = Cipher.getInstance("RSA");
      cipher.init(Cipher.ENCRYPT_MODE, key);
      byte[] msg = cipher.doFinal(input);
      return msg; 
    }catch(Exception e) {
      System.out.println(e.toString());
    }
    return null;
  }

  public byte[] decryptMsg(byte[] input, PublicKey key) {
    //System.out.println("decryptMsg");
    if (key == null) return null;
    try {
      cipher = Cipher.getInstance("RSA");
      cipher.init(Cipher.DECRYPT_MODE, key);
      byte[] msg = cipher.doFinal(input); 
      return msg;
    }catch(Exception e) {
      System.out.println(e.toString());
    }
    return null;
  }

  public PrivateKey getPriv() {
    return priv;
  }
  public PublicKey getPub() {
    return pub;
  }
  
  public PrivateKey getPrivateKEY(String key) {
    //System.out.println("getPrivateKEY");
    try {
      byte[] keyBytes = this.getByteKey(key);      
      PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
      KeyFactory kf = KeyFactory.getInstance("RSA");
      PrivateKey pk = kf.generatePrivate(spec);
      return pk;
    }catch(Exception e) {
      System.out.println(e.toString());
    }
    return null;
  }
  
  public PublicKey getPublicKey(String key) {
    //System.out.println("getPublicKey");
    try {
      Base64.Decoder b64d = Base64.getDecoder();
      byte[] keyBytes =   b64d.decode(key.getBytes());      
      X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
      KeyFactory kf = KeyFactory.getInstance("RSA");
      PublicKey pk = kf.generatePublic(spec);
      return pk;
    }catch(Exception e) {
      System.out.println(e.toString());
    }
    return null;
  }
  
  public String getStrKey(byte[] b) {
    Base64.Encoder b64e = Base64.getEncoder();
    return new String(b64e.encode(b));
  }

  public byte[] getByteKey(String s) {
    Base64.Decoder b64d = Base64.getDecoder();
    return b64d.decode(s.getBytes());
  }
  
  public void generate() {
    try {
      final KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
      final SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
      keyGen.initialize(1024, random);
      KeyPair pair = keyGen.generateKeyPair();
      this.priv = pair.getPrivate();
      this.pub  = pair.getPublic();
      //mostrar(pair);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void mostrar(KeyPair k) {
    Base64.Encoder b64e = Base64.getEncoder();
    RSAPublicKey pu = (RSAPublicKey) k.getPublic();
    RSAPrivateCrtKey pr = (RSAPrivateCrtKey) k.getPrivate();

    String chaveStr = new String(b64e.encode(pu.getEncoded()), StandardCharsets.UTF_8);
    Base64.Decoder b64d = Base64.getDecoder();
    byte[] chaveRSA = b64d.decode(chaveStr);

    System.out.println("");
    System.out.println(
        "=======================================================================================================");
    System.out.println("public algorithm   : " + pu.getAlgorithm());
    System.out.println("public encoded     : " + Arrays.toString(pu.getEncoded()));
    System.out.println("public encoded b64 : " + new String(b64e.encode(pu.getEncoded()), StandardCharsets.UTF_8));
    System.out.println("public encoded     : " + Arrays.toString(chaveRSA));
    System.out.println("public format      : " + pu.getFormat());
    System.out.println("public modulus     : " + pu.getModulus());
    System.out.println("public exponent    : " + pu.getPublicExponent());
    System.out.println("private algorithm  : " + pr.getAlgorithm());
    System.out.println("private encoded    : " + Arrays.toString(pr.getEncoded()));
    System.out.println("private encoded b64: " + new String(b64e.encode(pr.getEncoded()), StandardCharsets.UTF_8));
    System.out.println("private format     : " + pr.getFormat());
    System.out.println("private modulus    : " + pr.getModulus());
    System.out.println("private public exponent: " + pr.getPublicExponent());
    System.out.println("private exponent   : " + pr.getPrivateExponent());
    System.out.println("private prime P    : " + pr.getPrimeP());
    System.out.println("private prime Q    : " + pr.getPrimeQ());
    System.out.println("private prime exponent P: " + pr.getPrimeExponentP());
    System.out.println("private prime exponent Q: " + pr.getPrimeExponentQ());
    System.out.println("private CRT coefficient: " + pr.getCrtCoefficient());
    System.out.println(
        "=======================================================================================================");
  }

}
