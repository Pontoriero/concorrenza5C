/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porto_perini;

/**
 *
 * @author verifica
 */
public class Porto_Perini {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int DIM_BARCHE = 10;
       
       //creo banchine
       CapitaneriaDiPorto b1 = new CapitaneriaDiPorto();
       CapitaneriaDiPorto b2 = new CapitaneriaDiPorto();
       CapitaneriaDiPorto b3 = new CapitaneriaDiPorto();
       
   
       
       for(int i=0; i<DIM_BARCHE/3; i++){
           new Thread(new Nave(b1,i)).start();
       }
       
       for(int i=0; i<DIM_BARCHE/3; i++){
           new Thread(new Nave(b2,i)).start();
       }
       
       for(int i=0; i<DIM_BARCHE/3; i++){
           new Thread(new Nave(b3,i)).start();
       }
       
      
    }
    
}
