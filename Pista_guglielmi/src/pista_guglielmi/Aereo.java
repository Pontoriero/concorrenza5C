/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_guglielmi;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author verifica
 */
public class Aereo extends Thread{
    private int ID;
    private Pista p;
    
    public Aereo(int ID,Pista p) {
        this.ID = ID;
        this.p=p;
    }

    public int getID() {
        return ID;
    }

    @Override
    public void run() {
        int r=(int)(Math.random()*20000+10000);
        if(ID<=5 && ID>0){
            try {
                p.entraNaz();
                System.out.println("Aereo " + ID +" ha richiesto l'accesso");
                sleep(r);
                p.esceNaz();
            } catch (InterruptedException ex) {
                System.out.println("errore " + ex.getMessage());
            }
        }else if(ID>5 && ID<=10){
            try {
                p.entraInt();
                System.out.println("Aereo " + ID +" ha richiesto l'accesso");
                sleep(r);
                p.esceInt();
            } catch (InterruptedException ex) {
                System.out.println("errore " + ex.getMessage());
            }
        }else{
            System.out.println("errore inserimento ID aereo");
        }
    }
    
    
}
