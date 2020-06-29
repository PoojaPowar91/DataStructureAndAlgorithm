/*
  esign and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.

Note that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted. This number is set to zero when the item is removed.
 */

import java.util.*;
class LFUCache {

	  int capacity;
	    HashMap<Integer , int[]> map = new HashMap<>();
	    PriorityQueue<Integer> min_heap;
	    static int timer;
	    public LFUCache(int capacity) {
	     this.capacity = capacity; 
	     timer = 0;
	     min_heap = new PriorityQueue<>(new Comparator<Integer>()
	            {
	              public int compare(Integer a1 , Integer a2)
	              {
	                  if(map.get(a1)[1] == map.get(a2)[1])
	                      return map.get(a1)[2] - map.get(a2)[2];
	                  else
	                      return map.get(a1)[1] - map.get(a2)[1];
	              }
	                                 
	            
	            });
	    }
	    
	    public int get(int key) {
	        
	         if(!map.containsKey(key))
	         {
	             return -1;
	         }
	        else
	        {
	           int[] arr = map.get(key);
	            
	           arr[1]++;
	            arr[2] = timer++;
	           map.put(key , arr);
	        
	            min_heap.remove(key);
	             min_heap.add(key);
	            
	           return arr[0];
	        }
	        
	    }
	    
	    public void put(int key, int value) {
	        if(capacity == 0)
	            return;
	        
	        if(!map.containsKey(key))
	        {
	            if(map.size() == capacity)
	            {
	                int removeIndex = min_heap.poll();
	                map.remove(new Integer(removeIndex));
	            }
	             map.put(key ,new int[]{value,1,timer++});
	              min_heap.add(key);
	           
	           
	        }
	        else
	        {
	           int[] arr = map.get(key);
	           arr[0] = value;
	           arr[1] = arr[1] + 1;
	           arr[2] = timer++;
	           map.put(key , arr);
	           min_heap.remove(key);
	            min_heap.add(key);
	        }
	        
	    }
    
    public static void main(String args[])
    {
    	//["","put","put","get","put","get","get","put","get","get","get"]
    	//		[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
    	LFUCache cache = new LFUCache(2);
    	cache.put(1,1);
    	cache.put(2,2);
    	System.out.println(cache.get(1));
    	cache.put(3,3);
    	System.out.println(cache.get(2));
    	System.out.println(cache.get(3));
    	cache.put(4,4);
    	System.out.println(cache.get(1));
    	System.out.println(cache.get(3));
    	System.out.println(cache.get(4));
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */