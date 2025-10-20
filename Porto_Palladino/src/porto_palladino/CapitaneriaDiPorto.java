/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porto_palladino;

import java.util.ArrayList;

/**
 *
 * @author verifica
 */
public class CapitaneriaDiPorto {

    private ArrayList<Nave> buffer;
    private int NMAX = 3;

    public CapitaneriaDiPorto() {
        buffer = new ArrayList<Nave>();
    }

    public synchronized boolean entraNave(Nave n) throws InterruptedException {
        
        System.out.println( Thread.currentThread().getName() + " richiede l'accesso");
        
        while (buffer.size() == NMAX) {
            wait();
        }

        for (Nave a : buffer) {
            if (a.isInternazionale() && !(n.isInternazionale())) {
                wait();
            }
        }

        boolean attraccata = buffer.add(n);
        
        System.out.println(attraccata ? Thread.currentThread().getName() + " attraccata" : Thread.currentThread().getName() + " non attraccata ");
        
        notifyAll();
        return attraccata;
    }

    public synchronized boolean esceNave(Nave n) throws InterruptedException {
        while (buffer.isEmpty()) {
            wait();
        }

        boolean removed = buffer.remove(n);
        
        System.out.println(removed ? Thread.currentThread().getName() + " uscita" : Thread.currentThread().getName() + " non uscita");
        
        notifyAll();
        return removed;
    }

}
