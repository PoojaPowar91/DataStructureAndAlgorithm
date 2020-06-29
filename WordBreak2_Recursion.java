/*
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 *  add spaces in s to construct a sentence where each word is a valid dictionary word.
 *   Return all such possible sentences.
 */

import java.util.*;
public class WordBreak2_Recursion {
	Map<Integer, List<String>> memo = new HashMap<>();

	public List<String> wordBreak(String s, List<String> wordDict) {
	    if(memo.containsKey(s.length())){
	        return memo.get(s.length());
	    }    
	    List<String> result = new ArrayList<>();
	    for(String word: wordDict){
	        if(s.startsWith(word)){
	            if(word.equals(s)){
	                result.add(word);
	            }else{
	                wordBreak(s.substring(word.length()), wordDict).forEach(st -> result.add(word + " " + st));
	             }
	            
	        }
	    }
	    memo.put(s.length(), result);
	    return result;
	}
	

}
