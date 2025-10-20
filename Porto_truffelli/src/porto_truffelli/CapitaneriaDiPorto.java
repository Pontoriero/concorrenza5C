/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porto_truffelli;

/**
 *
 * @author verifica
 */
public class CapitaneriaDiPorto {
    private final int MAX=3;
    private int nNazio=0; //numero navi nazionali in porto
    private int nInter=0; //numero navi internazionali in porto
    private int codaNazio=0; //navi nazionali in coda
    private int codaInter=0; //navi internazionali in coda
    
    public synchronized void entraNazio(int id) throws InterruptedException{
        System.out.println("Nave nazionale "+id+" richiede l'accesso");
        codaNazio++;
        while(nNazio==MAX || nInter>0 || codaInter>0){ //precedenza alle navi internazionali
            wait();
        }
        System.out.println("Nave nazionale "+id+" attracca");
        nNazio++;
        codaNazio--;
        System.out.println("Nave nazionale "+id+" è in banchina");
        notifyAll();
    }
    public synchronized void entraInter(int id) throws InterruptedException{
        System.out.println("Nave internazionale "+id+" richiede l'accesso");
        codaInter++;
        while(nInter==MAX || nNazio>0){ //controllo solo se è piena la banchina o se c'è una nave nazionale
            wait();
        }
        System.out.println("Nave internazionale "+id+" attracca");
        nInter++;
        codaInter--;
        System.out.println("Nave internazionale "+id+" è in banchina");
        notifyAll();
    }
    public synchronized void esciNazio(int id) throws InterruptedException{
        while(nNazio==0){
            wait();
        }
        System.out.println("Esce nave nazionale "+id);
        nNazio--;
        notifyAll();
    }
    public synchronized void esciInter(int id) throws InterruptedException{
        while(nInter==0){
            wait();
        }
        System.out.println("Esce una nave internazionale "+id);
        nInter--;
        notifyAll();
    }
}
