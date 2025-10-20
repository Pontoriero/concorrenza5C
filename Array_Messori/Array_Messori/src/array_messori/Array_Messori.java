/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_messori;

import java.util.ArrayList;

/**
 *
 * @author verifica
 */
public class Array_Messori {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int N = (int) ((Math.random()*6) + 12);
        int a[] = new int[N];
        ArrayList<MyThread> t = new ArrayList();
        
        for (int i = 0; i < N; i++) {
            a[i] = (int) ((Math.random()* 98) + 1);
        }
        
        int k = (int) ((Math.random()* 2) + 3);
        System.out.println("lunghezza array: " + N);
        System.out.println("numero thread: " + k);
        int n1;
        for (int i = 0; i < k; i++) {
            n1 =(N / k) * i;
            t.add(new MyThread(a, n1, (N / k) + n1, k));
            t.get(i).start();
        }
        
        for (int i = 0; i < k; i++) {
            System.out.println("Thread numero " + (i+1));
            t.get(i).visualizza();
        }
    }
    
}
