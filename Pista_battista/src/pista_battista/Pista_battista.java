/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_battista;

import java.util.ArrayList;

/**
 *
 * @author verifica
 */
public class Pista_battista {
    public static void main(String[] args) {
        TorreControllo torre = new TorreControllo();
        ArrayList<Aereo> aerei = new ArrayList<Aereo>();
        int codici [] = {1, 1, 6, 7, 3, 3, 9, 9, 2, 3};
        
        // creazione aerei
        for (int i = 0; i < 10; i++) {
            //int x = (int) (Math.random()*4)+1;
            aerei.add(new Aereo("aereo " + i, codici[i], torre));
        }
        
        // creazione thread
        ArrayList<Thread> thread = new ArrayList<Thread>();
        for (Aereo a : aerei) {
            thread.add(new Thread(a));
        }
        
        // start
        for (Thread t : thread) {
            t.start();
        }
        
        // join
        for (Thread t : thread) {
            try{
                t.join();
            }catch(InterruptedException e){
                System.out.println("Errore: " + e.getMessage());
            }
        }
        
        System.out.println("FINE");
        
    }
    
}
