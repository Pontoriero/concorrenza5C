/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porto_palladino;

/**
 *
 * @author verifica
 */
public class Nave implements Runnable {
    private int id;
    private CapitaneriaDiPorto buffer;
    
    public Nave(int id, CapitaneriaDiPorto buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    public int getid(){
        return id;
    }
    
    public boolean isInternazionale(){
        return (id>=6 && id <= 10);
    }
    
    @Override
    public void run(){
        try{
            buffer.entraNave(this);
            Thread.sleep((int) Math.random() * 10 + 10);
            buffer.esceNave(this);
        }catch(InterruptedException e){ 
            System.out.println("Errore: " + e.getMessage());
        }
    }
    
}
