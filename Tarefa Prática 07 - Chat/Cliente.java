/*
 * Seguranca Computacional 2019.1 - Prof. Dr. Valerio Rosset
 * Pratica 07 - Chat: Modulo de Rede
 * Nome: Flavia Yumi Ichikura RA: 111791
 * Nome: Willian Dihanster Gomes de Oliveira RA: 112269	
 */
package rede;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class Cliente {

    private Socket socket;
    private OutputStream ou;
    private Writer ouw;
    private BufferedWriter bfw;

    public Cliente() {
        this.socket = null;
    }

    public Socket getSocket() {
        return this.socket;
    }

    public void conectar(String IP) throws IOException {
        socket = new Socket(IP, 3000); //Conecta ao servidor do outro Cliente
        ou = socket.getOutputStream();
        ouw = new OutputStreamWriter(ou);
        bfw = new BufferedWriter(ouw);
        bfw.flush();
    }

    public void enviarMensagem(String msg) throws IOException {
        bfw.write(msg + "\r\n");
        bfw.flush();
    }

    public void sair() throws IOException {
        enviarMensagem("Sair");
        bfw.close();
        ouw.close();
        ou.close();
        socket.close();
    }
}
