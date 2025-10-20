/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_digirolamo;

import java.util.ArrayList;

/**
 *
 * @author verifica25
 */
public class Pista_Digirolamo {
    public static void main(String[] args) {
        
        //creazione risorsa condivisa
        TorreControllo t=new TorreControllo();
        
        //creazione array per assegnazione ID
        int id[]={1,2,3,4,5,6,7,8,9,10};
        
        ArrayList<Thread> a= new ArrayList<Thread>();
        
        //creazione aerei
        for(int i=0;i<10;i++){
            int n=(int) (Math.random()*10);
            a.add(i, new Thread(new Aereo(t, id[n])));
        }
        
        //start aerei
        for(Thread aereo:a){
            aereo.start();
        }
        
        //join aerei
        for(Thread aereo:a){
            try{
                aereo.join();
            }catch(InterruptedException e){
                System.out.println("Errore, "+e.getMessage());
            }
        }
        
        System.out.println("Pista vuota");
    }
    
}
