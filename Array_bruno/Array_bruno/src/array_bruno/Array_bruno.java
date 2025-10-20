/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_bruno;

import java.util.ArrayList;

/**
 *
 * @author verifica
 */
public class Array_bruno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //generazione lunghezza array casuale
        int lunghezzaN = (int)(Math.random()*10)+10;
        System.out.println("lunghezza array: " + lunghezzaN);
        
        //generazione numero thread utilizzati casuale
        int Nthread = (int)(Math.random()*2)+3;
        System.out.println("numero thread: " + Nthread);
        
        
        //stampa array iniziale
        int [] v1 = new int[lunghezzaN];
        System.out.println("array generato:");
        for (int i=0;i<lunghezzaN;i++) {
            v1[i] = (int)(Math.random()*100)+1;
            System.out.print("[" + v1[i] + "]");
        }
        
        //dim = numero posizioni che scorre ogni array 
        int dim = lunghezzaN/Nthread;
        ArrayList<MyThread> t1 = new ArrayList<MyThread>();
        
        //array con risultati
        int[] ris = new int[lunghezzaN];
        
        
        for (int i=0;i<Nthread;i++) {
            int start=0;
            start=start+dim;
            MyThread t = new MyThread(start,(start+dim),v1,ris);
            t.start();
            
            try {
                t.join();
            }
            catch(InterruptedException ex) {
                System.out.println("errore " + ex.getMessage());
            }
            t1.add(t);
        }
        
        //stampa dell'array con i risultati
        System.out.println();
        for (int i=0;i<lunghezzaN;i++) {
            System.out.print("[" + ris[i] + "]");
        }
    }
    
}
