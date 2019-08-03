/*
 * Seguranca Computacional 2019.1 - Prof. Dr. Valerio Rosset
 * Pratica 02 - Algoritmos de Criptografia
 * Codigo 01 - Cifra de Cesar
 * Nome: Flavia Yumi Ichikura RA: 111791
 * Nome: Willian Dihanster Gomes de Oliveira RA: 112269	
*/

package Exercicios;

import java.util.Scanner;

public class CifraCesar {

	public static void main(String[] args) {
        
		/*Cria uma scanner para leitura da mensagem pelo teclado*/
		Scanner scan = new Scanner(System.in);
		
		/*Le a mensagem e cria uma nova string para a saida*/
		String entrada = scan.nextLine();
		String saida = "";
        
		/*Define o valor da chave/n para o deslocamento*/
        int chave = Integer.parseInt(scan.nextLine());
        
        /*Faz o deslocamento (soma n no caracter) em uma dada string, salvando em uma nova*/
        for(int i = 0; i < entrada.length(); i++){
            saida = saida + (char)(entrada.charAt(i) + chave);
        }
        
        /*Printa a mensagem criptografada*/
        System.out.println(saida);
        
        /*Fecha o scan*/
        scan.close();
        
	}	
    
}