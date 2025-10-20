/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_palladino;

/**
 *
 * @author verifica
 */
public class Porzione extends Thread {

    private int[] v;
    private int k;
    private int nThread;

    public Porzione(int[] v, int k, int nThread) {
        this.v = v;
        this.k = k;
        this.nThread = nThread;
    }

    @Override
    public void run() {
        int dim = v.length / k;
        System.out.print(dim + " ");
        System.out.println(nThread);

        for (int i = (dim * (nThread - 1)); i < (dim*(nThread)); i++) {
            System.out.println("Stampa");
        }
    }
}
