/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_messori;

/**
 *
 * @author verifica
 */
public class MyThread extends Thread{
    private int[] a;
    private int[] a1;
    private int n1;
    private int n;
    private int k;

    public MyThread(int[] a, int n1, int n, int k) {
        this.a = a;
        this.n1 = n1;
        this.n = n;
        this.k = k;
        a1 = new int[n];
    }
    
   public void visualizza(){
       for (int i = 0; i < n-n1; i++) {
            System.out.println(a1[i]);
       }
   }
    
    @Override
    public void run(){
        for (int i = n1; i < n; i++) {
            a1[i - n1] = i * ((a[i]/10) + (a[i] % 10));
        }
    }
}
