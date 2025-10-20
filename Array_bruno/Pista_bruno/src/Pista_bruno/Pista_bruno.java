/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pista_bruno;

import java.util.Random;

/**
 *
 * @author verifica
 */
public class Pista_bruno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int maxA=10;

        Pista p = new Pista();
        for (int i=0;i<maxA;i++) {
            int id=(int)(Math.random()*10)+1;
            new Aerei(id,p).start();
        }
    }
    
}
