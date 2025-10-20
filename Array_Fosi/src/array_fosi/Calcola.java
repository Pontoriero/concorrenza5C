/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_fosi;

/**
 *
 * @author verifica
 */
public class Calcola extends Thread{
    
    private int []v;
    private int inizio;
    private int fine;
    private String s;

    public Calcola(int[] v, int inizio, int fine) {
        setV(v);
        setInizio(inizio);
        setFine(fine);
    }

    public int[] getV() {
        return v;
    }

    public void setV(int[] v) {
        this.v = v;
    }

    public int getInizio() {
        return inizio;
    }

    public void setInizio(int inizio) {
        this.inizio = inizio;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }
    
    
    @Override
    public void run(){
        
        for (int i = inizio; i < fine; i++) {
            
        }
    }
    
    
}
