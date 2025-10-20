package array_palladino;

public class Array_Palladino {

    public static void main(String[] args) {
        int n = (int) (Math.random() * 9 + 12);
        System.out.println(n);

        int[] v = new int[n];

        for (int i = 0; i < n; i++) {
            v[i] = (int)( Math.random() * 100 + 1);
        }
        int k = (int) (Math.random() * 2 + 3);
        
        for(int i=0; i<k; i++){
            new Porzione(v,k,i+1).start();
        }
        
    }

}
