/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porto_truffelli;

/**
 *
 * @author verifica
 */
public class Nave extends Thread{
    private CapitaneriaDiPorto c;
    private int id; //numero passato dal main (da 1 a 10)

    public Nave(CapitaneriaDiPorto c, int id) {
        this.c = c;
        this.id = id;
    }
    
    @Override
    public void run(){
        if(id<6){ //è nazionale
            try{
                c.entraNazio(id);
                Thread.sleep((int)(Math.random()*10000)+10000); //aspetto da 10 a 20 secondi
                c.esciNazio(id);
            }catch(InterruptedException e){
                System.out.println("Errore: "+e.getMessage());
            }
        }
        else{ //è internazionale
            try{
                c.entraInter(id);
                Thread.sleep((int)(Math.random()*10000)+10000); //aspetto da 10 a 20 secondi
                c.esciInter(id);
            }catch(InterruptedException e){
                System.out.println("Errore: "+e.getMessage());
            }
        }
    }
}
