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
public class Array_Digirolamo {

    public static void main(String[] args) {
        //creazione in modo randomico lunghezza array e creazione array
        int n=(int) (Math.random()*20)+10;
        System.out.println("Numerosità vettori: "+n);
        
        int a[]= new int[n];
        int b[]=new int[n]; 
        
        for(int i=0;i<n;i++){
            a[i]=(int) (Math.random()*100);
        }
        
        //creazione numero casuale di Thread
        int k= (int) (Math.random()*4)+3;
        
        //creazioni dei thread
        int app= n/k;
        Thread t[]=new Thread[app];
        
        for(int i=0;i<app;i++){
            t[i]=new MioThread((i+i*app), a, b, (i+i*app)+app);
            t[i].start();
        }
        
        for(int i=0;i<app;i++){
            try{
                t[i].join();
            }catch(InterruptedException e){
                System.out.println("Errore, "+e.getMessage());
            }
        }
        
        for(int i=0;i<n;i++){
            System.out.println(b[i]);
        }
    }
    
}
