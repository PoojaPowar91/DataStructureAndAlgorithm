/*
 * Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 */
import java.util.*;
class InsertDeleteGetRandomInO1 {

    HashMap<Integer, Integer> map ;
    List<Integer> list;
    /** Initialize your data structure here. */
    public InsertDeleteGetRandomInO1() {
        map = new HashMap<>();
        list = new LinkedList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        else
        {
            map.put(val , list.size());
            list.add(val);
            return true;
        }       
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
         if(!map.containsKey(val))
            return false;
        else
        {
            int last = list.get(list.size() - 1);
            int idx = map.get(val);
           
            list.set(idx ,last);
            map.put(last , idx);
            
            list.remove(list.size() - 1);
            map.remove(val);
           
            return true;
        }
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
