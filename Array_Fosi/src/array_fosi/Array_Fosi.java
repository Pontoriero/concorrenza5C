/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_fosi;

/**
 *
 * @author verifica
 */
public class Array_Fosi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int N=(int)(Math.random()*18);
        System.out.println("N=" + N);
        int v[]=new int[N];
        for (int i = 0; i < N; i++) {
            v[i]=(int)(Math.random()*99+1);
        }
        
        int K=(int)((Math.random()*3)+1);
        System.out.println("i Thread sono: " + K);
        
        int nt=N/K;
        
        Calcola c1=new Calcola(v,0,nt);
        Calcola c2=new Calcola(v,nt,nt*2-1);
        Calcola c3=new Calcola(v,nt*3,N-nt-1);
        Calcola c4=new Calcola(v,N-nt,N);
        
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        
        
        
        
    }
    
       
        
}
