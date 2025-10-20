/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_morlini;

import java.util.*;

/**
 *
 * @author verifica
 */
public class Array_morlini {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        final int n = (int) (Math.random() * 18) + 12;
        for (int i = 0; i < n; i++) {
            a.add((int) (Math.random() * 99) + 1);
        }

        int na = (int) (Math.random() * 4) + 3;
        myThread[] threads = new myThread[na];

        int d = n / na;
        int j = d;
        while (j < n) {
            for (int i = 0; i < na; i++) {
                threads[i] =new myThread(a, j, d);
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    System.out.println("Errore" + e.getMessage());
                }
            }
            j = j + d;
        }
    }

}
