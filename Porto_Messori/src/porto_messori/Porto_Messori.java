/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porto_messori;

/**
 *
 * @author verifica
 */
public class Porto_Messori {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CapitaneriaDiPorto c = new CapitaneriaDiPorto();
        int id;
        
        for (int i = 0; i < 10; i++) {
            id = i + 1;
            new Nave(id, c).start();
        }
        
    }
    
}
