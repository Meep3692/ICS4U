/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 *
 * @author Darian
 */
public class Sorter {
    private int[] numbers;
    
    public int[] regenerateList(int quantity){
        numbers = new int[quantity];//Create new array
        for(int i = 0; i < quantity; i++){//For every element in array
            numbers[i] = (int)((Math.random() * 2000.0) - 1000.0);//Set to random int between -1000 and 1000
        }
        return numbers;
    }
    
    int[] selectionSort(boolean inverted){
        int[] out = numbers.clone();//Copy number array
        for(int i = 0; i < out.length; i++){//For each element
            for(int l = i + 1; l < out.length; l++){//For every element after
                if(out[l] > out[i] == inverted){//If l > i and inverted is true, flip. If l < i and inverted is false, flip
                    int temp = out[i];//Store value at i
                    out[i] = out[l];//Put value at l into position i
                    out[l] = temp;//Put value that was at i into position l
                }
            }
        }
        
        return out;
    }
}