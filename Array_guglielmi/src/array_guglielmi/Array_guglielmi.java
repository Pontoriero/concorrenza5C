/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_guglielmi;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author verifica
 */
public class Array_guglielmi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        int N=(int)(Math.random()*20+10);
        int a[]=new int[N];
        
        for (int i = 0; i < N; i++) {
            a[i]=(int)(Math.random()*100);
        }
        
        int K=(int)(Math.random()*5+3);
        int inizio=0;
        int fine=(int)(N/K);
        /*
        boolean x=false;
        if((fine*K)<N){
            x=true;
        }
        
        /*
        if((N/K)%2==0){
            fine=N/K;
        }else{
            fine=
        }*/
        for (int i = 0; i < K; i++) {
            /*
            if(x==true && i==K-1){
                fine+=fine-1;
            }else{
                fine+=fine;
            }*/
            fine+=fine;
            inizio+=fine;
            
            new Radice(a,inizio,fine,N).start();
        }
        for (int i = 0; i < N; i++) {
            System.out.println(a[i]);
        }
        String r=new Radice(a,0,0,N).toString();
        System.out.println(r);
    }
    
}
