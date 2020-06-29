/*
 * Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.
A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.
 */
import java.util.*;
public class ConcatenatedWords {
	 public List<String> findAllConcatenatedWordsInADict(String[] words) {
	        
	        List<String> res = new ArrayList<>();
	        
	        if(words.length <= 2 )
	            return res;
	        
	        Set<String> set = new HashSet<>();
	        for(String word : words)
	        {
	            set.add(word);
	        }
	        
	        for(String word : words)
	        {
	            set.remove(word);
	            if(dfs(word,set))
	                res.add(word);
	            set.add(word);
	        }
	         return res;
	    }
	    
	    boolean dfs(String word , Set<String> set)
	    {
	        if(set.contains(word))
	            return true;
	        
	        for(int i = 1 ; i < word.length() ; i++)
	        {
	             if (set.contains(word.substring(0, i)) && dfs(word.substring(i), set))
	                return true;
	        }
	        
	        return false;
	    }
	    

}
