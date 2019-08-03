/*
 * Seguranca Computacional 2019.1 - Prof. Dr. Valerio Rosset
 * Pratica 07 - Chat: Modulo do Modos de Cifra
 * Nome: Flavia Yumi Ichikura RA: 111791
 * Nome: Willian Dihanster Gomes de Oliveira RA: 112269	
 */
package criptografia;

import java.io.IOException;

public class Counter {

    /*Funcao para cifrar/decifrar uma imagem*/
    public String cifraMensagem(String msg, int key, SDES SDES) throws IOException {

        String novaMsg = "";
        Integer cont = 0;

        for (int i = 0; i < msg.length(); i++) {
            Integer resultInteger = SDES.cifrar(cont, key);
            int a = (char) msg.charAt(i);
            Integer b = (Integer) a;
            Integer caracBin[] = SDES.intToBinary(b);
            Integer resultVector[] = SDES.intToBinary(resultInteger);
            Integer result[] = SDES.xor(caracBin, resultVector);
            Integer novo = SDES.binaryToInt(result);
            int resultInt = (int) novo;
            char resultChar = (char) resultInt;
            novaMsg += resultChar;
        }

        return novaMsg;

    }

    /*Chama a funcao de leitura da imagem para decifra-la*/
    public String decifrarMensagem(String entrada, int key, SDES cipher) throws IOException {
        return cifraMensagem(entrada, key, cipher);
    }

    public static void main(String args[]) throws IOException {
        SDES sdes = new SDES();
        Counter ctr = new Counter();
        ctr.cifraMensagem("ac", 1010000010, sdes);
        ctr.decifrarMensagem("¯­", 1010000010, sdes);
    }

}
