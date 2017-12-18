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
        
        return out;//Return sorted list
    }
    
    public int[] bubbleSort(boolean inverted){
        int[] out = numbers.clone();//Copy number array
        boolean swapped = true;//Boolean to keep trak of if we swapped this pass
        int iterations = 1;//Keeps track of how many less than the array length need to be checked
        while(swapped){//While the list isn't completely sorted (something was swapped last pass)
            swapped = false;//Set to false, no swaps this pass yet
            for(int i = 0; i < out.length - iterations; i++){//For all items in the list except the last one
                if(out[i] < out[i + 1] == inverted){//If smaller than the next element and inverted is true, swap. If larger than the next element and inverted is false, swap
                    swapped = true;//Mark that something was swapped this pass
                    int temp = out[i];//Store value at i
                    out[i] = out[i + 1];//Set value to next value
                    out[i + 1] = temp;//Set next value to this value as stored in temp
                }
            }
            iterations++;
        }
        return out;//Return sorted list
    }
    
    public int[] insertionsSort(boolean inverted){
        int[] out = numbers.clone();//Copy number array
        for(int i = 1; i < out.length; i++){//For each number except the first
            int temp = out[i];//Store the current number
            int l = i - 1;//Index to check
            while(l >= 0//If it hasn't hit the begining of the array
                    && out[l] < temp == inverted){//And the element here is greater than or less than the current number such that the currnet number should go before it
                out[l + 1] = out[l];//The element above this one equals this element (moving the element up one)
                l--;//Check previous element in array
            }
            out[l + 1] = temp;//Set apropriate position to value of this element
        }
        return out;//Return sorted array
    }
    
    //Why'd you have to go and make things so complicated?
    public int[] quickSort(boolean inverted){
        int[] out = numbers.clone();//Copy number array
        this.inverted = inverted;//Make inverted accessible from another function
        return qsort(out, 0, out.length - 1);//Run qsort on the entire array
    }
    
    private boolean inverted;//Flag for descending mode used by comp
    
    private int comp(int a, int b){//Compare 2 numbers depending on inverted
        if(inverted){//If in descending mode
            return b - a;//Do comparison backwards to sort backwards
        }else{
            return a - b;//Do comparison normally to sort forwards
        }
    }
    
    private int[] qsort(int[] A, int lo, int hi){//Quicksort
        if(lo < hi){//If low is >= hi then it's done
            int p = partition(A, lo, hi);//return the index of a value in the right location
            qsort(A, lo, p);//Quicksort everything left of this value
            qsort(A, p + 1, hi);//Quicksort everything right of this value
        }
        return A;//Return the array that has been modified because Java passes pointers for arrays
    }
    
    private int partition(int[] A, int lo, int hi){
        int pivot = A[lo];//Set pivot to first value in this array section
        int i = lo - 1;//Counter from low end
        int j = hi + 1;//Counter from high end
        while(true){//Keep looping until it returns a value
            do{
                i++;//Increment i
            }while(comp(A[i], pivot) < 0);//As long as the value at i is on the proper side of the pivot
            
            do{
                j--;//Decrement j
            }while(comp(A[j], pivot) > 0);//As long as the value at k is on the proper side of the pivot
            
            if(i >= j) return j;//If they converge in the middle, then all values are on the proper sides
            
            //Swap A[i] with A[j]
            int temp = A[i];//Store A[i] in a temporary variable as it will be overwritten
            A[i] = A[j];//Set A[i] to A[j]
            A[j] = temp;//Set A[j] to the former value of A[i]
        }
    }
}