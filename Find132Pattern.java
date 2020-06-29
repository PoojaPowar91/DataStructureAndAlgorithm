/*
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.
 */

import java.util.Stack;

public class Find132Pattern {
	  public boolean find132pattern(int[] nums) {
	        if(nums == null || nums.length == 0)
	            return false;
	       
	        int min[] = new int[nums.length];
	        min[0] = nums[0];
	        for(int i = 1 ; i < nums.length ; i++)
	        {
	           min[i] = Math.min(min[i - 1] , nums[i]);            
	        }
	        Stack<Integer> st = new Stack<>();
	        
	        for(int i = nums.length - 1 ;i >= 0 ; i--)
	        {
	            if(min[i] < nums[i])
	            {
	                while(!st.empty() && st.peek() <= min[i])
	                    st.pop();
	                
	                if(!st.isEmpty() && st.peek() < nums[i])
	                    return true;
	                 st.push(nums[i]);
	            }
	           
	            
	        }
	        return false;
	        
	    }

}
