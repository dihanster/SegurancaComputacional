/*
 * Seguranca Computacional 2019.1 - Prof. Dr. Valerio Rosset
 * Pratica 07 - Chat: Modulo de Rede
 * Nome: Flavia Yumi Ichikura RA: 111791
 * Nome: Willian Dihanster Gomes de Oliveira RA: 112269	
 */
package rede;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Tela;

public class Conexao extends Thread {

    private Tela tela;

    public Tela getTela() {
        return tela;
    }

    public void setTela(Tela tela) {
        this.tela = tela;
    }

    public void run() {

        ServerSocket server;
        try {
            server = new ServerSocket(3002);
            while (true) {
                Socket socket = null;
                try {
                    socket = server.accept();
                    Servidor s = new Servidor(socket);
                    s.setTela(this.getTela());

                    s.start();
                    System.out.println("Conectou");
                } catch (Exception ex) {
                    socket.close();
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
