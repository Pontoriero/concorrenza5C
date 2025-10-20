/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_truffelli;

/**
 *
 * @author verifica
 */
public class Somma extends Thread{
    private int[] vet;
    private int inizio;
    private int fine;

    public Somma(int[] vet, int inizio, int fine) {
        this.vet = vet;
        this.inizio = inizio;
        this.fine = fine;
    }
    
    @Override
    public void run(){
        for(int i=inizio;i<fine;i++){
            //System.out.println(vet[i]+" i="+i+" = "+(vet[i]/10 + vet[i]%10) * i);
            vet[i] = (vet[i]/10 + vet[i]%10) * i;
        }
    }
}
