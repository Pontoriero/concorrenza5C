/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porto_morlini;

/**
 *
 * @author verifica
 */
public class Nave extends Thread{
    private boolean tipo = false; //true = internazionali, false = nazionali
    private Banchina b;
    
    public Nave(Banchina b) {
        if(Thread.currentThread().getId()>5){
            tipo=true;
        }
    }
    
    @Override
    public void run(){
        try{
            b.entraNave(tipo);
            int n = (int)(Math.random()*20)+10;
            Thread.sleep(n);
            b.esceNave(tipo);
        }catch(InterruptedException e){
            System.out.println("Errore: "+ e.getMessage());
        }
    }
}
