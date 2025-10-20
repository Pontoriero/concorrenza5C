/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_burani;

/**
 *
 * @author verifica
 */
public class Lavoratore implements Runnable{
    private final int [] arr;
    private final int inizio;
    private final int fine;

    public Lavoratore(int[] arr, int inizio, int fine) {
        this.arr = arr;
        this.inizio = inizio;
        this.fine = fine;
    }
    
    @Override
    public void run(){
        for(int i=inizio; i<=fine; i++){
            int valore = (int) Math.sqrt(i) + (fine-inizio);
            arr[i] = valore;
        }
        
        System.out.println(Thread.currentThread().getName() + "ha lavorato sugli indici [" + inizio + "," + fine + "]");
    }
    
}
