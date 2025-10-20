/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porto_malato;

/**
 *
 * @author verifica
 */
public class CapitaneriaDiPorto {
    private int attesaNazionali;
    private int attesaInternazionali;
    private int nazionali;
    private int internazionali;
    
    public synchronized void entraNazionali() throws InterruptedException {
        attesaNazionali++;
        System.out.println("Nave nazionale richiede l'accesso");
        while(internazionali != 0 || nazionali >= 3) {
            wait();
        }
        attesaNazionali--;
        nazionali++;
        System.out.println("Nave nazionale ha attraccato alla banchina");
        notifyAll();
    }
    
    public synchronized void entraInternazionali() throws InterruptedException {
        attesaInternazionali++;
        System.out.println("Nave internazionale richiede l'accesso");
        while(internazionali != 0 || nazionali >= 3) {
            wait();
        }
        attesaNazionali--;
        nazionali++;
        System.out.println("Nave internazionale ha attracato alla banchina");
        notifyAll();
    }
    
    public synchronized void esciNazionali() throws InterruptedException {
        while(nazionali == 0) {
            wait();
        }
        nazionali--;
        System.out.println("Nave nazionale ha lasciato la banchina");
        notifyAll();
    }
    
    public synchronized void esciInternazionali() throws InterruptedException {
        while(internazionali == 0) {
            wait();
        }
        internazionali--;
        System.out.println("Nave internazionale ha lasciato la banchina");
        notifyAll();
    }
}
