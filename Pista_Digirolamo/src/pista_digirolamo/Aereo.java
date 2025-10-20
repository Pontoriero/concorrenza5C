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
public class Aereo implements Runnable{
    private TorreControllo p;
    private int id;

    public Aereo(TorreControllo p, int id) {
        this.p = p;
        this.id = id;
    }

    public void setP(TorreControllo p) {
        this.p = p;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TorreControllo getP() {
        return p;
    }

    public int getID() {
        return id;
    }
    
    @Override
    public void run(){
        if(id>=1 && id<=5){
            try{
                p.entraAereoN();
                int n=(int) (Math.random()*20000)+10000;
                Thread.sleep(n);
                p.esceAereoN();
            }catch(InterruptedException e){
                System.out.println("Errore, "+e.getMessage());
            }
        }
        else if(id>=6 && id<=10){
            try{
                p.entraAereoInt();
                int n=(int) (Math.random()*20000)+10000;
                Thread.sleep(n);
                p.esceAereoInt();
            }catch(InterruptedException e){
                System.out.println("Errore, "+e.getMessage());
            }
        }
    }
}
