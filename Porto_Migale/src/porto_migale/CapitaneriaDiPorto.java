/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porto_migale;

/**
 *
 * @author verifica
 */
public class CapitaneriaDiPorto {

    private final int MAX = 3;
    private int internazionali = 0;
    private int nazionali = 0;
    private int attesaInternazionali = 0;
    private int attesaNazionali = 0;

    public synchronized void entraNazionali() throws InterruptedException {

        attesaNazionali++;
        while (nazionali == MAX || attesaInternazionali > 0 || internazionali > 0) {
            wait();
        }
        nazionali++;
        attesaNazionali--;
        System.out.println("nave nazionale richiede l'accesso ed entra ");
        System.out.println("posti occupati: " + nazionali + "/" + MAX);
        notifyAll();
    }

    public synchronized void entraInternazionali() throws InterruptedException {
       
        attesaInternazionali++;
        while (internazionali == MAX || nazionali > 0) {
            wait();
        }
        internazionali++;
        attesaInternazionali--;
        System.out.println("nave internazionale richiede l'accesso ed entra");
        System.out.println("posti occupati: " + internazionali + "/" + MAX);
        notifyAll();
    }

    public synchronized void esceInternazionali() throws InterruptedException {
        while (internazionali == 0) {
            wait();
        }
        internazionali--;
        System.out.println("nave internazionale lascia la banchina");
        System.out.println("posti occupati: " + internazionali + "/" + MAX);
        notifyAll();
    }

    public synchronized void esceNazionali() throws InterruptedException {
        while (nazionali == 0) {
            wait();
        }
        nazionali--;
        System.out.println("nave nazionale lascia la banchina");
        System.out.println("posti occupati: " + nazionali + "/" + MAX);
        notifyAll();
    }

}
