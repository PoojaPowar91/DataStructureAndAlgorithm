/*
 * Complexity of trie seach nad insert in O(NlogK)
 * n : number of wprds
 * k : keys in the tree
 */
import java.util.*;
class SearchSuggestionSystem {
    class TrieNode
    {
        Map<Character , TrieNode> map = new HashMap<>();
        List<String> words = new ArrayList<>();
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        for(String s : products)
        buildTrie(root , s);
        
        for(int i = 1 ; i <= searchWord.length() ; i++)
        {
             getSuggestions(root , searchWord.substring(0,i) , res);
        }
        return res;
    }
     void buildTrie(TrieNode root , String s)
     {
         for(int i = 0 ; i < s.length() ; i++)
         {
             char c = s.charAt(i);
             TrieNode node = root.map.getOrDefault(c , new TrieNode());
            root.map.put(c , node);
             node.words.add(s);
             root = node;
         }
     }
      
    void getSuggestions(TrieNode root , String input , List<List<String>> res)
    {
        for(int i = 0 ; i < input.length() ; i++)
        {
            char c = input.charAt(i);
            if(!root.map.containsKey(c))
            {
                res.add(new ArrayList<>());
                 return;
            }
               
            else
                root = root.map.get(c);
        }
        TreeSet<String> w = new TreeSet<>(root.words);
       
        if(w.size() > 3)
        {
            List<String> l  = new ArrayList<>();
            for(int i = 0 ; i < 3 ; i++)
                l.add(w.pollFirst());
            res.add(l);
                
        }
        else
        {
            res.add(new ArrayList<>(w));
        }
    }
    
}