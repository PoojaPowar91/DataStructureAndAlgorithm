import java.util.*;
public class TwoSumLessThanK {
	 public int twoSumLessThanK(int[] A, int K) {
	        
	        if(A.length==0)
	            return -1;
	        
	        /*
	            Sort array so that we could use two pointers, 
	            1 from left -- order of non decreasing
	            1 from right -- order of non increasing
	        */
	        Arrays.sort(A);
	        
	        int i=0, j=A.length-1;
	        
	        /*The value where we store max value < K that is sum of 
	        two integers in the array */
	        
	        int max = -1;
	        
	        while(i<j){
	            int sum = A[i] + A[j];
	            
	            if(sum<K){
	                /* 
	                    Find max sum, comparing to previous max sums
	                */
	                max = Math.max(sum, max);
	                i++; //Check for a bigger value from left 
	            }
	            else{
	                // Sum is greater than K, reduce right pointer
	                j--;
	            }
	        }
	        
	        return max;
	        
	        /*
	            The time complexity is O(nlogn) - Sorting 
	            where n is the number of elements
	        */
	        
	    }

}

