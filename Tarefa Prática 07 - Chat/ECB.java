/*
 * Seguranca Computacional 2019.1 - Prof. Dr. Valerio Rosset
 * Pratica 07 - Chat: Modulo do Modos de Cifra
 * Nome: Flavia Yumi Ichikura RA: 111791
 * Nome: Willian Dihanster Gomes de Oliveira RA: 112269	
 */
package criptografia;

import java.io.IOException;

public class ECB {

    /*Funcao que faz a cifra/decifra*/
    public String cifrarMensagem(String msg, int key, SDES SDES) throws IOException {
        String novaMsg = "";
        Integer resultInteger;

        for (int i = 0; i < msg.length(); i++) {
            int a = (char) msg.charAt(i);
            Integer b = (Integer) a;
            Integer caracBin[] = SDES.intToBinary(b);
            resultInteger = SDES.cifrar(SDES.binaryToInt(caracBin), key);
            int resultInt = (int) resultInteger;
            char resultChar = (char) resultInt;
            novaMsg += resultChar;
        }

        return novaMsg;

    }

    /*Chamam a funcao de prepara a mensagem no modo de decifragem*/
    public String decifrarMensagem(String entrada, int key, SDES cipher) throws IOException {
        String novaMsg = "";
        Integer resultInteger;

        for (int i = 0; i < entrada.length(); i++) {
            int a = (char) entrada.charAt(i);
            Integer b = (Integer) a;
            Integer caracBin[] = SDES.intToBinary(b);
            resultInteger = SDES.decifrar(SDES.binaryToInt(caracBin), key);
            int resultInt = (int) resultInteger;
            char resultChar = (char) resultInt;
            novaMsg += resultChar;
        }

        return novaMsg;
    }

    public static void main(String args[]) throws IOException {
        SDES sdes = new SDES();
        ECB ecb = new ECB();
    }

}
