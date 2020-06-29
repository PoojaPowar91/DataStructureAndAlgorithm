/*
 * We are given some website visits: the user with name username[i] visited the website website[i] at time timestamp[i].
A 3-sequence is a list of websites of length 3 sorted in ascending order by the time of their visits.  (The websites in a 3-sequence are not necessarily distinct.)
Find the 3-sequence visited by the largest number of users. If there is more than one solution, return the lexicographically smallest such 3-sequence.
  O(n ^ 3)
 */


import java.util.*;
class MostVisitedWebsite {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        
        HashMap<String , Integer> count = new HashMap <>();
        HashMap<String , TreeMap<Integer , String> > map = new HashMap<>();
        for( int i = 0 ; i < username.length ; i++)
        {
            TreeMap websiteMap  = map.getOrDefault(username[i], new TreeMap<Integer , String>());
            websiteMap.put(timestamp[i],website[i]);
            map.put(username[i],websiteMap);
        }
        int max = Integer.MIN_VALUE;
        String res = "";
        
        for(String user : map.keySet())
        {
            Set<String> set = new HashSet<>();
            ArrayList<String> l = new ArrayList<>(map.get(user).values());
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < l.size() - 2 ; i++)
            {
                 String web1 = l.get(i) + " ";
                 for(int j = i + 1 ; j < l.size() - 1 ; j++)
                 {
                     String web2 = l.get(j) + " ";
                     for(int k = j + 1 ; k < l.size() ; k++)
                     {
                         String web3 = l.get(k) + " ";
                         String web = web1 + web2 + web3;
                         if(set.contains(web))
                             continue;
                         else
                         {
                             set.add(web);
                            int cnt = count.getOrDefault(web,0) + 1;
                            count.put( web , cnt);
                            if(cnt > max)
                            {
                                 res = web;
                                 max = cnt;
                            }else if(cnt == max )
                            {
                                res = res.compareTo(web) < 0 ? res : web;
                            }
                             
                         }   
                     }
                 }
            }
          
     
               
        }
        
        String s[]  = res.split(" ");
        List<String> result = new ArrayList<>();
         result.add(s[0]);  
          result.add(s[1]);  
          result.add(s[2]);
        
        return result;
        
        
    }
}
