/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porto_truffelli;

import java.util.ArrayList;

/**
 *
 * @author verifica
 */
public class Porto_truffelli {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CapitaneriaDiPorto c = new CapitaneriaDiPorto();
        
        //creo 10 navi
        Nave n1 = new Nave(c,1);
        Nave n2 = new Nave(c,2);
        Nave n3 = new Nave(c,3);
        Nave n4 = new Nave(c,4);
        Nave n5 = new Nave(c,5);
        Nave n6 = new Nave(c,6);
        Nave n7 = new Nave(c,7);
        Nave n8 = new Nave(c,8);
        Nave n9 = new Nave(c,9);
        Nave n10 = new Nave(c,10);
        
        n1.start();
        n2.start();
        n3.start();
        n4.start();
        n5.start();
        n6.start();
        n7.start();
        n8.start();
        n9.start();
        n10.start();
        
        try{
            n1.join();
            n2.join();
            n3.join();
            n4.join();
            n5.join();
            n6.join();
            n7.join();
            n8.join();
            n9.join();
            n10.join();
        }catch(InterruptedException e){
            System.out.println("Errore: "+e.getMessage());
        }
        System.out.println("Fine programma");
    }
    
}
