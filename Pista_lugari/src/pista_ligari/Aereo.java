/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_ligari;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author verifica
 */
public class Aereo extends Thread{
    private Pista p;
    private int id1;

    public Aereo(Pista p, int id1) {
        this.p = p;
        this.id1 = id1;
    }

    public Pista getP() {
        return p;
    }

    public void setP(Pista p) {
        this.p = p;
    }

    public int getId1() {
        return id1;
    }

    public void setId(int id1) {
        this.id1 = id1;
    }
    @Override
    public void run(){
    int x=4;      //(int)(Math.random()*100+100);
        if(id1<5){
            try {
                p.accessoNaz();
                p.entraNaz();
                Thread.sleep(x);
                p.esceNaz();
            } catch (InterruptedException ex) {
                System.out.println("Errore: "+ex);
            }
        }
        else{
            try {
                p.accessoInter();
                p.entraInter();
                Thread.sleep(x);
                p.esceInter();
            } catch (InterruptedException ex) {
                System.out.println("Errore: "+ex);
            }
        }
    }
    
    
}
