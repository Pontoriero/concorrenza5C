/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_bertolotti;

import java.util.ArrayList;

/**
 *
 * @author verifica25
 */
public class Pista {
    final int N = 3;
    private ArrayList<Integer> a;
    
    public Pista(){
        a = new ArrayList<Integer>();
    }
    
    public void faiAtterrare(int id){
        System.out.println("Atterra l'aereo " + ((id >= 1 && id <= 5) ? "Nazionale " : "Internazionale ") + id);
        a.add(id);
    }
    
    public void faiPartire(int id){
        System.out.println("Parte l'aereo " + ((id >= 1 && id <= 5) ? "Nazionale " : "Internazionale ") + id);
        a.remove(id);
    }
}
