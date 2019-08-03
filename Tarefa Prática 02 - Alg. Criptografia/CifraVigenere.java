/*
 * Seguranca Computacional 2019.1 - Prof. Dr. Valerio Rosset
 * Pratica 02 - Algoritmos de Criptografia
 * Codigo 02 - Cifra de Vigenere
 * Nome: Flavia Yumi Ichikura RA: 111791
 * Nome: Willian Dihanster Gomes de Oliveira RA: 112269	
*/

package Exercicios;

public class CifraVigenere {

	public static void main(String[] args) {
		int cont = 0;
		char[][] TabelaVigenere = new char[26][26];
		String mensagem = "SegComp eh Legal";
		String nova_mensagem = "";
		String chave = "abc";
		
		/*O algoritmo desenvolvido parte do pressuposto que a mensagem esta em maisculo,
		 por questoes de simplificade com a Tabela ASCII, por isso, forca-se 
		 a mensagem estar em caixa alta */
		mensagem = mensagem.toUpperCase();
		chave = chave.toUpperCase();
		
		/*Atribui todas letras na matriz*/
		for(int i = 65; i < 65+26; i++) {
			for (int j = 0; j < 26; j++) {
				int k = i - 65;
				char a = (char) (j + 65);
				TabelaVigenere[k][j] = a;
			}
		}
				
		/*Faz o deslocamento das letras de acordo com o indice i, formando a Tabela de Vigenere*/
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				if ((TabelaVigenere[i][j] + i > 90))
					TabelaVigenere[i][j] = (char) (TabelaVigenere[i][j] - 26);
				TabelaVigenere[i][j] = (char) (TabelaVigenere[i][j] + i);
			}
		}
		
		/*Percorre a mensagem para codifica-la*/
		for (int i = 0; i < mensagem.length(); i++) {
			
			/*Verifica se ja percorreu todas as letras da chaves*/
			if (cont >= chave.length()) 
				cont = 0;
			
			/*Transforma as letras em indices para procurar na Tabela*/
			int j = (int) (mensagem.charAt(i) - 65);
			int k = (int) (chave.charAt(cont) - 65);
			
			/*Verifica se eh uma letra. Se for caractere, so insere na mensagem*/
			if (j < 0 || j > 25) {
				nova_mensagem = nova_mensagem + mensagem.charAt(i);
			}
			/*Codifica o caractere de acordo com a Tabela de Vigenere*/
			else {
				nova_mensagem = nova_mensagem + TabelaVigenere[j][k];
				cont++;
			}
		}
		
		/*Printa a mensagem original e a chave*/
		System.out.println("A mensagem original eh " + mensagem);
		System.out.println("A chave utilizada foi " + chave);
		
		/*Printa a mensagem criptografada*/
		System.out.println("A mensagem criptografada eh " + nova_mensagem);
				
	}
	
}
