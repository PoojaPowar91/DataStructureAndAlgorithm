import java.util.*;
public class WordBreak2_DP {
	public List<String> wordBreak(String s, List<String> wordDict) {
        LinkedList<String>[] dp = new LinkedList[s.length() + 1];
        LinkedList<String> initial = new LinkedList<>();
        initial.add("");
        dp[0] = initial;
        
         boolean[] dp1 = new boolean[s.length() + 1];
        dp1[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp1[j] && wordDict.contains(s.substring(j, i))) {
                    dp1[i] = true;
                    break;
                }
            }
        }
        
        // We are done if there isn't a valid sentence at all
        if (!dp1[s.length()]) {
            return new ArrayList<String>();
        } 
        
        for(int i = 1 ; i <= s.length() ; i++)
        {
            LinkedList<String> list = new LinkedList<>();
            for(int j = 0 ; j < i ; j++)
            {
                 if(dp[j].size() > 0 && wordDict.contains((s.substring(j, i))))
                {
                   for(String str : dp[j])
                   {
                       list.add(str + (str.equals("") ? "" : " ") + s.substring(j, i));
                   }
                }
            }
              
             dp[i] = list;      
            
        }
         return dp[s.length()]; 
    }

}
