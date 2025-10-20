
package porto_sciannamea;


public class CapitaneriaDiPorto extends Thread{

    private int id;
    private boolean nave=true;
    private int out[];
    
    public synchronized void Richiesta() throws InterruptedException{
          

            if(id<5){
                nave=true;
                System.out.println("Una nave nazionale richiede un accesso id= "+id);
                wait();

            }else{
                System.out.println("Una nave Internazionale richiede un accesso id= "+id);
                nave=false;
                wait();
            }
    }
    
    public synchronized void attracca(){
        
        if(nave==false){
                System.out.println("Una nave internazionale è attraccata ");
                
            }else{
                System.out.println("Una nave nazionale è attraccata");
                
            }
        
    }
    public synchronized void Banchina() throws InterruptedException{
        int b = 0;
        while(b<3){
            if(nave=false){
            
            
                    System.out.println("Nave internazionale id="+id+ " è in banchina");
                    wait();
                    b++;                
            
            
            }else{
            wait();               
            
            }
        }
        if(b==0){
            
        }
        
    }
    
     
}
