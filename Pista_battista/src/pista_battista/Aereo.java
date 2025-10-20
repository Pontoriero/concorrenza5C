/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_battista;

/**
 *
 * @author verifica
 */
public class Aereo implements Runnable {
    private String nome;
    private int id;
    private TorreControllo torre;

    public Aereo(String nome, int id, TorreControllo torre) {
        this.nome = nome;
        this.id = id;
        this.torre = torre;
    }

    @Override
    public void run() {
        int x = (int) (Math.random()*10000) + 10000;    // tempo in pista
        try {
            if (id >= 1 && id <= 5) {   // nazionale
                torre.entraNaz(nome);
                System.out.println(nome + " è in pista. (nazionale)");
                Thread.sleep(x);
                torre.uscitaNaz(nome);
            } else {    // inter
                torre.entraInter(nome);
                System.out.println(nome + " è in pista. (inter)");
                Thread.sleep(x);
                torre.uscitaInter(nome);
            }
        } catch (InterruptedException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
