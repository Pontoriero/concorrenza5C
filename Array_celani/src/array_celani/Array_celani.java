/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_celani;

import java.util.ArrayList;

/**
 *
 * @author verifica
 */
public class Array_celani {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int N = (int) (Math.random() * 10) + 10;
        System.out.println("N: "+N);
        
        int array[] = new int[N];
        int risultato[] = new int[N];

        System.out.print("Array generato : ");
        for (int i = 0; i < N; i++) {
            array[i] = (int) (Math.random() * 101);
            System.out.print(array[i] + " ");
        }

        int K = (int) (Math.random() * 3) + 3;
        
        System.out.println("\nK: "+K);
        int p = N / K;//divisione dell array in parti uguali

        ArrayList<MyThread> lista = new ArrayList<>();
        for (int j = 0; j < K; j++) {
            lista.add(new MyThread(array, p * j, p * (j + 1),risultato));
        }
        
        if((N % K)!=0){//se l N non e multiplo di K sommo il resto a p
            lista.add(new MyThread(array, p * K, ((p *K) + (N % K)),risultato));
        }
        

        for (MyThread t : lista) {
            t.start();
        }

        try {
            for (MyThread t : lista) {
                t.join();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.print("Risultato : ");
        for(MyThread t:lista){
            System.out.print(t);
        }
    }

}
