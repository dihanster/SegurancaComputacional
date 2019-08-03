/*
 * Seguranca Computacional 2019.1 - Prof. Dr. Valerio Rosset
 * Tarefa Pratica 08 - Acordo de Chaves de Diffie e Hellman
 * Nome: Flavia Yumi Ichikura RA: 111791
 * Nome: Willian Dihanster Gomes de Oliveira RA: 112269	
 */
package TrocaChave;

import java.math.BigInteger;

public class DiffieHellman {
    public int q, alfa;
    private int x, y; 
    
    public int gerarX()
    {
        return (int) (Math.random()*this.getQ());
    }
            
    public DiffieHellman(int i, int j){
        int primesList[] = {101, 113, 127, 139, 353};
        int primitiveRoots[][] = {{2, 3, 7, 8, 11}, {3, 5, 6, 10, 12},
                {3, 6, 7, 12, 14}, {2, 3, 12, 15, 17}, {3, 5, 12, 13, 14}};
        this.q = primesList[i];
        this.alfa = primitiveRoots[i][j];
        //this.setX(this.gerarX());
        //System.out.println("Setou x: "+this.getX());
    }    

    public int getQ(){
        return q;
    }

    public void setQ(int q){
        this.q = q;
    }

    public int getAlfa(){
        return alfa;
    }

    public void setAlfa(int alfa){
        this.alfa = alfa;
    }

    public int getX() {
        return x;
    }

    public void setX(int x){
        if (x < this.getQ())
        {
            this.x = x;
            this.generateY();
        }
        else 
            return;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }    
    
    /**
     * Generate the value Y basead on the X, Q (prime) and Alfa to a person.
    */
    public void generateY(){
        BigInteger x, y, alfa, q; 
        x = new BigInteger(Integer.toString(this.getX()));
        alfa = new BigInteger(Integer.toString(this.getAlfa()));
        q = new BigInteger(Integer.toString(this.getQ()));
        
        y = alfa.modPow(x, q);
        System.out.println("Resultado Y eh: " + y.intValue() );

        this.setY(y.intValue());
    }
    
    /**
     * Generate the key K baseado on the X from a person, the Q (the definided prime)
     * and the Y from a other person with the equation: (otherY)^X mod Q
     * @param otherY: the Y of another pair
    */
    public BigInteger generateK(int otherY){
        BigInteger k, x, y, q; 
        Integer.toString(this.getX());
        x = new BigInteger(Integer.toString(this.getX()));
        y = new BigInteger(Integer.toString(otherY));
        q = new BigInteger(Integer.toString(this.getQ()));
        k = y.modPow(x, q);               
        System.out.println("Resultado K eh: " + k.intValue() );
        return k;
    }
    
    public static void main(String[] args) {
        /*DiffieHellman A, B;
        A = new DiffieHellman(4, 2);
        B = new DiffieHellman(4, 2);
                
        A.setX(97);
        B.setX(233);
        
        
        A.generateY();
        B.generateY();
        
        A.generateK(B.getY());
        B.generateK(A.getY()); */
        String s = "Header|Y:17|BritneySpears|Header";
        System.out.println(s.length());
        String header = s.substring(7,s.lastIndexOf("Header"));
        String dados[] = header.split("\\|");
        System.out.println(header);
        for(String a: dados)
        {
            System.out.println(a+" - "+a.substring(0,1));
            if(a.substring(0,2).compareTo("Y:")==0)
            {
                System.out.println(a.substring(2, a.length())+" agora achou");
            }
        }
    }
}
