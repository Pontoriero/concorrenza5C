/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pista_bruno;

/**
 *
 * @author verifica
 */
public class Aerei extends Thread{
    private int numId;
    private Pista p;

    public Aerei(int numId, Pista p) {
        this.numId = numId;
        this.p = p;
    }

    public int getNumId() {
        return numId;
    }

    public Pista getP() {
        return p;
    }

    public void setNumId(int numId) {
        this.numId = numId;
    }

    public void setP(Pista p) {
        this.p = p;
    }
    
    


    
    @Override
    public void run() {
        try {
            int x=(int)(Math.random()*1000)+1000;
            if (numId>6) {
                p.entraInter();
                Thread.sleep(x);
                p.esceInter();
                Thread.sleep(1000);
               
            }
            else {
                p.entraNaz();
                Thread.sleep(x);
                p.esciNaz();
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.println("errore" + ex.getMessage());
        }
    }



  
    
}
