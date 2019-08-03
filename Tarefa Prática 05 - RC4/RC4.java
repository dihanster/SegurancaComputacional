/*
 * Seguranca Computacional 2019.1 - Prof. Dr. Valerio Rosset
 * Pratica 05 - RC4
 * Nome: Flavia Yumi Ichikura RA: 111791
 * Nome: Willian Dihanster Gomes de Oliveira RA: 112269	
 */
package exercicio;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class RC4 {

	/*Cria o vetor S, com Si = i*/
	public static int[] s() {
		int[] A = new int[256];

		for (int i = 0; i < A.length; i++)
			A[i] = i;

		return A;
	}

	/*Criar o vetor T de acordo com a chave K*/
	public static int[] t (int[] K) {
		int[] A = new int[256];
		int j = 0;

		for (int i = 0; i < A.length; i++) {
			if (j >= K.length)
				j = 0;
			A[i] = K[j];
			j++;
		}

		return A;
	}

	/*Inicia o vetor S, fazendo as permutacoes*/
	public static int[] initS (int[] S, int[] T) {
		int j = 0;

		for (int i = 0; i < 256; i++) {
			j = (j + S[i] + T[i]) % 256;
			swap(S, i, j);
		}

		return S;
	}

	/*Troca um elemento da posicao i pelo da posicao j, em S*/
	public static void swap (int[] S, int i, int j) {
		int aux = S[i];
		S[i] = S[j];
		S[j] = aux;
	}

	/*Aplica a funcao xor entre dois vetores a e b*/
	public int[] xor (int[] a, int[] b) {
		int[] aux = new int[a.length];

		for (int i = 0; i < a.length; i++) {
			if (a[i] == b[i])
				aux[i] = 0;
			else
				aux[i] = 1;
		}

		return aux;
	}

	/*Converte um inteiro para um vetor binario*/
	public int [] intToBinary (int num) {
		int bin [] = new int[8];
		int i = 7;

		while (i >- 1) {
			bin[i] = num % 2;
			num = num/2;
			i--;
		}

		return bin;
	}

	/*Converte um vetor binario para decimal e retorna em char*/
	public char binaryToChar (int[] bin) {
		long ascii = 0;

		for (int i = bin.length-1; i >- 1; i--) {
			ascii += Math.pow(2, bin.length-1-i) * bin[i];
		}

		return (char) ascii;
	}

	/*Realiza o Stream Generation, com o vetor S e a entrada*/
	public void streamGeneration (int [] S, String entrada) {
		int i = 0, j = 0, l = 0, k, t;

		Charset cs = StandardCharsets.UTF_8;
		ByteBuffer bb = cs.encode(entrada);
		byte [] arrayEntrada = bb.array();

		while (true) {
			i = (i + 1) % 256;
			j = (j + S[i]) % 256;
			swap(S, i, j);
			t = (S[i] + S[j]) % 256;
			k = S[t];
			if (l < entrada.length())
				System.out.print((char) this.binaryToChar(this.xor(this.intToBinary(k), this.intToBinary((int) arrayEntrada[l++]))));
			else
				break;
		}

	}

	/*Cifra/decifra a entrada com a chave K*/
	public void cifrar(String entrada, int[] K){
		int [] S = s();
		int [] T = t(K);

		initS(S, T);
		this.streamGeneration(S, entrada);
	}

	public static void main (String[] args){
		int op = 1;
		int [] K = {1, 0, 1, 0, 0, 0, 0, 0, 1, 0};
		String entrada = "a";

		RC4 rc4 = new RC4();
        	
        System.out.print("\nOriginal: " + entrada);
        
		if (op == 1) { /*Cifrar*/
			System.out.print("\nCifrado: ");
			rc4.cifrar(entrada, K);
		}
		else if (op == 2) { /*Decifrar*/
			System.out.print("\nDecifrado: ");
			rc4.cifrar(entrada, K);
		}

	}
}