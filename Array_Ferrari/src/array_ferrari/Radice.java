/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_ferrari;

/**
 *
 * @author verifica
 */
public class Radice extends Thread {

    private int[] v;
    private int posIniziale;
    private int posFinale;

    public Radice(int[] v, int posIniziale, int posFinale) {
        this.v = v;
        this.posIniziale = posIniziale;
        this.posFinale = posFinale;
    }

    @Override
    public void run() {
        for (int i = posIniziale; i < posFinale; i++) {
            v[i] = (int) Math.sqrt(i) + (posFinale - posIniziale);
            System.out.println(v[i]);
        }
    }

}
