/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_celani;

/**
 *
 * @author verifica
 */
public class MyThread extends Thread{
    private int []array;
    private int []risultato;
    private int inizio;
    private int fine;

    public MyThread(int[] array, int inizio, int fine,int []risultato) {
        this.array = array;
        this.inizio = inizio;
        this.fine = fine;
        this.risultato=risultato;
    }

    @Override
    public String toString() {
        String output="";
        for(int i=inizio;i<fine;i++){
            output+=risultato[i]+",  ";
        }
        return output;
    }
    
    
    
    @Override
    public void run(){
        for(int i=inizio;i<fine;i++){
            risultato[i]=((int)Math.sqrt(array[i]))+(array[inizio]-array[fine-1]);
        }
    }
}
