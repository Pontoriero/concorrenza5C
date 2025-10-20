/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_burani;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author verifica
 */
public class Array_burani {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Random r = new Random();
        
        int N = 10 + r.nextInt(11);
        
        int[] a = new int [N];
        
        for(int i=0; i<N; i++){
            a[i] = r.nextInt(101);
        }
        
        int K = 3+r.nextInt(3);
        
        System.out.println("N = " + N + " e K = " + K);
        System.out.println("Array iniziale: " + Arrays.toString(a));
        
        Thread[] ts = new Thread [K];
        int base = N/K;
        
        int resto = N%K;
        
        int inizio = 0;
        
        for(int t=0; t<K; t++){
            int l = base + (t < resto ? 1:0);
            int fine = inizio + l -1;
            
            Lavoratore lav = new Lavoratore (a,inizio,fine);
            
            ts[t] = new Thread (lav, "T" + (t + 1));
            ts[t].start();
            
            inizio = fine + 1;
        }
        
        for(Thread th : ts){
            try{
                th.join();
            }catch(InterruptedException e){
                System.out.println("Errore");
            }
        }
        
        System.out.println("Array finale: " + Arrays.toString(a));
        System.out.println("FINE PROGRAMMA");
        
    }
    
}
