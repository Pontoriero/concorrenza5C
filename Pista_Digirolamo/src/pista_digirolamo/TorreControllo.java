/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_digirolamo;

/**
 *
 * @author verifica25
 */
public class TorreControllo {
    private final int DIM=3;
    private int aereoN;
    private int aereoInt;
    private int aereoNCoda;
    private int aereoIntCoda;

    public TorreControllo() {
       aereoN=0;
       aereoInt=0;
       aereoNCoda=0;
       aereoIntCoda=0;
    }
    
    public synchronized void entraAereoN() throws InterruptedException{
        aereoNCoda++;
        while(aereoIntCoda>0 || aereoInt>0 || aereoN==DIM){
            wait();
        }
        aereoNCoda--;
        aereoN++;
        System.out.println("Nuovo aereo nazionale in pista: "+aereoN+"/3");
        notifyAll();
    }
    
    public synchronized void entraAereoInt() throws InterruptedException{
        aereoIntCoda++;
        while(aereoInt==DIM){
            wait();
        }
        aereoIntCoda--;
        aereoInt++;
        System.out.println("Nuovo aereo internazionale in pista: "+aereoInt+"/3");
        notifyAll();
    }
    
    public synchronized void esceAereoN() throws InterruptedException{
        while(aereoN==0){
            wait();
        }
        aereoN--;
        System.out.println("Aereo nazionale uscito dalla pista: "+aereoN+"/3");
        notifyAll();
    }

    public synchronized void esceAereoInt() throws InterruptedException{
        while(aereoInt==0){
            wait();
        }
        aereoInt--;
        System.out.println("Aereo internazionale uscito dalla pista: "+aereoInt+"/3");
        notifyAll();
    }
}
