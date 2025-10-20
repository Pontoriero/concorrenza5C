/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_bagni;

/**
 *
 * @author verifica25
 */
public class Numeri extends Thread{
    private int v[];
    private int s;

    public Numeri(int[] v, int s) {
        this.v = v;
        this.s = s;
    }

    public int[] getV() {
        return v;
    }

    public void setV(int[] v) {
        this.v = v;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    
    @Override
    public void run() {
        try{
            for(int i=0;i<v.length;i++){
                int rad= (int) Math.sqrt(v[i])+v[s-1]-v[0];
                System.out.println("risultato: "+rad);
            }
        }catch(IllegalArgumentException e){
            System.out.println("errore "+e.getMessage());
        }
    }
    
    
}
