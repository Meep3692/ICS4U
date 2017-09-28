/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loopydoopshoop;

import java.util.Scanner;

/**
 *
 * @author awoo
 */
public class Program {

    
    static double factorial(double in){
        if(in == 0) return 1;
        return in * factorial(in - 1);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        /*System.out.println("\nAll");
        for(int i = 1; i <= input; i++){
            System.out.println(i);
        }
        
        System.out.println("\nEvens");
        for(int i = 2; i <= input; i += 2){
            System.out.println(i);
        }
        
        System.out.println("\nSystem of Counting Down");
        for(int i = 100; i >= input; i -= 10){
            System.out.println(i);
        }
        
        System.out.println("\nPrimes");
        for(int i = 1; i <= input; i += 2){
            boolean prime = true;
            for(int l = 2; l <= i / 2; l++){
                if (i % l == 0){
                    prime = false;
                }
                //System.out.println(i + " % " + l + " = " + (i % l));
            }
            if(prime)
                System.out.println(i);
        }*/
        
        System.out.println(factorial(input));
    }
    
}
