/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_celani;

import java.util.ArrayList;

/**
 *
 * @author verifica
 */
public class Pista_Celani {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Thread> aerei = new ArrayList<>();
        TorreControllo t=new TorreControllo();
        for(int i=0;i<10;i++){
            aerei.add(new Thread(new Aereo(t)));
        }
        
        for (Thread th : aerei) {
            th.start();
        }

        try {
            for (Thread th : aerei) {
                th.join();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("La pista e completamente libera");
    }
    
}
