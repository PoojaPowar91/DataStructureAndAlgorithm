
import java.util.*;
class SearchAutoCompleteSystem {
    
	   HashMap<String , Integer> map;
	    StringBuilder input;
	    HashSet<String> suggest;

	    public SearchAutoCompleteSystem(String[] sentences, int[] times) {
	        map = new HashMap<>();
	        for(int i = 0 ; i < sentences.length ; i++)
	        {
	          map.put(sentences[i] , times[i]);   
	        }
	        input = new StringBuilder();
	         suggest = new HashSet<>();
	        
	        
	    }
	    
	    public List<String> input(char c) {
	        ArrayList<String> result = new ArrayList<>();
	        if(c == '#')
	        {
	              map.put(input.toString(), map.getOrDefault(input.toString(), 0) + 1);
	              input = new StringBuilder();
	             suggest.clear();
	        }
	        else if(input.length() == 0)
	        {
	            input.append(c);
	           findWords(new HashSet<String>(map.keySet()) , input.toString(), result);
	           
	        }
	        else
	        {
	            input.append(c);
	           findWords(suggest , input.toString(), result);
	           
	        }
	       
	        
	         return result;
	        
	    }
	    
	    void findWords(HashSet<String> wordSet , String s , ArrayList<String> result)
	    {
	          HashSet<String> temp = new HashSet<String>();
	            PriorityQueue<String> res = new PriorityQueue<>(3,new Comparator<String>()
	                                  {
	                                      public int compare(String s1 , String s2)
	                                      {
	                                          if(map.get(s1) == map.get(s2))
	                                              return s1.compareTo(s2);
	                                          else
	                                              return map.get(s2) - map.get(s1);
	                                      }
	                                  });
	        
	        for(String str : wordSet)
	        {
	            if(str.length() >= s.length() &&  str.substring(0 , s.length()).equals(s) )
	            {
	                 temp.add(str);
	                 res.add(str);
	            }
	        }
	      
	        suggest.clear();
	        suggest.addAll(temp);
	        int count = 0;
	        while(count < 3 && !res.isEmpty())
	        {
	             result.add(res.poll());
	            count++;
	        }
	      
	           

	    }
    
    void printList(List<String> res)
    {
    	for(String s : res)
    		System.out.print(s + " ");
    	System.out.println();
    }
    
    public static void main(String args[])
    {
    	String[] sentences = {"i love you","island","iroman","i love leetcode"};
    	int[] times = {5,3,2,2};
    	SearchAutoCompleteSystem obj = new SearchAutoCompleteSystem(sentences, times);
    	obj.printList(obj.input('i'));
    	obj.printList(obj.input(new String(" ").toCharArray()[0]));
    	obj.printList(obj.input('a'));
    	obj.printList(obj.input('#'));
    	obj.printList(obj.input('i'));
    	obj.printList(obj.input(' '));
    	obj.printList(obj.input('a'));
    	obj.printList(obj.input('#'));
    	obj.printList(obj.input('i'));
    	obj.printList(obj.input(' '));
    	obj.printList(obj.input('a'));
    	obj.printList(obj.input('#'));
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
