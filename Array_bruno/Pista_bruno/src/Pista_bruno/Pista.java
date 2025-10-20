/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pista_bruno;

/**
 *
 * @author verifica
 */
public class Pista {
    private final int max=3;
    private int nInter=0;
    private int Nnaz=0;
    private int AttesaInter=0;
    private int AttesaNaz=0;
    
    public synchronized void entraNaz() throws InterruptedException {
        AttesaNaz++;
        while(Nnaz==max || AttesaInter>0 ||  nInter>0 ) {
        wait();
    }
        Nnaz++;
        AttesaNaz--;
        System.out.println("aereo nazionale entrato, posti rimasti: " + Nnaz + "/" + max );
        notifyAll();
    }
    
    public synchronized void entraInter() throws InterruptedException {
        AttesaInter++;
        while(nInter==max || Nnaz>0) {
        wait();
    }
        nInter++;
        AttesaInter--;
        System.out.println("aereo internazionale entrato, posti rimasti: " + nInter + "/" + max );
        notifyAll();
    }
    
    public synchronized void esciNaz() throws InterruptedException {
        while(Nnaz==0) {
        wait();
    }
        Nnaz--;
        System.out.println("aereo nazionale uscito, posti rimasti: " + Nnaz + "/" + max );
        notifyAll();
    }
    public synchronized void esceInter() throws InterruptedException {
        while(nInter==0) {
        wait();
    }
        nInter--;
        System.out.println("aereo internazionale uscito, posti rimasti: " + Nnaz + "/" + max);
        notifyAll();
    }
}
