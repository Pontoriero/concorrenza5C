/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_battista;

import java.util.ArrayList;

/**
 *
 * @author verifica
 */

// monitor
public class TorreControllo {
    private ArrayList<String> piste;
    private int numInter;
    private int numNaz;
    private int attesaInter;
    private int attesaNaz;

    public TorreControllo() {
        piste = new ArrayList<String>();
        this.numInter = 0;
        this.numNaz = 0;
        this.attesaInter = 0;
        this.attesaNaz = 0;
    }
    
    /* metodi synchronized */
    public synchronized void entraInter(String nome) throws InterruptedException{
        System.out.println(nome + " richiede l'atterraggio. (inter)");
        attesaInter++;
        while(piste.size() == 3 || numNaz > 0){
            wait();
        }
        
        attesaInter--;
        numInter++;
        piste.add(nome);
        
        System.out.println(nome + " è atterrato. (inter)");
        notifyAll();
    }
    
    public synchronized void entraNaz(String nome) throws InterruptedException{
        System.out.println(nome + " richiede l'atterraggio. (nazionale)");
        attesaNaz++;
        while(piste.size() == 3 || numInter > 0 || attesaInter > 0){
            wait();
        }
        
        attesaNaz--;
        numNaz++;
        piste.add(nome);
        
        System.out.println(nome + " è atterrato. (nazionale)");
        notifyAll();
    }
    
    public synchronized void uscitaNaz(String nome) throws InterruptedException{
        while(piste.size() == 0){
            wait();
        }
        
        numNaz--;
        piste.remove(nome);
        System.out.println(nome + " è decollato. (nazionale)" );
        
        notifyAll();
    }
    
    public synchronized void uscitaInter(String nome) throws InterruptedException{
        while(piste.size() == 0){
            wait();
        }
        
        numInter--;
        piste.remove(nome);
        System.out.println(nome + " è decollato. (inter)" );
        
        notifyAll();
    }
    
}
