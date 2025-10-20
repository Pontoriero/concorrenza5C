/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_migale;

import java.util.ArrayList;

/**
 *
 * @author verifica
 */
public class Array_Migale {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int N = (int) (Math.random() * 12 + 18);
        int K = (int) Math.random() * 98 + 10;
        int risultato[]=new int[K];
        
        
        int[] v1 = new int[K];
        for (int i = 0; i < N; i++) {
            v1[i] = (int) (Math.random() *98)+1;
            System.out.println(v1[i]+" ,");
        }
        System.out.println(" ");
        
        ArrayList<MioThread> t = new ArrayList<MioThread>();
        int num=N/K;
        int resto=N%K;
        int base=0;
        
        for (int i = 0; i < K; i++) {
           if(resto==0)
           {
                t.add(new MioThread(v1, risultato,base,base+num));
           }else if(i==K-1)
                   {
                        t.add(new MioThread(v1, risultato,base,K));
                        base+=num;
                        
                   }else
           {
                t.add(new MioThread(v1, risultato,base,base+num));
                base+=num;
           }
           
        }
        
        for (int i = 0; i < N; i++) {
            System.out.println(t.get(i).toString());
        }
        
        for (int i = 0; i < N; i++) {
            t.get(i).start();
        }
        
         for (int i = 0; i < N; i++) {
             try {
                  t.get(i).join();
             } catch (InterruptedException e) {
                 System.out.println("errore "+e.getMessage());
             }
           
        }
    }

}
