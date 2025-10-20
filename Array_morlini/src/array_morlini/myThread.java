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
public class myThread extends Thread{
    private ArrayList a;
    private int n;
    private int d;

    public myThread(ArrayList a, int n, int d) {
        this.a = a;
        this.n = n;
    }
    
    @Override
    public void run(){
        for (int i = n - d; i < n; i++) {
            int f = (int)(a.get(i))*i;
            System.out.println(Thread.currentThread().getId() + " : " + a.get(i));
        }
    }
}
