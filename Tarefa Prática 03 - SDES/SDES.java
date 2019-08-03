/*
 * Seguranca Computacional 2019.1 - Prof. Dr. Valerio Rosset
 * Pratica 03 - S-DES
 * Nome: Flavia Yumi Ichikura RA: 111791
 * Nome: Willian Dihanster Gomes de Oliveira RA: 112269	
*/

package Exercicio;

import java.util.Scanner;

public class SDES {
	
	private static Scanner scan;

	/*Funcao responsavel para converter um inteiro para um array*/
    public static Integer[] intToArray (int key) {
        Integer[] arrayKey = new Integer[10];
        int i = 9;
        
        while (i > -1) {
            arrayKey[i] = key % 10;
            key = key/10;
            i--;   
        }
        
        return arrayKey;
    }
    
    /*Funcao responsavel por converter um inteiro para binario*/
    public static Integer[] intToBinary (int num) {
        Integer[] bin = new Integer[8];
        int i = 7;
        
        while (i > -1) {
            bin[i] = num % 2;
            num = num/2;
            i--;
        }
        
        return bin;
    }
    
    /*Funcao responsavel por converter um binario para decima*/
    public static int binaryToDecimal (int a, int b) {
        int num = a*10 + b;
        
        switch (num) {
            case 10:
                num = 2;
                break;
            case 11:
                num = 3;
                break;
            default:
            	break;
        }
        
        return num;
    }
    
    /*Funcao responsavel por converter um decimal a para um array binario*/
    public static Integer[] decimalToBinary (int a) {
        Integer[] num = new Integer[2];
        
        switch (a) {   
            case 0:
                num[0] = 0;
                num[1] = 0;
                break;
            case 1:
                num[0] = 0;
                num[1] = 1;
                break;
            case 2:
                num[0] = 1;
                num[1] = 0;
                break;
            case 3:
                num[0] = 1;
                num[1] = 1;
                break;
            default:
            	break;
        }
        
        return num;
    }
    
    /*Funcao responsavel em converter um char para binario*/
    public static Integer[] charToBinary (char letra) {
        return intToBinary ((int) letra);
    }
    
    /*Funcao responsavel por converter um binario para char*/
    public static char binaryToChar (Integer[] bin) {
        long carac = 0;
        
        for(int i = bin.length-1; i > -1; i--) {
            carac += Math.pow(2, bin.length-i-1) * bin[i];
        }
        
        //System.out.println(carac + " " + (char) carac);
        return ((char) carac);
    }
    
    /*Funcao responsavel por aplicar o XOR entre dois vetores a e b*/
    public static Integer[] xor (Integer[] a, Integer[] b) {
        Integer[] c = new Integer[a.length];
        
        for(int i = 0; i < a.length; i++){
            if(a[i] == b[i])
                c[i] = 0;
            else
                c[i] = 1;
        }
        
        return c;
    }
    
    /*Funcao responsavel por aplicar a permutacao P10*/
    public static Integer[] p10 (Integer[] key) {        
        int i = 0;
    	int[] permt = {2, 4, 1, 6, 3, 9, 0, 8, 7, 5};        
        Integer[] pKey = new Integer[10]; 
        
        for (int p:permt) {
            pKey[i] = key[p];
            i++;
        }
        
        return pKey;
    }
    
    /*Funcao responsavel por aplicar a permutacao P8*/
    public static Integer[] p8 (Integer[] key) {
        int i = 0;
    	int[] permt = {5, 2, 6, 3, 7, 4, 9, 8};        
        Integer[] pKey = new Integer[8]; 
        
        for (int p:permt) {
            pKey[i] = key[p];
            i++;
        }
        
        return pKey;
    }
    
    /*Funcao responsavel por aplicar a permutacao P4*/
    public static Integer[] p4 (Integer[] key) {
    	int i = 0;
    	int[] permt = {1, 3, 2, 0};        
        Integer[] pKey = new Integer[4]; 
        
        for (int p:permt) {
            pKey[i] = key[p];
            i++;
        }
        
        return pKey;
    }
    
    /*Funcao responsavel por aplicar a permutacao IP*/
    public static Integer[] IP (Integer[] key) {
        int i = 0;
    	int[] permt = {1, 5, 2, 0, 3, 7, 4, 6};        
        Integer[] pKey = new Integer[8]; 
        
        for (int p:permt) {
            pKey[i] = key[p];
            i++;
        }
        
        return pKey;
    }
    
    /*Funcao responsavel por aplicar a permutacao IP(^-1)*/
    public static Integer[] IP_1 (Integer[] key) {
    	int i = 0;
        int[] permt = {3, 0, 2, 4, 6, 1, 7, 5};        
        Integer[] pKey = new Integer[8]; 
        
        for (int p:permt) {
            pKey[i] = key[p];
            i++;
        }
        
        return pKey;
        
    }
    
    /*Funcao responsavel por aplicar a permutacao EP*/
    public static Integer[] EP (Integer[] key) {
        /*3 0 1 2 1 2 3 0*/
    	int i = 0;
        int[] permt = {3, 0, 1, 2, 1, 2, 3, 0};        
        Integer[] pKey = new Integer[8]; 
        
        for (int p:permt) {
            pKey[i] = key[p];
            i++;
        }
        
        return pKey;
    }
    
    /*Funcao responsavel por aplicar o LS1P*/
    public static Integer[] ls_1 (Integer[] a) {
        Integer b[] = new Integer[a.length];
        
        for (int i = 0; i < a.length; i++)
            if (i+1 < a.length)
                b[i] = a[i+1];
            else
                b[i] = a[0];
        
        return b;
    }
          
    /*Funcao responsavel por aplicar nas matrizes S0 e S1*/
    public static Integer[] S0_S1 (Integer[] key) {
        Integer[][] M_S0 = {{1,0,3,2},{3,2,1,0},{0,2,1,3},{3,1,3,2}};
        Integer[][] M_S1 = {{0,1,2,3},{2,0,1,3},{3,0,1,0},{2,1,0,3}};
        
        int key_11 = binaryToDecimal(key[0], key[3]);
        int key_12 = binaryToDecimal(key[1], key[2]);
        int key_21 = binaryToDecimal(key[4], key[7]);
        int key_22 = binaryToDecimal(key[5], key[6]);
        
        Integer[] S0 = decimalToBinary(M_S0[key_11][key_12]);
        Integer[] S1 = decimalToBinary(M_S1[key_21][key_22]);
        
        Integer[] key_4digits = new Integer[4];
        key_4digits[0] = S0[0];
        key_4digits[1] = S0[1];
        key_4digits[2] = S1[0];
        key_4digits[3] = S1[1];
        
        return key_4digits;
    }
    
    /*Funcao responsavel por criar a chave 1 - k1*/
    public static Integer[] createK1 (int key) {
        Integer[] k1;
        Integer[] k1_1 = new Integer[5];
        Integer[] k1_2 = new Integer[5];
        
        k1 = p10(intToArray(key));
        
        for (int i = 0; i < 5; i++)
            k1_1[i] = k1[i];
        
        for (int i = 5; i < 10; i++)
            k1_2[i-5] = k1[i];
        
        k1_1 = ls_1(k1_1);
        k1_2 = ls_1(k1_2);
        
        for (int i = 0; i < 5; i++)
            k1[i] = k1_1[i];
        
        for (int i = 5; i < 10; i++)
            k1[i] = k1_2[i-5];
        
        k1 = p8(k1);
        
        return k1;
    }
    
    /*Funcao responsavel por criar a chave 2 - k2*/
    public static Integer[] createK2 (int key) {
        Integer[] k1 = new Integer[10];
        Integer[] k1_1 = new Integer[5];
        Integer[] k1_2 = new Integer[5];
        
        k1 = p10(intToArray(key));
        
        for (int i = 0; i < 5;i++)
            k1_1[i] = k1[i];
        
        for (int i = 5; i < 10; i++)
            k1_2[i-5] = k1[i];
        
        k1_1 = ls_1(k1_1);
        k1_1 = ls_1(k1_1);
        k1_1 = ls_1(k1_1);
        
        k1_2 = ls_1(k1_2);
        k1_2 = ls_1(k1_2);
        k1_2 = ls_1(k1_2);
        
        for (int i = 0; i < 5; i++)
            k1[i] = k1_1[i];
        
        for (int i = 5; i < 10; i++)
            k1[i] = k1_2[i-5];
        
        k1 = p8(k1);
        
        return k1;
    }
    
    /*Funcao responsavel por aplicar a funcao f*/
    public static Integer[] f (Integer[] key, Integer[] l_1, Integer[] l_2, int func) {
        Integer[] output = new Integer[8];
        
        if (func == 1) {
            for (int i = 0; i < 4; i++)
                output[i] = l_2[i];
        }
        else {
            for (int i = 0; i < 4; i++)
                output[i+4] = l_2[i];
        }
        
        l_2 = EP(l_2);
        //System.out.println("EP:");imprimir(l_2);
        l_2 = xor(l_2,key);
        //System.out.println("xor:");imprimir(l_2);
        l_2 = S0_S1(l_2);
        //System.out.println("Antes p4:");imprimir(l_2);
        l_2 = p4(l_2);
        //System.out.println("P4:");imprimir(l_2);
        l_1 = xor(l_1,l_2);
        //System.out.println("xor:");imprimir(l_1);

        if (func == 1) {
            for (int i = 0; i < 4; i++)
                output[i+4] = l_1[i];
        }
        else {
            for (int i = 0; i < 4; i++)
                output[i] = l_1[i];
        }
        
        return output;
    }
    
    /*Funcao auxiliar para imprimir resultados*/
    public static void imprimir (Integer[] a) {
        
    	for(Integer i: a)
            System.out.print("[" + i + "]"); 
    	System.out.print("\n");
    
    }
    
    /*Funcao responsavel por crifar com o algoritmo SDES*/
    public static void cifrar (String entrada, int key) {
        Integer[] k1 = createK1(key);
        Integer[] k2 = createK2(key);
        //System.out.println("k1:"); imprimir(k1);
        //System.out.println("k2:"); imprimir(k2);

        for (char c:entrada.toCharArray()) {
            Integer[] letra = charToBinary(c);
            //System.out.println("c:"); imprimir(letra);
            letra = IP(letra);
            //System.out.println("IP:"); imprimir(letra);
            
            Integer[] l_1 = new Integer[4];
            Integer[] l_2 = new Integer[4];
            
            for (int i = 0; i < 4; i++)
                l_1[i] = letra[i];
            
            for (int i = 0; i < 4; i++)
                l_2[i] = letra[i+4];
            
            //System.out.println("l_1:"); imprimir(l_1);
            //System.out.println("l_2:"); imprimir(l_2);
            
            Integer[] resultF1 = f(k1, l_1, l_2,1);
            //System.out.println("F1 = "); imprimir(resultF1);
            
            for (int i = 0; i < 4; i++)
                l_1[i] = resultF1[i];
            
            for (int i = 0; i < 4; i++)
                l_2[i] = resultF1[i+4];
            
            //System.out.println("---------------------------\nF2");
            //System.out.println("l_1:"); imprimir(l_1);
            //System.out.println("l_2:"); imprimir(l_2);
            
            letra = f(k2, l_1, l_2,2);
            //imprimir(letra);
            
            letra = IP_1(letra);
            System.out.println("Saida Binaria:"); 
            imprimir(letra);

            System.out.println("Saida ASCII:"); 
            System.out.println(binaryToChar(letra));
        }
    }
    
    /*Funcao responsavel por decrifar com o algoritmo SDES*/
    public static void decifrar (String entrada, int key) {
        Integer[] k1 = createK1(key);
        Integer[] k2 = createK2(key);

        for (char c:entrada.toCharArray()) {
            Integer[] letra = charToBinary(c);
            System.out.println("c:"); imprimir(letra);
            letra = IP(letra);
            
            Integer[] l_1 = new Integer[4];
            Integer[] l_2 = new Integer[4];
            
            for (int i = 0; i < 4 ; i++)
                l_1[i] = letra[i];
            
            for (int i = 0; i < 4; i++)
                l_2[i] = letra[i+4];
            
            Integer[] resultF1 = f(k2, l_1, l_2,1);
            for (int i = 0; i < 4; i++)
                l_1[i] = resultF1[i];
            
            for (int i = 0; i < 4; i++)
                l_2[i] = resultF1[i+4];
            
            letra = f(k1, l_1, l_2,2);
            letra = IP_1(letra);
            System.out.println("Saida Binaria:"); 
            imprimir(letra);
            
            System.out.println("Saida ASCII:"); 
            System.out.println(binaryToChar(letra));
            
        }
    }
    
    /*Funcao principal para as entradas e decisao cifra/decifrar*/
    public static void main(String[] args) {
        int key, op;
        String entrada;        
        scan = new Scanner(System.in);
        
        System.out.println("(1) Cifrar | (2) Descifrar | (3) Sair");
        op = Integer.parseInt(scan.nextLine());
        
        while (op != 3) {
            switch (op) {
                case 1:
                    System.out.println("Entrada:");
                    entrada = scan.nextLine();
                    System.out.println("Chave:");
                    key = Integer.parseInt(scan.nextLine());
                    cifrar(entrada, key);
                    System.out.println("(1) Cifrar | (2) Descifrar | (3) Sair");
                    op = Integer.parseInt(scan.nextLine());
                    break;
                case 2:
                    System.out.println("Entrada:");
                    entrada = scan.nextLine();
                    System.out.println("Chave:");
                    key = Integer.parseInt(scan.nextLine());
                    decifrar(entrada, key);
                    System.out.println("(1) Cifrar | (2) Descifrar | (3) Sair");
                    op = Integer.parseInt(scan.nextLine());
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opção não disponível");
                    op = Integer.parseInt(scan.nextLine());
                    break;
            }
        }
        
    }
}