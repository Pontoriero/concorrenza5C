/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_ferrari;

import java.util.*;

/**
 *
 * @author verifica
 */
public class Array_Ferrari {

    public static void main(String[] args) {
        int N = (int) (Math.random() * 11) + 10; // Dimensione dell'array
        int nThread = (int) (Math.random() * 3) + 3; // Numero di Thread

        int v[] = new int[N];
        for (int i = 0; i < N; i++) { // Implemento l'array
            v[i] = (int) (Math.random() * 101);

        }

        visualizza(v, N);

        if (nThread == 3) {
            int c = N / 3;
            Radice r1 = new Radice(v, 0, c - 1);
            Radice r2 = new Radice(v, c, c * 2 - 1);
            Radice r3 = new Radice(v, c * 2, c * 3 - 1);

            r1.start();
            r2.start();
            r3.start();

            try {
                r1.join();
                r2.join();
                r3.join();
            } catch (InterruptedException e) {
                System.out.println("Errore: " + e);
            }
        } else if (nThread == 4) {
            int c = N / 4;
            Radice r1 = new Radice(v, 0, c - 1);
            Radice r2 = new Radice(v, c, c * 2 - 1);
            Radice r3 = new Radice(v, c * 2, c * 3 - 1);
            Radice r4 = new Radice(v, c * 3, c * 4 - 1);

            r1.start();
            r2.start();
            r3.start();
            r4.start();

            try {
                r1.join();
                r2.join();
                r3.join();
                r4.join();
            } catch (InterruptedException e) {
                System.out.println("Errore: " + e);
            }
        } else {
            int c = N / 5;
            Radice r1 = new Radice(v, 0, c - 1);
            Radice r2 = new Radice(v, c, c * 2 - 1);
            Radice r3 = new Radice(v, c * 2, c * 3 - 1);
            Radice r4 = new Radice(v, c * 3, c * 4 - 1);
            Radice r5 = new Radice(v, c * 4, c * 5 - 1);

            r1.start();
            r2.start();
            r3.start();
            r4.start();
            r5.start();

            try {
                r1.join();
                r2.join();
                r3.join();
                r4.join();
                r5.join();
            } catch (InterruptedException e) {
                System.out.println("Errore: " + e);
            }
        }

    }

    public static void visualizza(int v[], int N) { // Visualizzo l'array creato
        System.out.print("Array: ");

        for (int i = 0; i < N; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println("\n");
    }

}
