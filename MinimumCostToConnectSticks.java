/*
 * You have some sticks with positive integer lengths.
You can connect any two sticks of lengths X and Y into one stick by paying a cost of X + Y.  You perform this action until there is one stick remaining.
Return the minimum cost of connecting all the given sticks into one stick in this way.
 O(nlogn)
 */

import java.util.*;
class MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
      for(int i=0;i<sticks.length;i++){
            q.offer(sticks[i]);
        }
        int cost = 0;
        
        while(q.size() > 1)
        {
            int a = q.poll();
            int b = q.poll();
            cost = cost + a + b;
            q.offer(a + b);
        }
        return cost;
        
    }
}
