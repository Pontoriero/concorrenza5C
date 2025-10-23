
package array_bertolotti;

public class Array_bertolotti {

    public static void main(String[] args) {
        int n =(int) (Math.random() * 10 + 11);
        int[] v = new int[n];
        int k =(int) (Math.random() * 3 + 3);
        Conto[] vk = new Conto[k];
        
        System.out.println(n);
        System.out.println(k);
        
        for (int i = 0; i < n; i++) {
            v[i] = (int)( Math.random()*100 + 1);
        }
        
        for (int i = 0; i < k; i++) {
            vk[i] = new Conto(n,k,i,v);
            vk[i].start();
        }
        
        try{
            for (int i = 0; i < k; i++) {
                vk[i].join();
            }
            
            for (int i = 0; i < k; i++) {
                System.out.println(vk[i].getV3());
                System.out.println(vk[i].getV2());
            }
                
        }catch(InterruptedException e){
            System.out.println("Errore: " + e.getMessage());
        }
    }
    
}
