/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_dunga;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author verifica
 */
public class Array_Dunga {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int n = (int) (Math.random() * 10 + 10);
        System.out.println("Lunghezza Array: " + n);

        int v1[] = new int[n];

        for (int i = 0; i < n; i++) {
            v1[i] = (int) (Math.random() * 100);
        }

        System.out.println(Arrays.toString(v1));

        int k = (int) (Math.random() * 2 + 3);
        System.out.println("Numeri Thread: " + k);

        int intervallo = n / k;
        int inizio = 0;

        if (k == 3) {
            MyThread t1 = new MyThread(v1,inizio,inizio+intervallo);
            inizio = intervallo;
            MyThread t2 = new MyThread(v1,inizio,inizio+intervallo);
            inizio += intervallo;
            MyThread t3 = new MyThread(v1,inizio,v1.length);
            
            t1.start();
            t2.start();
            t3.start();
            
            try {
                t1.join();
                t2.join();
                t3.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            
            System.out.println(t1);
            System.out.println(t2);
            System.out.println(t3);
            
        } else {
            if (k == 4) {
                MyThread t1 = new MyThread(v1,inizio,inizio+intervallo);
                inizio += intervallo;
                MyThread t2 = new MyThread(v1,inizio,inizio+intervallo);
                inizio += intervallo;
                MyThread t3 = new MyThread(v1,inizio,inizio+intervallo);
                inizio += intervallo;
                MyThread t4 = new MyThread(v1,inizio,v1.length);
                
                t1.start();
                t2.start();
                t3.start();
                t4.start();
                
                try {
                    t1.join();
                    t2.join();
                    t3.join();
                    t4.join();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                
                System.out.println(t1);
                System.out.println(t2);
                System.out.println(t3);
                System.out.println(t4);
                
            } else {
                MyThread t1 = new MyThread(v1,inizio,inizio+intervallo);
                inizio += intervallo;
                MyThread t2 = new MyThread(v1,inizio,inizio+intervallo);
                inizio += intervallo;
                MyThread t3 = new MyThread(v1,inizio,inizio+intervallo);
                inizio += intervallo;
                MyThread t4 = new MyThread(v1,inizio,inizio+intervallo);
                inizio += intervallo;
                MyThread t5 = new MyThread(v1,inizio,v1.length);
                
                t1.start();
                t2.start();
                t3.start();
                t4.start();
                t5.start();
                
                try {
                    t1.join();
                    t2.join();
                    t3.join();
                    t4.join();
                    t5.join();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                
                System.out.println(t1);
                System.out.println(t2);
                System.out.println(t3);
                System.out.println(t4);
                System.out.println(t5);
                
            }
        }

    }

}
