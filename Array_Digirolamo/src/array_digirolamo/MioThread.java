/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_digirolamo;

/**
 *
 * @author verifica25
 */
public class MioThread extends Thread{
    
    private int start;
    private int a[];
    private int b[];
    private int end;

    public MioThread(int start, int[] a, int[] b, int end) {
        this.start = start;
        this.a = a;
        this.b=b;
        this.end=end;
    }
    
    @Override
    public void run(){
        for(int i=start;i<end;i++){
            b[i]=((int) Math.sqrt(a[i]))+(a[end]-a[start]);
        }
    }
}
