/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_battista;

import java.util.ArrayList;

/**
 *
 * @author verifica
 */
public class Array_battista {

    public static void main(String[] args) {
        int k = (int) (Math.random() * 4) + 1;  //  num di thread
        int n = (int) (Math.random() * 10) + 10;    // lunghezza array
        int risultato[] = new int[n];

        System.out.println("Numero di thread: " + k);
        System.out.println("Lunghezza array: " + n);

        // creazione array
        int[] v1 = new int[n];
        for (int i = 0; i < n; i++) {
            v1[i] = (int) (Math.random() * 100);
            System.out.print(v1[i] + ", ");
        }

        System.out.println("");

        // array di thread
        ArrayList<MioThread> t = new ArrayList<MioThread>();
        int num = (int) n / k;
        int resto = n % k;
        int base = 0;
        for (int i = 0; i < k; i++) {
            if (resto == 0) {   // se la lunghezza è pari
                t.add(new MioThread(v1, risultato, base, base + num));
            } else if (i == k - 1) {    // se è dispari e siamo al penultimo
                t.add(new MioThread(v1, risultato, base, k));
            } else {    // se è dispari
                t.add(new MioThread(v1, risultato, base, base + num));
            }
            
            base += num;
        }

        // avvio thread
        for (int i = 0; i < k; i++) {
            t.get(i).start();
        }

        // visualizzazione risultato
        for (int i = 0; i < k; i++) {
            System.out.println(t.get(i).toString());
        }

        // join
        for (int i = 0; i < k; i++) {
            try {
                t.get(i).join();
            } catch (InterruptedException e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }

        System.out.println("FINE");
    }

}
