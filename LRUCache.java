import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
	
	  LinkedHashMap<Integer , Integer> map;
	    public LRUCache(int capacity) 
	    {
	        map = new LinkedHashMap<Integer , Integer>(capacity, 0.75F, true)
	        {
	            protected boolean removeEldestEntry(Map.Entry<Integer , Integer> eldest)
	            {
	                return size() > capacity;
	            }
	        };
	        
	    }
	    
	    public int get(int key) {
	        return map.getOrDefault(key , -1);
	    }
	    
	    public void put(int key, int value) {
	        map.put(key , value);
	    }

}
