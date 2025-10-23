
package pista_bertolotti;

public class Pista_bertolotti {

    public static void main(String[] args) {
        Aereo[] a = new Aereo[10];
        Pista p = new Pista();
        TorreControllo t = new TorreControllo(p);
        Thread[] x = new Thread[10];
        
        for (int i = 0; i < 10; i++) {
            a[i] = new Aereo(i+1,t);
        }
        
        for (int i = 0; i < 10; i++) {
            x[i] = new Thread(a[i]);
            x[i].start();
        }
        
        try{
            for (int i = 0; i < 10; i++) {
                x[i].join();
            }
        }catch(InterruptedException e){
            System.out.println("Errore " + e.getMessage());
        }
    }
    
}
