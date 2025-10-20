/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_dunga;

/**
 *
 * @author verifica
 */
public class MyThread extends Thread {

    private int v1[];
    private int inizio;
    private int fine;

    public MyThread(int[] v1, int inizio, int fine) {
        this.v1 = v1;
        this.inizio = inizio;
        this.fine = fine;
    }

    @Override
    public void run() {
        for (int i = inizio; i < fine; i++) {
            v1[i] = (int) Math.sqrt(v1[i]);
        }
    }

    @Override
    public String toString() {
        String result = "[ ";
        for (int i = inizio; i < fine; i++) {
            result += v1[i] + " ";
        }
        result += "]";
        return result;
    }

}
