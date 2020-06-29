/*
 * Given two words (beginWord and endWord), and a dictionary's word list, 
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 * 
 */

import java.util.*;
public class WordLadder {
	  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	        int len = beginWord.length();
	        HashMap<String , List<String>> dict = new HashMap<>();
	        Map<String, Integer> distance = new HashMap<>();
	        Queue<String> q = new LinkedList<>();
	        
	        for(String word : wordList)
	        {
	            for(int i = 0 ; i < len ; i++)
	            {
	                String pattern = word.substring(0 , i) + "*" + word.substring(i+1,len);
	                List<String> l = dict.getOrDefault(pattern, new ArrayList<>());
	                l.add(word);
	                dict.put(pattern , l);
	            }
	        }
	        
	        q.add(beginWord);
	        distance.put(beginWord,1);
	        
	        while(!q.isEmpty())
	        {
	            String front = q.poll();
	            int level = distance.get(front);
	             for(int i = 0 ; i < len ; i++)
	            {
	                String pattern = front.substring(0 , i) + "*" + front.substring(i+1,len);
	                 for(String adj : dict.getOrDefault(pattern, new ArrayList<>()))
	                 {
	                     if(adj.equals(endWord))
	                         return level + 1;
	                     if(!distance.containsKey(adj))
	                     {
	                         distance.put(adj,level + 1);
	                         q.add(adj);
	                     }
	                 }
	               
	            }
	            
	        }
	      return 0;
	        
	    }

}
