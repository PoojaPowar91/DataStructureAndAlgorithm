/*
 * O(n2)
 */
public class LongestPallindromSubstring {
	public String longestPalindrome(String s) {
        int start = 0;
        int end = s.length();
        int max = Integer.MIN_VALUE;
        String maxString = "";
        
        for(int i = 0 ; i < s.length() ; i++)
        {
            String s1 = find(i,i,s);
            String s2 = find(i,i+1,s);
            if(s2.length() > s1.length())
                s1 = s2;;
            
            if(s1.length() > max)
            {
                max = s1.length();
                maxString = s1;
            }
        }
        
        return maxString;
        
    }
    
    String find(int i , int j , String s)
    {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j))
        {
            i--;
            j++;
        }
        
        return s.substring(i + 1 , j);
    }

}
