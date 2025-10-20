/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porto_migale;

import java.util.Random;

/**
 *
 * @author verifica
 */
public class Porto_Migale {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Random r=new Random();
        CapitaneriaDiPorto c =new CapitaneriaDiPorto();
        int id=(int) (Math.random()*10+1);
        for (int i = 0; i < 10; i++) {
            new Navi(c,id).start();
        }
    }
    
}
