/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porto_kumar;

/**
 *
 * @author verifica
 */
public class CapitaneriaDiPorto {
    private final int N_MAX=3;
    private int nazionali=0;
    private int internazionali=0;
    private int AttesaNazionale=0;
    private int AttesaInternazionale=0;
    
    public synchronized void entraNazionale() throws InterruptedException{
        AttesaNazionale++;
        while(nazionali==N_MAX || internazionali>0 || AttesaInternazionale >0){
            wait();
            System.out.println("nave nazionale in attesa di entrare");
        }
        nazionali++;
        AttesaNazionale--;
        System.out.println("la nave nazionale e' entrata.");
        notifyAll();
    }
    public synchronized void entraInterazionale() throws InterruptedException{
        AttesaInternazionale++;
        while(internazionali==N_MAX || nazionali>0){
            wait();
            System.out.println("nave internazionale in attesa di entrare");
        }
        internazionali++;
        AttesaInternazionale--;
        System.out.println("la nave internazionale e' entrata.");
        notifyAll();
    }
    public synchronized void esceNazionale() throws InterruptedException{
        while(nazionali==0){
            wait();
        }
        nazionali--;
        System.out.println("la nave nazionale e' uscita.");
        notifyAll();
    }
    public synchronized void esceInternazionale() throws InterruptedException{
        while(internazionali==0){
            wait();
        }
        internazionali--;
        System.out.println("la nave internazionale  e' uscita.");
        notifyAll();
    }
}
