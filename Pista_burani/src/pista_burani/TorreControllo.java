/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_burani;

/**
 *
 * @author verifica
 */
public class TorreControllo {
    private int pisteOccupate =0;
    private final int CAP;
    private int attesaNaz=0;
    private int attesaInt=0;
    private int tipoCorrente=0;
    private int consecutiviInt=0;
    private final int MAX_INT_CONSECUTIVI = 5;

    public TorreControllo(int cap) {
        this.CAP = cap;
    }
    
    public synchronized void entraNazionale() throws InterruptedException{
        attesaNaz++;
        
        while(pisteOccupate == CAP || tipoCorrente==2 || (tipoCorrente==0 && attesaInt>0 && consecutiviInt < MAX_INT_CONSECUTIVI)){
            wait();
        }
        
        attesaNaz--;
        pisteOccupate++;
        tipoCorrente=1;
        consecutiviInt=1;
        
        System.out.println(Thread.currentThread().getName() + "Nazionale atterra e le piste occupate sono: " + pisteOccupate);
    }
    
    public synchronized void esciNazionale() throws InterruptedException{
        pisteOccupate--;
        System.out.println(Thread.currentThread().getName() + "Nazionale decolla e le piste occupate sono: " + pisteOccupate);
        
        if(pisteOccupate == 0){
            tipoCorrente =0;
        }
        
        notifyAll();
    }
    
    public synchronized void entraInternazionale() throws InterruptedException{
        attesaInt++;
        
        while(pisteOccupate == CAP || tipoCorrente==1 || (tipoCorrente==0 && attesaNaz>0 && consecutiviInt >= MAX_INT_CONSECUTIVI)){
            wait();
        }
        
        attesaInt--;
        pisteOccupate++;
        tipoCorrente=2;
        consecutiviInt++;
        
        System.out.println(Thread.currentThread().getName() + "Internazionale atterra e le piste occupate sono: " + pisteOccupate);
    }
    
    public synchronized void esciInternazionale() throws InterruptedException{
        pisteOccupate--;
        System.out.println(Thread.currentThread().getName() + "Internazionale decolla e le piste occupate sono: " + pisteOccupate);
        
        if(pisteOccupate == 0){
            tipoCorrente =0;
        }
        
        notifyAll();
    }
    
    
    
}
