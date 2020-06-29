import java.util.*;
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> ans = new ArrayList<>();
        HashMap<String , List<String>> map = new HashMap<>(); 
        if(strs.length == 0)
            return new ArrayList<>();
        
        for(String s : strs)
        {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String str = String.valueOf(c);
            List<String> l = map.getOrDefault(str , new ArrayList<>());
             l.add(s);
            map.put(str , l);
        }
        
        for(List<String> l : map.values())
        {
           ans.add(l);  
        }
        return ans;
        
    }

}
