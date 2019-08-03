/*
 * Seguranca Computacional 2019.1 - Prof. Dr. Valerio Rosset
 * Pratica 07 - Chat: Modulo do Modos de Cifra
 * Nome: Flavia Yumi Ichikura RA: 111791
 * Nome: Willian Dihanster Gomes de Oliveira RA: 112269	
 */
package criptografia;

import java.io.IOException;

public class CBC {

    /*Funcao para cifrar uma mensagem*/
    public String cifraMensagem(String msg, int key, SDES SDES, Integer[] iv) {
        String novaMsg = "";

        for (int i = 0; i < msg.length(); i++) {
            int a = (char) msg.charAt(i);
            Integer b = (Integer) a;
            Integer caracBin[] = SDES.intToBinary(b);
            Integer result[] = SDES.xor(caracBin, iv);
            Integer novo = SDES.binaryToInt(result);
            Integer resultInteger = SDES.cifrar(novo, key);
            int resultInt = (int) resultInteger;
            char resultChar = (char) resultInt;
            novaMsg += resultChar;
            iv = SDES.intToBinary(resultInt);
        }

        return novaMsg;
    }

    /*Funcao para decifrar uma mensagem*/
    public String decifraMensagem(String msg, int key, SDES SDES, Integer[] iv) {
        String novaMsg = "";

        for (int i = 0; i < msg.length(); i++) {
            int a = (char) msg.charAt(i);
            Integer b = (Integer) a;
            Integer caracBin[] = SDES.intToBinary(b);
            Integer resultInteger = SDES.decifrar(SDES.binaryToInt(caracBin), key);
            Integer result[] = SDES.xor(SDES.intToBinary(resultInteger), iv);
            Integer novo = SDES.binaryToInt(result);
            int resultInt = (int) novo;
            char resultChar = (char) resultInt;
            novaMsg += resultChar;
            iv = caracBin;
        }

        return novaMsg;
    }

    /*Funcao que prepara a imagem para ser cifrada/decifrada*/
    public void preparaCifra(String msg, int key, int type, SDES cipher, Integer[] iv) throws IOException {

        if (type == 1) {
            cifraMensagem(msg, key, cipher, iv);
        } else {
            decifraMensagem(msg, key, cipher, iv);
        }

    }

    /*Chama a funcao de prepara a imagem no modo de cifragem*/
    public int cifrar(String entrada, int key, SDES cipher, Integer[] iv) throws IOException {
        preparaCifra(entrada, key, 1, cipher, iv);
        return 1;
    }

    /*Chama a funcao de prepara a imagem no modo de decifragem*/
    public int decifrar(String entrada, int key, SDES cipher, Integer[] iv) throws IOException {
        preparaCifra(entrada, key, 2, cipher, iv);
        return 1;
    }

    public static void main(String args[]) throws IOException {
        Integer iv[] = {1, 0, 0, 0, 1, 1, 0, 1};
        SDES sdes = new SDES();
        CBC cbc = new CBC();
        cbc.cifrar("ac", 1010000010, sdes, iv);
        cbc.decifrar("«B", 1010000010, sdes, iv);
    }

}
