/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_dunga;

/**
 *
 * @author verifica
 */
public class Pista_Dunga {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        TorreControllo p = new TorreControllo();
        
        Aereo a1 = new Aereo(p,1,false);
        Aereo a2 = new Aereo(p,2,false);
        Aereo a3 = new Aereo(p,3,false);
        Aereo a4 = new Aereo(p,4,false);
        Aereo a5 = new Aereo(p,5,false);
        Aereo a6 = new Aereo(p,6,true);
        Aereo a7 = new Aereo(p,7,true);
        Aereo a8 = new Aereo(p,8,true);
        Aereo a9 = new Aereo(p,9,true);
        Aereo a10 = new Aereo(p,10,true);
        
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
        
        try {
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
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
