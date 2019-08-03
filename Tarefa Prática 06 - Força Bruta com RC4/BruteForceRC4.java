/*
 * Seguranca Computacional 2019.1 - Prof. Dr. Valerio Rosset
 * Pratica 06 - Forca Bruta com RC4
 * Nome: Flavia Yumi Ichikura RA: 111791
 * Nome: Willian Dihanster Gomes de Oliveira RA: 112269	
 */

package exercicio;

import static java.lang.Math.pow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class BruteForceRC4 {

	private Hashtable <String, ArrayList<int[]>> h;
    private RC4 cif;
    
    /**
     * Criar uma tabela hash, objeto do cifrador RC4 e inicia o dicionario de acordo com o tamanho do bits 
     * @param maxKeyLenth = valor maximo da chave a ser gerada
     */
    public BruteForceRC4 (int maxKeyLength) {
        this.h = new Hashtable <String, ArrayList <int[]>>();
        this.cif = new RC4();
        this.initDict(this.generateKeys(maxKeyLength));
    }
    
    /**
     * Gera todas as possiveis keys de 1 a 'size' bits
     * @param size quantidade maxima de bits
     */
    public List <int[]> generateKeys (int size) {
        int key [];
    	List <int[]> keys = new ArrayList <int[]>();
        
        int max = 0;
        for (int i = 0; i < size; i++)
            max += pow(2, i);
        
        for (int numBits = 1; numBits <= size; numBits++) {
            key = new int[numBits];
            Arrays.fill(key, 0);
            keys.add(key.clone());
            
            max = 0;
            for (int i = 0; i < numBits; i++)
                max += pow(2, i);
        
            for (int j = 0; j < max; j++) {
                for (int i = numBits-1; i >- 1; i--) {
                    if (key[i] == 0) {
                        key[i] = 1;
                        keys.add(key.clone());
                        break;
                    }
                    else {
                        key[i] = 0;
                    }
                }
            }
        }
        return keys;
    }
    
    /**
     * Cria um HashMap com a combinação de todas as possíveis palavras cifradas com todas as keys e a chave utilizada na cifragem
     * @param List <int[]> keys - a lista de keys
     */
    public void initDict (List <int[]> keys) {
        this.h = new Hashtable <String, ArrayList <int[]>>();
        String words [] = {"Ola","Como vai?","Bom dia!","Boa Tarde.","Tudo bem?","Sim.","Nao.","Adeus","Ate logo","lol",":)",":(","ok","td bem","sem problemas","tchau",
                        "reuniao","me liga","obrigado!","de nada","muito obrigado",":0"};
        String cifrado;
        System.out.println("vou imprimir");
        for (int key[] : keys) {
            for (String w: words) {                
                cifrado = this.cif.cifrar(w, key);
                if (!h.containsKey(this.cif.cifrar(w, key))) {
                    this.cif.cifrar(w, key);
                    h.put(cifrado, new ArrayList <int[]>());                    
                }
                h.get(cifrado).add(key);
            }
        }
        System.out.println("terminei imprimir");
    }
    
    /**
     * Procura pela(s) chave(s) possíveis para decifrar a palavra
     * @param String text - O texto para procurar sua chave no Hash
     */
    public List <int[]> searchKey (String text) {        
        if(this.h.containsKey(text))
            return this.h.get(text);
        else
            return null;
    }
    
    /**
     * Imprime a tabela hash
     */
    public void printHash () {
        System.out.println("Hash com " + this.h.size() + " elementos");
        for (String cifrado: this.h.keySet()) {
            System.out.print(cifrado + " ");
            for (int[] v: this.h.get(cifrado))
                this.printVet(v);
        } 
    }
    
    /**
     * Impressão de um vetor v
     * @param int vet [] - O vetor de inteiros a ser impresso
     */
    public void printVet (int vet []) {
        for (int i: vet) 
            System.out.print(i);  
        System.out.println("");
    }
    
    /**
     * Compara se 2 vetores de inteiro são iguais ou diferentes
     * @param int a[], int b[] - Dois vetores de inteiros a serem comparados
     */
    public Boolean compareIntVet (int a[], int b[]) {
        if(a == null || b == null)
            return false;
        if(a.length != b.length)
            return false;
        for(int i = 0; i < a.length; i++)
            if(a[i] != b[i])
                return false;
        return true;
    }
    
    /**
     * Verifica se o algoritmo é capaz de reconhecer a chave utilizada para cifrar uma palavra
     * @param String plainText, int[] key - O texto a ser cifrado e a chave
     */
    public Boolean test (String plainText, int[] key) {
        String cipherText = this.cif.cifrar(plainText, key);
        List <int[]> keyFound = this.searchKey(cipherText);
        
        for (int[] k:keyFound)
            if (this.compareIntVet(k, key))
                return true;
        
        return false;
    }
    
    
    /**
     * Impressao de todas as possiveis keys, se existirem, para decifrar a palavra em alguma das pre-definidas
     * @param String cifrado - A string em que esta se buscando sua chave de descriptografia
     */
    public void getPossibleKeys (String cipherText) {
        List <int[]> keys = this.searchKey(cipherText);
        
        if (keys != null) {
            if(keys.size() == 1)
                System.out.println("Key: ");
            else
                System.out.println("Possible keys: ");
            for (int [] c: keys)
                this.printVet(c);
        }
        else {
            System.out.println("Not found");
        }
        
        System.out.println("Plaint Text = " + this.cif.cifrar(cipherText, keys.get(0)));

    }
	
    /**
     * Programa principal para execucao e definicao das entradas
     */
	public static void main (String[] args) {
		int size = 4; /*Define o numero maximo de bits da chave K*/
        BruteForceRC4 fb = new BruteForceRC4(size);
        
        /*Aqui pode-se definir a string a ser procurada como uma criptografia de uma 
         * palavra conhecida ou inserir uma ja definida
         */
        String plaintText = "Ola";
        String cipherText = fb.cif.cifrar(plaintText, new int [] {0,1});
        
        System.out.println("Cipher Text = " + cipherText);
        
        /*Passar a string que queremos descobrir sua chave*/
        fb.getPossibleKeys(cipherText);
		
	}
}
