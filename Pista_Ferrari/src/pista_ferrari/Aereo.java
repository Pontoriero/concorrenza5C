/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_ferrari;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author verifica
 */
public class Aereo extends Thread {

    private TorreControllo pista;
    private int tipo;

    public Aereo(TorreControllo pista, int tipo) {
        setPista(pista);
        setTipo(tipo);
    }

    public TorreControllo getPista() {
        return pista;
    }

    public void setPista(TorreControllo pista) {
        this.pista = pista;
    }

    public int isTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public void run() {
        int x = (int) (Math.random() * 11000) + 10000;
        if (isTipo() >= 1 && isTipo() <= 5) {
            try {
                pista.entraNazio(tipo);
                Thread.sleep(x);
                pista.esceNazio(tipo);
            } catch (InterruptedException e) {
                System.out.println("Errore: " + e);
            }

        } else {
            try {
                pista.entraInter(tipo);
                Thread.sleep(x);
                pista.esceInter(tipo);
            } catch (InterruptedException e) {
                System.out.println("Errore: " + e);
            }
        }
    }

}
