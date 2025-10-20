/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_bagni;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author verifica25
 */
public class Array_Bagni {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int N=(int)(Math.random()*10)+10;
        int K=(int)(Math.random()*3)+2;
        int v[]= new int[N];
        for(int i=0;i<N;i++){
            v[i]=(int)(Math.random()*101);
        }
        int sezione=N/K;
        
         
      //  ArrayList<Numeri>=new ArrayList(N);
        
        for(int i=0;i<K;i++){
            new Numeri(v,sezione).start();
        }
        
    }
    
}
