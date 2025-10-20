/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_perini;

import java.util.ArrayList;

/**
 *
 * @author verifica
 */
public class Array_Perini {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int N = (int) (Math.random()*18)+12;
        int k = (int) (Math.random()*4)+3;
        int c=0;
        
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> ris = new ArrayList<>();
        
        //carico array
        for(int i=0; i<N; i++){
            int rand = (int) (Math.random()*99)+1;
            a1.add(rand);    
        }
        
        System.out.println("Array a1 contenete valori con cui fare i calcoli: " + a1);
        //System.out.println("Numero di thread: " + k);

        
        //creo k thread
        for(int i=3; i<k;i++){
            c++;
            if(c==1){
                System.out.println("inizio: 0");
               new Calcoli(a1,ris,0,N/k).start();
                System.out.println("fine: " + N/k);
            }
            else if(c == 2){
                System.out.println("inizio: " + N/k);
                new Calcoli(a1,ris,N/k,(N/k)*2).start();
                System.out.println("fine: " + (N/k)*2);
            }
            else if(c == 3){
                System.out.println("inizio: " + (N/k)*2);
                new Calcoli(a1,ris,(N/k)*2,(N/k)*3).start();
                System.out.println("fine: " + (N/k)*3);
            }else if(c == 4){
                System.out.println("inizio: " + (N/k)*3);
                 new Calcoli(a1,ris,(N/k)*3,(N/k)*4).start();
                 System.out.println("fine: " + (N/k)*4);
            }
            
            System.out.println("Array con risultati: " + ris);
            
        }
        
        
        
        
        
    }
    
}
