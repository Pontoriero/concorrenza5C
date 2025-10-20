/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porto_kumar;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author verifica
 */
public class Nave extends Thread{
    private String tipo;
    private CapitaneriaDiPorto c;
    private int id;

    public Nave(String tipo, CapitaneriaDiPorto c) {
        setTipo(tipo);
        setC(c);
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public CapitaneriaDiPorto getC() {
        return c;
    }

    public void setC(CapitaneriaDiPorto c) {
        this.c = c;
    }
    
    @Override
    public void run(){
        if(tipo.equals("internazionale"))
        {
            try {
                
                c.entraInterazionale();
                Thread.sleep((int)(Math.random()*20000)+10000);
                c.esceInternazionale();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            
        }else{
            try {
                c.entraNazionale();
                Thread.sleep((int)(Math.random()*2000)+10000);
                c.esceNazionale();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
