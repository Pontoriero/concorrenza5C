/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_truffelli;

import java.util.ArrayList;

/**
 *
 * @author verifica
 */
public class Array_truffelli {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int N = (int)(Math.random()*6)+12; //lunghezza vettore random
        int arr[]= new int[N];
        
        for(int i=0;i<N;i++){ //inserisco nel vettore numeri casuali da 0 a 100
            arr[i] = (int)(Math.random()*100);
        }
        System.out.println("Vettore iniziale ("+N+" elementi):");
        stampa(arr,N); //stampo il vettore iniziale
        
        int nThread = (int)(Math.random()*2)+3; //genero il numero di thread random, 3 o 4
        System.out.println("\n\nIl calcolo viene suddiviso in "+nThread+" thread:");
        
        if(nThread==3){
            int j = N/3;
            Somma t1 = new Somma(arr,0,j);
            System.out.println("Il thread 1 gestisce da 1 a "+(j));
            Somma t2 = new Somma(arr,j,j*2);
            System.out.println("Il thread 2 gestisce da "+j+" a "+(j*2));
            Somma t3 = new Somma(arr,j*2,N);
            System.out.println("Il thread 3 gestisce da "+(j*2)+" a "+(N));
            
            t1.start();
            t2.start();
            t3.start();
            
            try{
                t1.join();
                t2.join();
                t3.join();
            }catch(InterruptedException e){
                System.out.println("Errore: "+e.getMessage());
            }
        }
        else{
            int j = N/4;
            Somma t1 = new Somma(arr,0,j);
            System.out.println("Il thread 1 gestisce da 1 a "+(j));
            Somma t2 = new Somma(arr,j,j*2);
            System.out.println("Il thread 2 gestisce da "+j+" a "+(j*2));
            Somma t3 = new Somma(arr,j*2,j*3);
            System.out.println("Il thread 3 gestisce da "+(j*2)+" a "+(j*3));
            Somma t4 = new Somma(arr,j*3,N);
            System.out.println("Il thread 3 gestisce da "+(j*3)+" a "+(N));
            
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            
            try{
                t1.join();
                t2.join();
                t3.join();
                t4.join();
            }catch(InterruptedException e){
                System.out.println("Errore: "+e.getMessage());
            }
        }
        System.out.println("\nVettore finale:"); //stampo il vettore finale
        stampa(arr,N);
    }
    
    public static void stampa(int[] vet,int n){ //funzione per stampare i vettori
        for(int i=0;i<n;i++){
            System.out.print(vet[i]+" ");
        }
    }
}
