/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_celani;

/**
 *
 * @author verifica
 */
public class Aereo implements Runnable{
    private TorreControllo t;
    private int id;
    private static int cont=1;

    public Aereo( TorreControllo t) {
        this.t = t;
        id=cont++;
    }

    @Override
    public String toString() {
        return "aereo "+(id>5?"internazionale":"nazionale")+" "+id;
    }
    
    

    @Override
    public void run(){
        try{
            if(id<=5){
                t.atterraNaz(this);
                Thread.sleep((long)((Math.random()*10000)+10000));
                //Thread.sleep(100);
                t.liberaNaz(this);
            }else{
                t.atterraInt(this);
                Thread.sleep((long)((Math.random()*10000)+10000));
                //Thread.sleep(100);
                t.liberaInt(this);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
}
