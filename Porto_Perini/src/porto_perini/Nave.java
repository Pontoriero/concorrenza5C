/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porto_perini;

/**
 *
 * @author verifica
 */
public class Nave implements Runnable{
    private CapitaneriaDiPorto b;
    private int ID;

    public Nave(CapitaneriaDiPorto b, int ID) {
        setB(b);
        setID(ID);
    }

    public CapitaneriaDiPorto getB() {
        return b;
    }

    public void setB(CapitaneriaDiPorto b) {
        this.b = b;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    
    
    @Override
    public void run(){
        try{
            int tRand = (int) (Math.random()*20000)+10000;
            if(ID < 6 || ID > 10){ //nazionali
                b.entraInternazionale();
                Thread.sleep(tRand);
                b.esciInternazionale();
                Thread.sleep(tRand);
            }else{ //internazionali
                b.entraNazionale();
                Thread.sleep(tRand);
                b.esciNazionale();
                Thread.sleep(tRand);
            }
        }catch(InterruptedException e){
            System.out.println("Errore: " + e.getMessage());
        }
    }
    
    
    
    
}
