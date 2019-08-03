/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criptografia;

import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
 
import javax.crypto.Cipher;

public class AES {
  
    //static String IV = "AAAAAAAAAAAAAAAA";
    //static String textopuro = "teste texto 12345678\0\0\0";
    //static String chaveencriptacao = "0123456789abcdef";
 
    public static byte[] encrypt(String textopuro, int k, String IV) throws Exception {
        String chaveencriptacao = expandKey(Integer.toString(k));
        Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
        encripta.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
        return encripta.doFinal(textopuro.getBytes("UTF-8"));
    }
 
    public static String decrypt(byte[] textoencriptado, int k, String IV) throws Exception{
        String chaveencriptacao = expandKey(Integer.toString(k));
        System.out.println(chaveencriptacao);
        Cipher decripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
        decripta.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
        return new String(decripta.doFinal(textoencriptado),"UTF-8");
    }
 
    public static String expandKey(String k){
       String key = "";
       for (int i = 0; i < 16; i++){
           key = key + k;
       }
       return key.substring(0, 16);
    }
 
    public static void main(String [] args) {
        System.out.println(expandKey(Integer.toString(25)));
        String chaveencriptacao = expandKey(Integer.toString(25));
        String IV = "AAAAAAAAAAAAAAAA";
        String textopuro = "teste texto 12345678\0\0\0";
        
        try {
            System.out.println("Texto Puro: " + textopuro);
            byte[] textoencriptado = encrypt(textopuro, 25, IV);
            System.out.print("Texto Encriptado: ");
            String cipherText = Base64.getEncoder().encodeToString(textoencriptado);
            System.out.print(Base64.getEncoder().encodeToString(textoencriptado));
            
            for (int i = 0; i < textoencriptado.length; i++)
                System.out.print(new Integer(textoencriptado[i]) + " ");

            System.out.println("");
            String textodecriptado = decrypt(cipherText.getBytes("windows-1252"), 25, IV);
            System.out.println("Texto Decriptado: " + textodecriptado);
        } catch (Exception e) {
            e.printStackTrace();
        }
 }
  
}
