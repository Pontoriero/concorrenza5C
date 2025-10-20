/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_bagni;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author verifica25
 */
public class Aereo extends Thread{
    private int id;
    private TorreControllo t;

    public Aereo(int id, TorreControllo t) {
        this.id = id;
        this.t = t;
    }
    

    @Override
    public void run() {
        try{
            if(id<=5){
                t.atterraNaz();
                Thread.sleep((int) (Math.random()*10000)+10000);
                t.decollaNaz();
            }else{
                t.atterraInter();
                Thread.sleep((int) (Math.random()*10000)+10000);
                t.decollaInter();
            }
        } catch (InterruptedException ex) {
            System.out.println("errore "+ex.getMessage());
        }
    }
    
    
}
