/*
 * Seguranca Computacional 2019.1 - Prof. Dr. Valerio Rosset
 * Pratica 07 - Chat: Modulo de Rede
 * Nome: Flavia Yumi Ichikura RA: 111791
 * Nome: Willian Dihanster Gomes de Oliveira RA: 112269	
 */
package rede;

import TrocaChave.DiffieHellman;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {
    private Socket socket;
    private OutputStream ou;
    private Writer ouw;
    private BufferedWriter bfw;
    private final DiffieHellman dh;
    private String key;
    
    public Cliente() {
        this.socket = null;
        this.dh = new DiffieHellman(4, 0);
        this.key = "";
    }

    public Socket getSocket() {
        return this.socket;
    }
    
    public DiffieHellman getDh()
    {
        return this.dh;
    }

    public void conectar(String IP) throws IOException {
        socket = new Socket(IP, 3000); //Conecta ao servidor do outro Cliente
        ou = socket.getOutputStream();
        ouw = new OutputStreamWriter(ou);
        bfw = new BufferedWriter(ouw);
        bfw.flush();
        
        this.dh.setX(this.dh.gerarX());
        System.out.println("Setou x: "+this.dh.getX());
        System.out.println("Fim do método conectar em Cliente");
    }

    public void enviarMensagem(String msg) throws IOException {
        System.out.println("Enviando: " + msg);
        bfw.write(msg + "\r\n");
        bfw.flush();
    }

    public void sair() throws IOException {
        enviarMensagem("Sair");
        this.key = "";
        bfw.close();
        ouw.close();
        ou.close();
        socket.close();
    }
    
    public void enviarY(){
        this.dh.setX((int)(Math.random() * (this.dh.getQ())));
        this.dh.generateY();
        try {
            enviarMensagem("Header|Y:"+this.dh.getY()+"|Header");
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
