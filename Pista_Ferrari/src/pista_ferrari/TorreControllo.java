/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_ferrari;

/**
 *
 * @author verifica
 */
public class TorreControllo {

    private final int MAX = 3;
    private int nazio = 0;
    private int inter = 0;
    private int attesaNazio = 0;
    private int attesaInter = 0;

    public synchronized void entraNazio(int n) throws InterruptedException {
        System.out.println("Aereo nazionale " + n + " in coda");
        attesaNazio++;
        while (nazio == MAX || inter > 0) {
            wait();
        }

        nazio++;
        attesaNazio--;
        System.out.println("Aereo nazionale " + n + " entra");
        notifyAll();
    }

    public synchronized void entraInter(int n) throws InterruptedException {
        System.out.println("Aereo internazionale " + n + " in coda");
        attesaInter++;
        while (inter == MAX || nazio > 0 || attesaInter > 0) {
            wait();
        }

        inter++;
        attesaInter--;
        System.out.println("Aereo internazionale " + n + " entra");
        notifyAll();
    }

    public synchronized void esceNazio(int n) throws InterruptedException {
        while (nazio == 0) {
            wait();
        }

        nazio--;
        System.out.println("Aereo nazionale " + n + " esce");
        System.out.println("Posti occupati: " + (MAX - nazio));
        notifyAll();
    }

    public synchronized void esceInter(int n) throws InterruptedException {
        while (inter == 0) {
            wait();
        }

        inter--;
        System.out.println("Aereo internazionale " + n + " esce");
        System.out.println("Posti occupati: " + (MAX - inter));
        notifyAll();
    }

}
