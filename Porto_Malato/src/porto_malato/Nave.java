/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porto_malato;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author verifica
 */
public class Nave extends Thread {
    private int id;
    private CapitaneriaDiPorto cdp;
    
    public Nave(int id) {
        this.id = id;
    }

    public void setId(int id) {
        if(id < 1 || id > 10) {
            throw new IllegalArgumentException("L'ID deve essere compreso tra 1 e 10");
        }
        else {
            this.id = id;
        }
    }
    
    @Override
    public void run() {
        if(id < 6) {
            try {
                cdp.entraNazionali();
                sleep((int)Math.random() * 10000 + 10000);
                cdp.esciNazionali();
            } catch (InterruptedException ex) {
                Logger.getLogger(Nave.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            try {
                cdp.entraInternazionali();
                sleep((int)Math.random() * 10000 + 10000);
                cdp.esciInternazionali();
            } catch (InterruptedException ex) {
                Logger.getLogger(Nave.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
