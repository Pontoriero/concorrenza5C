/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porto_morlini;

/**
 *
 * @author verifica
 */
public class Banchina {

    private final int max = 3;
    private int occupate = 0;
    private int listaNaz = 0;
    private int listaInt = 0;
    private int attesaInt = 0;

    public void entraNave(boolean tipo) throws InterruptedException {
        while (true) {
            if (occupate == 0) {
                occupate++;
                if (tipo) {
                    listaInt++;
                    System.out.println("Internazionale entrata");
                    break;
                } else {
                    listaNaz++;
                    System.out.println("Nazionale entrata");
                    break;
                }
            } else {
                if (occupate == max) {
                    if(tipo){
                        attesaInt++;
                    }
                    wait();
                } else {
                    if (tipo) {
                        if (listaNaz==0) {
                            listaInt++;
                            System.out.println("Internazionale entrata");
                            occupate++;
                            if(attesaInt!=0){
                                attesaInt--;
                            }
                            break;
                        }else{
                            attesaInt++;
                            wait();
                        }
                    } else {
                        if (attesaInt != 0) {
                            wait();
                        } else {
                            if (listaInt == 0) {
                                listaNaz++;
                                System.out.println("Nazionale entrata");
                                occupate++;
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
    }

    public void esceNave(boolean tipo) {
        if(tipo){
            listaInt--;
            System.out.println("Internazionale uscita");
        }else{
            listaNaz--;
            System.out.println("Nazionale uscita");
        }
        occupate--;
        notifyAll();
    }
}
