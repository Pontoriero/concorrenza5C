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
public class Array_Malato {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyThread t1 = new MyThread();
        t1.creaArray();
        t1.stampaArray();
    }
    
}
