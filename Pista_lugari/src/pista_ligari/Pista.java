package pista_ligari;

import java.util.ArrayList;

/**
 *
 * @author verifica
 */
public class Pista {

    private final int max = 3;

    private int contaPiste;
    private ArrayList<String> s;
    private int nazionale;
    private int codanaz;
    private int internaz;
    private int codainter;

    public Pista() {
        this.s = new ArrayList<String>();
    }

    public void accessoNaz() {
        System.out.println("accesso richiesto nazionale");
        if (contaPiste == max) {
            codanaz++;
        }
    }

    public void accessoInter() {
        System.out.println("accesso richiesto internazionale");
        if (contaPiste == max) {
            codainter++;
        }
    }

    public synchronized void entraNaz() throws InterruptedException {
        while (contaPiste == max || codainter != 0 || internaz != 0) {
            wait();
        }
        codanaz--;
        nazionale++;
        contaPiste++;
        System.out.println("Entra un nazionale");
        s.add("n");
        notifyAll();
    }

    public synchronized void esceNaz() throws InterruptedException {
        while (contaPiste == 0 || !(s.contains("n"))) {
            wait();
        }
        System.out.println("esce un nazionale");
        nazionale--;
        s.remove("n");
        notifyAll();
    }

    public synchronized void entraInter() throws InterruptedException {
        while (contaPiste == max || nazionale != 0) {
            wait();
        }
        System.out.println("Entra un internazionale");
        codainter--;
        internaz++;
        contaPiste++;
        s.add("i");
        notifyAll();
    }

    public synchronized void esceInter() throws InterruptedException {
        
        while (contaPiste == 0 || !(s.contains("i"))) {
            wait();
        }
        System.out.println("Esce un internazionale ");
        internaz--;
        s.remove("i");
        notifyAll();
    }

}
