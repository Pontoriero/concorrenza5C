/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porto_migale;

/**
 *
 * @author verifica
 */
public class Navi  extends Thread{

    private CapitaneriaDiPorto c;
    private int  numId;

    public Navi(CapitaneriaDiPorto c, int numId) {
        this.c = c;
        this.numId = numId;
    }

    

    public CapitaneriaDiPorto getC() {
        return c;
    }

    public void setC(CapitaneriaDiPorto c) {
        this.c = c;
    }

    public int getNumId() {
        return numId;
    }

    public void setNumId(int numId) {
        this.numId = numId;
    }

    

    @Override
    public void run() {
        int x = (int) (Math.random() * 10 + 10);
        try {
            if (numId>6) {
                c.entraInternazionali();
                Thread.sleep(x);
                c.esceInternazionali();
                Thread.sleep(1000);
            } else {
                c.entraNazionali();
                Thread.sleep(x);
                c.esceNazionali();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {

            System.out.println("errore " + e.getMessage());
        }
    }
}
