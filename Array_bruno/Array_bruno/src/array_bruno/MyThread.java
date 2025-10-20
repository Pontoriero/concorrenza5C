/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_bruno;

/**
 *
 * @author verifica
 */
public class MyThread extends Thread{
    private int start;
    private int end;
    private int[] v;
    private int[] ris;

    public MyThread(int start, int end, int[] v, int[] ris) {
        setStart(start);
        setEnd(end);
        setV(v);
        setRis(ris);
    }

    public void setRis(int[] ris) {
        this.ris = ris;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setV(int[] v) {
        this.v = v;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int[] getV() {
        return v;
    }

    public int[] getRis() {
        return ris;
    }
    
    @Override
    public void run() {
        try {
            for (int i=start;i<end;i++) {
                ris[i] =(int)Math.sqrt(i)+(end-start);
            }
            Thread.sleep(1000);
        }catch (InterruptedException e) {
            System.out.println("errore"+ e.getMessage());
        }
    }
    
}
