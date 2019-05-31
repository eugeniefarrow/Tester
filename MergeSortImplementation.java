
import java.util.*;
public class MergeSortImplementation{
    
    //Sort an array of integers into ascending order
    // elements is an array containing the items to be sorted
    public static void mergeSort(int[] elements){
        int n = elements.length;
        int[] temp = new int[n];
        mergeSortHelper(elements, 0, n-1, temp);

    }
    
    //Sorts elements[from] ... elements[to] inclusive into ascending order
    //elements is an array containing items to be sorted
    //from is the beginning index of items in elements to be sorted
    //to is the ending index of the items in elements to be sorted
    //temp is a temporary array to be used during the merge process
    
    private static void mergeSortHelper(int[] elements, int from, int to, int[] temp){
        if(from < to){
            int middle = (from + to) / 2;
            mergeSortHelper(elements, from, middle, temp);
            mergeSortHelper(elements, middle + 1, to, temp);
            merge(elements, from, middle, to, temp);
    
        }
    }
    
    //Merges two adjacent array parts, each of which has been sorted into ascending
    // order, into one array part that is sorted into ascending order
    // elements is an array containing the parts to be merged
    // from is the beginning index in elements of the first part
    // mid is the ending index in elements of the first part
    // mid+1 is the beginning index in elements of the second part
    // to the ending index in elements of the second part
    // temp is a temporary array to use during the merge process
    private static void merge(int[] elements, int from, int mid, int to, int[] temp){
        int i = from;
        int j = mid + 1;
        int k = from;
  
        while(i <= mid && j <= to){
            if(elements[i] < elements[j]){
                temp[k] = elements[i];
                i++;        
            }  
            else{
                temp[k] = elements[j];
                j++;        
            }
            k++;   
    
        }
        while(i <= mid){
            temp[k] = elements[i];
            i++;
            k++;   
        }
        while (j <= to){
            temp[k] = elements[j];
            j++;
            k++;       
        }
        for(k = from; k <= to; k++){
            elements[k] = temp[k];
        }
    }
    
    // Merge sorter
    public static void main(String[] args){
        int[] myArray = {32, 21, 5, 8, 13, 12, 2};
        System.out.println("Before call to merge sort");
        System.out.println(Arrays.toString(myArray));  
        
        mergeSort(myArray);
       
        System.out.println("After call to merge sort");
        System.out.println(Arrays.toString(myArray)); 
    
    
    }
}

