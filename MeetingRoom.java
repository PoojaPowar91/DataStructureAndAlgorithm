/*
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 */
import java.util.*;
public class MeetingRoom {
	 public int minMeetingRooms(int[][] intervals) {
		    Arrays.sort(intervals, (a,b)->a[0]-b[0]);
		    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		    for (int[] temp : intervals)
		    {
		        if(!pq.isEmpty() && pq.peek() <= temp[0])
		            pq.poll();   
		        pq.offer(temp[1]);
		    }
		    return pq.size();
		        
		    }

}
