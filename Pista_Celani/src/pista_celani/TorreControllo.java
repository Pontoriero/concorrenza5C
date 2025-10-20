/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pista_celani;

import java.util.ArrayList;

/**
 *
 * @author verifica
 */
public class TorreControllo {
    ArrayList<Aereo> piste;
    private static final int N=3;
    private int intAttesa=0;
    private int intAtterrati=0;
    private int nazAtterrati=0;
    private String statoPista;

    public TorreControllo() {
        this.piste=new ArrayList<Aereo>();
    }
    
    public synchronized void atterraInt(Aereo a)throws InterruptedException{
        intAttesa++;
        System.out.println(a+" ha richiesto l atterraggio");
        while(piste.size()==N || ("N".equals(statoPista)&& nazAtterrati>0)){
            wait();
        }
        intAttesa--;
        statoPista="I";
        piste.add(a);
        System.out.println(a+" e atterrato");
        intAtterrati++;
        notifyAll();
    }
    
    public synchronized void liberaInt(Aereo a)throws InterruptedException{
        while(piste.isEmpty()){
            statoPista=null;
            wait();
        }
        piste.remove(a);
        System.out.println(a+" ha liberato la pista");
        intAtterrati--;
        notifyAll();
    }
    
    public synchronized void atterraNaz(Aereo a)throws InterruptedException{
        System.out.println(a+" ha richiesto l atterraggio");
        while(piste.size()==N || ("I".equals(statoPista)&& intAtterrati>0) || intAttesa>0){
            wait();
        }
        statoPista="N";
        piste.add(a);
        System.out.println(a+" e atterrato");
        nazAtterrati++;
        notifyAll();
    }
    
    public synchronized void liberaNaz(Aereo a)throws InterruptedException{
        while(piste.isEmpty()){
            statoPista=null;
            wait();
        }
        piste.remove(a);
        nazAtterrati--;
        System.out.println(a+" ha liberato la pista");
        notifyAll();
    }
}
