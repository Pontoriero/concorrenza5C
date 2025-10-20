/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array_kumar;

/**
 *
 * @author verifica
 */
public class Array_Kumar {

    
    public static void main(String[] args) {
        int n=(int)(Math.random()*7+12);
        
        int []v=new int[n];
        for(int i=0;i<n;i++){
            v[i]=(int)(Math.random()*99+1);
            
        }
        
        int k=(int)(Math.random()*4)+3;
        int dividi=0;
        if(k%2==0){
            dividi=n/k;
        }else{
            
        }
    }
    
}
