/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_kumar;

/**
 *
 * @author verifica
 */
public class Moltiplica implements Runnable{
    
    private int []v;
    private int []v1;
    private int inizio;
    private int fine;

    public Moltiplica(int[] v, int[] v1, int inizio,int fine) {
        setV(v);
        setV1(v1);
        setInizio(inizio);
        setFine(fine);
    }

    public int[] getV() {
        return v;
    }

    public void setV(int[] v) {
        this.v = v;
    }

    public int[] getV1() {
        return v1;
    }

    public void setV1(int[] v1) {
        this.v1 = v1;
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
    public void run() {
        for (int i = inizio; i < fine; i++) {
            v1[i]=v[i]*i;
        }
    }

    
    
}
