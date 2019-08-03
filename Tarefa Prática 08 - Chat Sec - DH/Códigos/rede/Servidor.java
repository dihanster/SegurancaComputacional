/*
 * Seguranca Computacional 2019.1 - Prof. Dr. Valerio Rosset
 * Pratica 07 - Chat: Modulo de Rede
 * Nome: Flavia Yumi Ichikura RA: 111791
 * Nome: Willian Dihanster Gomes de Oliveira RA: 112269	
 */
package rede;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Tela;

public class Servidor extends Thread {

    private static BufferedWriter cliente;
    private static ServerSocket server;
    private Socket socket;
    private InputStream in;
    private InputStreamReader inr;
    private BufferedReader bfr;
    private Tela tela;

    public Tela getTela() {
        return tela;
    }

    public void setTela(Tela tela) {
        this.tela = tela;
    }

    public Servidor(Socket socket) {
        this.socket = socket;
        try {
            in = socket.getInputStream();
            inr = new InputStreamReader(in);
            bfr = new BufferedReader(inr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String msg = "";

        while (!"Sair".equalsIgnoreCase(msg)) {
            if (msg.length() > 6){
                if(msg.substring(0, 6).equals("Header")) {
                    //System.out.println("Reconheceu cabeçalho: "+msg);
                    String header = msg.substring(7,msg.lastIndexOf("Header"));
                    String dados[] = header.split("\\|");
                    for (String a: dados) {
                        //System.out.println(a);
                        if (a.substring(0, 2).compareTo("Y:")==0) {
                            int k = this.tela.getCliente().getDh().generateK(Integer.parseInt(a.substring(2, a.length()))).intValue();
                            this.tela.setKey(k);
                            //System.out.println("k eh: " + k);
                            continue;
                        }
                    }
                }
                //else {
                  //  System.out.println("Não reconheceu cabeçalho");
                //}
            }
            
            try {
                if (bfr.ready()) {
                    msg = bfr.readLine();
                    if (msg.equals("Sair")) {
                        System.out.print("Servidor caiu! \r\n");
                    } else {
                        System.out.print("Escutou: " + msg + "\r\n");
                        this.getTela().descriptMessage(msg);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
