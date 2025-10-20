/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_ferrari;

/**
 *
 * @author verifica
 */
public class Pista_Ferrari {

    public static void main(String[] args) {
        TorreControllo pista = new TorreControllo();
        
        Aereo a1 = new Aereo(pista, 1);
        Aereo a2 = new Aereo(pista, 2);
        Aereo a3 = new Aereo(pista, 3);
        Aereo a4 = new Aereo(pista, 4);
        Aereo a5 = new Aereo(pista, 5);
        Aereo a6 = new Aereo(pista, 6);
        Aereo a7 = new Aereo(pista, 7);
        Aereo a8 = new Aereo(pista, 8);
        Aereo a9 = new Aereo(pista, 9);
        Aereo a10 = new Aereo(pista, 10);
        
        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();
        a6.start();
        a7.start();
        a8.start();
        a9.start();
        a10.start();
        
        try{
            a1.join();
            a2.join();
            a3.join();
            a4.join();
            a5.join();
            a6.join();
            a7.join();
            a8.join();
            a9.join();
            a10.join();
        }catch(InterruptedException e){
            System.out.println("Errore: " + e);
        }
        
        System.out.println("FINE");
    }

}
