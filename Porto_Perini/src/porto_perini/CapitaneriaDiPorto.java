/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porto_perini;

/**
 *
 * @author verifica
 */
public class CapitaneriaDiPorto {
    private int internazionali = 0;
    private int nazionali = 0;
    private static int MAX = 3;
    private int codaInternazionali = 0;
    private int codaNazionali = 0;
    
    public synchronized void  entraInternazionale() throws InterruptedException{
        codaInternazionali++;
        while(internazionali == MAX || nazionali > 0 || codaNazionali > 0){
            wait();
        }
        codaInternazionali--;
        internazionali++;
        System.out.println("Una barca internazionale è entrata in porto.");
        System.out.println("Posti occupati nella banchina da barche internazionali: " + internazionali + "/" + MAX);
        notifyAll();
    }
    
    public synchronized void  esciInternazionale() throws InterruptedException{
        while(internazionali ==0){
            wait();
        }
        internazionali--;
        System.out.println("Una barca internazionale è uscita dal porto.");
        System.out.println("Posti rimanenti nella banchina di barche internazionali: " + (MAX-internazionali) + "/" + MAX);
        notifyAll();
    }
    public synchronized void  entraNazionale() throws InterruptedException{
        codaNazionali++;
        while(nazionali == MAX || internazionali > 0 || codaNazionali > 0){
            wait();
        }
        codaNazionali--;
        nazionali++;
        System.out.println("Una barca nazionale è entrata in porto.");
        System.out.println("Posti occupati nella banchina da barche nazionali: " + nazionali + "/" + MAX);
        notifyAll();
    }
    
    public synchronized void  esciNazionale() throws InterruptedException{
        while(nazionali ==0){
            wait();
        }
        nazionali--;
        System.out.println("Una barca nazionale è uscita dal porto.");
        System.out.println("Posti rimanenti nella banchina di barche nazionali: " + (MAX-nazionali) + "/" + MAX);
        notifyAll();
    }
}
