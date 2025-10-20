/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_perini;

import java.util.ArrayList;

/**
 *
 * @author verifica
 */
public class Calcoli extends Thread{
    private ArrayList <Integer> a1;
    private ArrayList <Integer> a2;
    private ArrayList <Integer> risultati;
    private int inizio;
    private int fine;

    public Calcoli(ArrayList<Integer> a1, ArrayList<Integer> risultati, int inizio, int fine) {
        setA1(a1);
        setRisultati(risultati);
        setInizio(inizio);
        setFine(fine);
    }

    public ArrayList<Integer> getA1() {
        return a1;
    }

    public void setA1(ArrayList<Integer> a1) {
        this.a1 = a1;
    }


    public ArrayList<Integer> getRisultati() {
        return risultati;
    }

    public void setRisultati(ArrayList<Integer> risultati) {
        this.risultati = risultati;
    }

    public int getInizio() {
        return inizio;
    }

    public void setInizio(int inizio) {
        this.inizio = inizio;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }
    
    @Override
    public void run(){
        try{
            for(int i=inizio; i<fine; i++){
                int app;
                app = (((a1.get(i)/10) + (a1.get(i)-(a1.get(i)/10))) * i);
                risultati.add(app);
                Thread.sleep(2000);
            }
        }catch(InterruptedException e){
            System.out.println("Errore: " + e.getMessage());
        }
    }
    
    
}
