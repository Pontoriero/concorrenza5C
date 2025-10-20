/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_guglielmi;

import java.util.Random;

/**
 *
 * @author verifica
 */
public class Pista_guglielmi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pista p=new Pista();
        
        
        for (int i = 0; i < 10; i++) {
            int r=(int) (Math.random()*10+1);
            new Aereo(r,p).start();
        }
    }
    
}
