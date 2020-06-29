/*
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
 */




import java.util.PriorityQueue;

public class MedianFinder {
	  PriorityQueue<Integer> minHeap;
	    PriorityQueue<Integer> maxHeap;
	    /** initialize your data structure here. */
	    public MedianFinder() {
	        minHeap = new PriorityQueue<>();
	        maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
	        
	    }
	    
	    public void addNum(int num) {
	        maxHeap.add(num);
	        minHeap.add(maxHeap.poll());
	        if(minHeap.size() > maxHeap.size())
	            maxHeap.add(minHeap.poll());
	        
	        
	    }
	    
	    public double findMedian() {
	        if(maxHeap.size() > minHeap.size())
	            return Double.valueOf(maxHeap.peek());
	        else
	            return (maxHeap.peek() + minHeap.peek()) * 0.5;
	        
	    }

}
