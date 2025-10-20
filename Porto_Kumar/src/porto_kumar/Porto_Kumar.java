/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porto_kumar;

/**
 *
 * @author verifica
 */
public class Porto_Kumar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CapitaneriaDiPorto c=new CapitaneriaDiPorto();
        for (int i = 0; i < 5; i++) {
            
                 new Nave("internazionale",c).start();
            
                new Nave("nazionale",c).start();
            
        }
        
        
    }
    
}
