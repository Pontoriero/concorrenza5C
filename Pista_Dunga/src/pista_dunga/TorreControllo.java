/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_dunga;

/**
 *
 * @author verifica
 */
public class TorreControllo {
    
    private final int N = 3;
    private int nazionali;
    private int internazionali;
    private int attesaInternazionali;
    
    public synchronized void entraInternazionale(Aereo a) throws InterruptedException {
        System.out.println("Aereo internazionale " + a.getID() + " richede l'accesso");
        attesaInternazionali++;
        while(internazionali==N || nazionali>0) {
            wait();
        }
        internazionali++;
        attesaInternazionali--;
        System.out.println("Aereo internazionale " + a.getID() + " atterrato");
        System.out.println("Aereo internazionale " + a.getID() + " in pista");
        System.out.println("Posti occupati: " + internazionali);
        notifyAll();
    }
    
    public synchronized void entraNazionale(Aereo a) throws InterruptedException {
        System.out.println("Aereo nazionale " + a.getID() + " richede l'accesso");
        while(nazionali==N || internazionali>0 || attesaInternazionali>0) {
            wait();
        }
        nazionali++;
        System.out.println("Aereo nazionale " + a.getID() + " atterrato");
        System.out.println("Aereo nazionale " + a.getID() + " in pista");
        System.out.println("Posti occupati: " + nazionali);
        notifyAll();
    }
    
    public synchronized void esceInternazionale(Aereo a) throws InterruptedException {
        while(internazionali==0) {
            wait();
        }
        internazionali--;
        System.out.println("Aereo internazionale " + a.getID() + " libera la pista");
        System.out.println("Posti liberi: " + (N-internazionali));
        notifyAll();
    }
    
    public synchronized void esceNazionale(Aereo a) throws InterruptedException {
        while(nazionali==0) {
            wait();
        }
        nazionali--;
        System.out.println("Aereo nazionale " + a.getID() + " libera la pista");
        System.out.println("Posti liberi: " + (N-nazionali));
        notifyAll();
    }
    
}
