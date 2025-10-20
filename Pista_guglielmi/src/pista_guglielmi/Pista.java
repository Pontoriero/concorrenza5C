/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_guglielmi;

/**
 *
 * @author verifica
 */
public class Pista {
    private int aereiNazDentro=0;
    private int aereiNazFuori=0;
    private int aereiIntDentro=0;
    private int aereiIntFuori=0;
    private final int MAX=3;

    public Pista() {
    }
    
    public synchronized void entraNaz() throws InterruptedException{
        aereiNazFuori++;
        while(aereiNazDentro==MAX || aereiIntDentro>0 || aereiIntFuori>0){
            wait();
        }
        aereiNazFuori--;
        aereiNazDentro++;
        System.out.println("aereo NAZIONALE in pista --> situazione piste occupate: "+ aereiNazDentro + "/"+MAX);
        notifyAll();
    }
    public synchronized void entraInt() throws InterruptedException{
        aereiIntFuori++;
        while(aereiIntDentro==MAX || aereiNazDentro>0){
            wait();
        }
        aereiIntFuori--;
        aereiIntDentro++;
        System.out.println("aereo INTERNAZIONALE in pista --> situazione piste occupate: "+ aereiIntDentro + "/"+MAX);
        notifyAll();
    }
    public synchronized void esceNaz() throws InterruptedException{
        while(aereiNazDentro==0){
            wait();
        }
        aereiNazDentro--;
        System.out.println("aereo NAZIONALE uscito --> situazione piste occupate: "+ aereiNazDentro + "/"+MAX);
        notifyAll();
    }
    public synchronized void esceInt() throws InterruptedException{
        while(aereiIntDentro==0){
            wait();
        }
        aereiIntDentro--;
        System.out.println("aereo INTERNAZIONALE uscito --> situazione piste occupate: "+ aereiIntDentro + "/"+MAX);
        notifyAll();
    }
}
