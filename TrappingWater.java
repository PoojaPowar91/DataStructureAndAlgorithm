import java.util.Stack;

public class TrappingWater {
	 public int trap(int[] height) {
	        Stack<Integer> st = new Stack<>();
	        int current = 0;
	        int res = 0;
	        while(current < height.length)
	        {
	            while(!st.empty() && height[current] > height[st.peek()])
	            {
	                int top = st.pop();
	                  if(st.empty())
	                    break;
	                int distance = current - st.peek() - 1;
	              
	                int water_height = Math.min(height[st.peek()] , height[current]) - height[top];
	                res = res + distance * water_height;
	                
	            }
	             st.push(current++);
	        }
	       
	      return res;
	    }

}
