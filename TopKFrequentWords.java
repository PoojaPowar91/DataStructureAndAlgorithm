/*
 * Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 */
import java.util.*;
class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String , Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        if(words == null || words.length == 0)
            return res;
        
        for(String s : words)
        {
            map.put(s , map.getOrDefault(s , 0) + 1);
        }
        
        PriorityQueue<String> minHeap = new PriorityQueue<String>(k + 1 , (a,b) -> map.get(a) == map.get(b) ? b.compareTo(a) : map.get(a) - map.get(b));
        
        for(String s : map.keySet())
        {
              minHeap.add(s);
               if(minHeap.size() > k)
                   minHeap.poll();
             
        }
        
        while(!minHeap.isEmpty())
            res.add(0, minHeap.poll());
        
        return res;
    }
}
