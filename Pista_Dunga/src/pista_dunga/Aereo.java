/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_dunga;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author verifica
 */
public class Aereo extends Thread {

    private TorreControllo p;
    private int id;
    private boolean flag;

    public Aereo(TorreControllo p, int id, boolean flag) {
        this.p = p;
        this.id = id;
        this.flag = flag;
    }

    public void setP(TorreControllo p) {
        this.p = p;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getID() {
        return id;
    }

    public TorreControllo getP() {
        return p;
    }

    public boolean isFlag() {
        return flag;
    }

    @Override
    public void run() {
        int x = (int) (Math.random() * 10000) + 10000;
        if(flag) {
            try {
                p.entraInternazionale(this);
                sleep(x);
                p.esceInternazionale(this);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        } else {
            try {
                p.entraNazionale(this);
                sleep(x);
                p.esceNazionale(this);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
}
