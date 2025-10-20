/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_bagni;

/**
 *
 * @author verifica25
 */
public class TorreControllo {

    private int Max = 3;
    private int nInter;
    private int nNaz;
    private int attesaNaz;
    private int attesaInter;

    public synchronized void atterraNaz() throws InterruptedException {
        attesaNaz++;
        System.out.println("richiesta atterraggio nazionale ");
        while (nInter != 0 || nNaz > 1 || attesaInter > 0) {
            wait();
        }
        nNaz++;
        attesaNaz--;
        System.out.println("atterraggio aereo nazionale ");
        System.out.println("occupati ");

        notifyAll();
    }

    public synchronized void atterraInter() throws InterruptedException {
        attesaInter++;
        System.out.println("richiesta atterraggio internazionale ");

        while (nInter > 1 || nNaz != 0) {
            wait();
        }
        nInter++;
        attesaInter--;
        System.out.println("atterraggio aereo internazionale ");
        notifyAll();
    }

    public synchronized void decollaNaz() throws InterruptedException {
        while (nNaz == 0) {
            wait();
        }
        nNaz--;
        System.out.println("decolla aereo nazionale ");
        notifyAll();
    }

    public synchronized void decollaInter() throws InterruptedException {
        while (nInter == 0) {
            wait();
        }
        nInter--;
        System.out.println("decolla aereo internazionale ");
        notifyAll();
    }

}
