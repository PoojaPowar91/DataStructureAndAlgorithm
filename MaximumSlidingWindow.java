import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 */
public class MaximumSlidingWindow {
	  public int[] maxSlidingWindow(int[] nums, int k) {
	        if(nums == null || nums.length == 0 || k == 0) return new int[0];
	        
	        int res[] = new int[nums.length - k + 1];
	        int c = 0;
	        Deque<Integer> queue = new ArrayDeque<>();
	        for(int i = 0 ; i < nums.length ; i++)
	        {
	            if(!queue.isEmpty() && queue.peek() <= i - k)
	                queue.pollFirst();
	            while(!queue.isEmpty() && nums[i] > nums[queue.peekLast()])
	                queue.pollLast();
	            queue.offer(i);
	             
	            if(i+1 >= k)
	                res[c++] = nums[queue.peek()];
	        }
	      return res;  
	    }
}
