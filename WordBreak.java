/*
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 *  determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 */

import java.util.*;
public class WordBreak {
	 public boolean wordBreak(String s, List<String> wordDict) {
	        int len = s.length();
	        boolean[] dp = new boolean[len + 1];
	        
	        dp[0] = true;
	        
	        for(int i = 1 ; i <= len ; i++)
	        {
	            for(String word : wordDict)
	            {
	                int start = i - word.length();
	                if(start < 0 || !dp[start])
	                {
	                    continue;
	                }
	                else
	                {
	                    String temp = s.substring(start,start + word.length());
	                    if(temp.equals(word))
	                    {
	                        dp[i] = true;
	                        break;
	                    }
	                        
	                }
	            }
	        }
	        return dp[len];
	        
	    }
	

}
