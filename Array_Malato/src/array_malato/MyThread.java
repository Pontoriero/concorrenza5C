/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_malato;

/**
 *
 * @author verifica
 */
public class MyThread extends Thread {
    private int N;
    private int K;
    private int []v;

    public MyThread() {
        setN(N);
        setK(K);
        setV(v);
    }

    public int getN() {
        return N;
    }

    public void setN(int N) {
        this.N = (int)(Math.random() * 6 + 12);
    }

    public int getK() {
        return K;
    }

    public void setK(int K) {
        this.K = (int)(Math.random() * 1 + 3);
    }

    public int[] getV() {
        return v;
    }

    public void setV(int[] v) {
        this.v = v;
    }
    
    
    
    public void creaArray() {
        for(int i = 0; i < N; i++) {
            v[i] = 5;
        }
    }
    
    public void stampaArray() {
        for(int i = 0; i < N; i++) {
            System.out.println(v[i]);
        }
    }
    
    @Override
    public void run() {
        
    }
}
