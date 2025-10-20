/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_migale;

/**
 *
 * @author verifica
 */
public class MioThread extends Thread {

    private int v[];
    private int risultato[];
    private int inizio;
    private int fine;

    public MioThread(int[] v, int[] risultato,int inizio,int fine) {
        this.v = v;
        this.risultato = risultato;
        this.inizio = inizio;
        this.fine = fine;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < risultato.length; i++) {
            s += risultato[i] + " ";
        }
        return s;
    }

    @Override
    public void run() {
        try {
            int n1=0;
            for (int i = inizio; i < fine; i++) {
               risultato[i]=v[i]*i;
                       
            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {

            System.out.println("errore " + e.getMessage());
        }
    }
}
