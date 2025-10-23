
package pista_bertolotti;

public class TorreControllo {
    private Pista p;
    private int inter = 0;
    private int naz = 0;
    private int dentro = 0;
    
    public TorreControllo(Pista p){
        this.p = p;
    }
    
    public synchronized void Atterraggio(int id) throws InterruptedException{
        while(id >= 1 && id <= 5 && inter > 0){
            wait();
            naz++;
        }
        
        while(id >= 6 && id <= 10){
            wait();
            inter++;
        }
        
        while(dentro == 3){
            wait();
            if(id >= 1 && id <= 5){
                naz++;
            }
            else{
                inter++;
            }
        }
        
        if(id >= 1 && id <= 5 && inter==0){
            naz--;
        }
        else{
            inter--;
        }
        
        p.faiAtterrare(id);
        dentro++;
        
        Thread.sleep((long)((Math.random()*11 + 10)*1000));
        dentro--;
        Partenza(id);
        
        
    }
    
    public synchronized void Partenza(int id) throws InterruptedException{
        p.faiPartire(id);
    }
}
