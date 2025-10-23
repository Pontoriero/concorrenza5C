/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_bertolotti;

/**
 *
 * @author verifica25
 */
public class Aereo implements Runnable{
    private int id;
    private TorreControllo t;
    
    public Aereo(int id,TorreControllo t){
        this.id = id;
        this.t = t;
    }
    
    @Override
    public void run(){
        try{
            t.Atterraggio(id);
        }catch(InterruptedException e){
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
