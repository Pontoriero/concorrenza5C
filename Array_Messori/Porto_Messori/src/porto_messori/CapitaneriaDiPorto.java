/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porto_messori;

/**
 *
 * @author verifica
 */
public class CapitaneriaDiPorto {
    private int max = 3;
    private int attesaNaz = 0;
    private int attesaInter = 0;
    private int naz = 0;
    private int inter = 0;
    
 
    
    
    
    public synchronized void entraNazionale() throws InterruptedException{
        attesaNaz++;
        while(attesaInter > 0 || naz == max || inter > 0){
            wait();
        }
        attesaNaz--;
        naz++;
        System.out.println("Entra una nave nazionale");
        System.out.println("Posti occupati: " + naz + " / 3");
        notifyAll();
    }
    
    public synchronized void esceNazionale() throws InterruptedException{
        while(naz == 0){
            wait();
        }
        naz--;
        System.out.println("Esce una nave nazionale");
        System.out.println("Posti occupati: " + naz + " / 3");
        notifyAll();
    }

    public synchronized void entraInter() throws InterruptedException{
        attesaInter++;
        while(inter == max || naz > 0){
            wait();
        }
        attesaInter--;
        inter++;
        System.out.println("Entra una nave internazionale");
        System.out.println("Posti occupati: " + inter + " / 3");
        notifyAll();
    }
    
    public synchronized void esceInter() throws InterruptedException{
        while(inter == 0){
            wait();
        }
        inter--;
        System.out.println("Esce una nave internazionale");
        System.out.println("Posti occupati: " + inter + " / 3");
        notifyAll();
    }
}
