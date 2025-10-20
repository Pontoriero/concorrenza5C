/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_burani;

/**
 *
 * @author verifica
 */
public class Pista_burani {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TorreControllo torre = new TorreControllo(3);
        
        Thread [] threads = new Thread [10];
        
        for(int i=0; i<10; i++){
            TipoAereo tipo = (i<5) ? TipoAereo.NAZIONALE  : TipoAereo.INTERNAZIONALE;
            Aereo a = new Aereo ("Aereo: " + (i+1), tipo, torre);
            
            threads[i] = new Thread (a, a.getNome());
            threads [i].start();
        }
        
        for(Thread t: threads){
            try{
                t.join();
            }catch(InterruptedException e){
                System.out.println("Errore");
            }
        }
        
        System.out.println("FINE PROGRAMMA");
    }
    
}
