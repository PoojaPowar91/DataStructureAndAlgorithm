/*
 * Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.  (The occurrences may overlap.)
Return any duplicated substring that has the longest possible length.  (If S does not have a duplicated substring, the answer is "".)
O(n^2)
 */
import java.util.*;
public class LongestRepeatingSubstringDP {
	   public String longestDupSubstring(String S) {
	        if(S == null || S.length() == 0)
	            return "";
	        
	        int n = S.length();
	        int[][] dp = new int[n + 1][n + 1];
	        int max = Integer.MIN_VALUE;
	        String res = "";
	        
	        for(int i = 1 ; i <= n ; i++)
	        {
	            for(int j = i + 1 ; j <=n ; j++)
	            {
	                if(S.charAt(i - 1) == S.charAt(j - 1))
	                {
	                    dp[i][j] = dp[i -1][j - 1] + 1;
	                    if(dp[i][j] > max)
	                    {
	                         max = dp[i][j];
	                        res = S.substring(i - max , i );

	                        
	                    }
	                }
	            }
	        }
	        return res;
	        
	    }

}
