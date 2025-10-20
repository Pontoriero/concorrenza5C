/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_burani;

import java.util.Random;

/**
 *
 * @author verifica
 */
public class Aereo implements Runnable{
    private final String nome;
    private final TipoAereo tipo;
    private final TorreControllo torre;
    private final Random rnd = new Random ();

    public Aereo(String nome, TipoAereo tipo, TorreControllo torre) {
        this.nome = nome;
        this.tipo = tipo;
        this.torre = torre;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void run(){
        try{
            System.out.println(Thread.currentThread().getName() + tipo + "richiede accesso");
            if(tipo == TipoAereo.INTERNAZIONALE){
                torre.entraInternazionale();
            }else{
                torre.entraNazionale();
            }
            
            int tempo = 10 + rnd.nextInt(11);
            System.out.println(Thread.currentThread().getName() + tipo + "lascia la pista per s" + tempo);
            
            Thread.sleep(tempo + 1000);
            
            if(tipo == TipoAereo.INTERNAZIONALE){
                torre.esciInternazionale();
            }else{
                torre.esciNazionale();
            }
        }catch(InterruptedException e){
            System.out.println("Errore");
        }
    }
}
