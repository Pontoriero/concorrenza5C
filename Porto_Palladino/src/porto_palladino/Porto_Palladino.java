/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porto_palladino;

import java.util.ArrayList;

/**
 *
 * @author verifica
 */
public class Porto_Palladino {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CapitaneriaDiPorto p = new CapitaneriaDiPorto();
        int nNavi = 10;
//        ArrayList<Integer> idUsati = new ArrayList<>();

//        for (int i = 0; i < nNavi; i++) {
//            int id = (int) (Math.random() * 10 + 1);
//            if (!(idUsati.contains(id))) {
//                new Nave(id, p).start();
//                idUsati.add(id);
//                System.out.println("Nave creata con id: " + id);
//            }
//        }
        for (int i = 0; i < nNavi; i++) {
            new Thread(new Nave(((int)Math.random() * 10 + 1), p)).start();
        }

    }

}
