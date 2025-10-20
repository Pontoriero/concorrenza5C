/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porto_fosi;

/**
 *
 * @author verifica
 */
public class Porto implements Runnable{
    private final int MAX=3;
    private int attesaNazionali=0;
    private int attesaInternazionali=0;
    private int nazionali=0;
    private int internazionali=0;
    
    
    public synchronized void entraNazionali() throws InterruptedException{
        
        attesaNazionali++;
        while(nazionali==MAX || internazionali>0 || attesaInternazionali>0){
            wait();
        }
        System.out.println("una nave nazionale sta entrando" + nazionali);
        Thread.sleep((int)((Math.random()*11)+10));
        nazionali++;  
        notifyAll();
        
    }
    public synchronized void  entraInternazionali() throws InterruptedException{
        
        attesaInternazionali++;
        while(internazionali==MAX || nazionali>0){
            wait();
        }
        System.out.println("una nave internazionale sta entrando: " + internazionali);
        Thread.sleep((int)((Math.random()*11000)+10000));
        internazionali++;
        notifyAll();
        
    }
    public synchronized void esciNazionali() throws InterruptedException{
        
        while(nazionali==0 || internazionali>0){
            wait();
        }
        System.out.println("una nave nazionale sta uscendo: "+ nazionali);
        nazionali--;
        notifyAll();
    }
    public synchronized void esciinterNazionali() throws InterruptedException{
        
        while(internazionali==0 || nazionali>0){
            wait();
        }
        System.out.println(" la nave internazionale sta uscendo: " + internazionali);
        nazionali--;
        notifyAll();
    }
/*
    @Override
    public void run() {
        try{
            
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }*/

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
