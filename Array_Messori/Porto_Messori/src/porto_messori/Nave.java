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
public class Nave extends Thread{
    private CapitaneriaDiPorto c;
    private int id;

    public Nave(int id, CapitaneriaDiPorto c) {
        this.c = c;
        this.id = id;
    }
    
    @Override
    public void run(){
        try{
            if(id < 5){
                c.entraNazionale();
                Thread.sleep((int) (Math.random()* 10000) + 10000);
                c.esceNazionale();
            }else{
                c.entraInter();
                Thread.sleep((int) (Math.random()* 10000) + 10000);
                c.esceInter();
            }
        }catch(InterruptedException e){
                System.out.println("Errore: " + e.getMessage());
        }
    }
    
}
