/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/**
 * Ejemplo de encriptado y desencriptado con algoritmo AES. Se apoya en
 * RSAAsymetricCrypto.java para salvar en fichero o recuperar la clave de
 * encriptación.
 *
 * @author Chuidiang
 *
 */
public class Cifrar {

    public static void main(String[] args) throws Exception {
        Cifrar c = new Cifrar();
//        byte[] uno = c.ecriptar("Hola lhdfjhdfjlh");
//        System.out.println(uno);
//        for (int i = 0; i < uno.length; i++) {
//            System.out.println(uno[i]);
//        }
//
//        for (byte b : uno) {
//            System.out.print(Integer.toHexString(0xFF & b));
//        }
//        System.out.println();
//        System.out.println();
//
//        String dos = c.desincriptar(uno);
//        System.out.println(dos);
          String d = c.encriptart("jhgj");
          System.out.println(d);
          String cd= c.desencrip(d);
     
          System.out.println(cd);
          
  
    }
    public  String encriptart(String s) throws UnsupportedEncodingException{
        return Base64.getEncoder().encodeToString(s.getBytes("utf-8"));
    }
    
    public  String desencrip(String s) throws UnsupportedEncodingException{
        byte [] decode = Base64.getDecoder().decode(s.getBytes());
        return new String(decode,"utf-8");
    }
    
}
