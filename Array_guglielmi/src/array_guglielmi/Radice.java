/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_guglielmi;

/**
 *
 * @author verifica
 */
public class Radice extends Thread{
    private int [] a;
    private long [] risultato;
    private int inizio;
    private int fine;
    private int N;

    public Radice(int[] a, int inizio, int fine,int N) {
        this.inizio = inizio;
        this.a =a;
        this.fine = fine;
        this.risultato =new long [N];
    }

    public long[] getRisultato() {
        return risultato;
    }

    @Override
    public void run() {
        for (int i = inizio; i < fine; i++) {
            a[i]=(int)(Math.sqrt(a[i])+(fine-inizio));
            System.out.println(risultato[i]);
        }
    }

    @Override
    public String toString() {
        for (int i = 0; i < N; i++) {
            System.out.println(a[i]);
        }
        return "";
    }
    
    
}
