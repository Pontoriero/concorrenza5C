/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_bagni;

/**
 *
 * @author verifica25
 */
public class Pista_Bagni {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException{
        
        TorreControllo t=new TorreControllo();
        
        for(int id=1;id<11;id++){
            new Aereo(id,t).start();

        }
        for (int id = 1; id < 11; id++) {
            new Aereo(id, t).join();

        }

    }
    
}
