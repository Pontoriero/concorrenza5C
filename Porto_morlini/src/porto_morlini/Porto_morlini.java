/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porto_morlini;

/**
 *
 * @author verifica
 */
public class Porto_morlini {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Banchina b = new Banchina();
        Nave n1 = new Nave(b);
        Nave n2 = new Nave(b);
        Nave n3 = new Nave(b);
        Nave n4 = new Nave(b);
        Nave n5 = new Nave(b);
        Nave n6 = new Nave(b);
        Nave n7 = new Nave(b);
        Nave n8 = new Nave(b);
        Nave n9 = new Nave(b);
        Nave n10 = new Nave(b);
        
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
            System.out.println("Errore" + e.getMessage());
        }
    }
    
}
