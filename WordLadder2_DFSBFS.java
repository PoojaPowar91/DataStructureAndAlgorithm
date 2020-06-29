/*
 * Given two words (beginWord and endWord), and a dictionary's word list, 
 * find all shortest transformation sequence(s) from beginWord to endWord, such that:
 */


import java.util.*;

public class WordLadder2_DFSBFS {
	private Map<String, Set<String>> graph;
    private List<List<String>> result;
    private Map<String, Integer> distance;
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        distance = new HashMap<>();
        graph = buildGraph(beginWord, wordList);
        result = new ArrayList<>();
        dfs(beginWord, endWord,  new ArrayList<>());
        return result;
    }
    
    private void dfs(String word, String target, List<String> solution) {
        solution.add(word);
        if (target.equals(word)) {
            result.add(solution);
        } else {
            for (String child : graph.get(word)) {
                if (distance.get(word) + 1 == distance.getOrDefault(child, Integer.MAX_VALUE)) { 
                    dfs(child, target, new ArrayList<>(solution));
                }
            }
        }
    }
    
    int findDiffrence(String s1 , String s2)
    {
          int cnt = 0;
        for (int j = 0; j < s1.length(); j++) {
            if (s1.charAt(j) != s2.charAt(j)) {
                cnt++;
            }
        }
        return cnt;
    }
    
    private Map<String, Set<String>> buildGraph(String beginWord, List<String> wordList) {
        Map<String, Set<String>> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        distance.put(beginWord, 0);
        
        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++) 
            {
                String word = queue.poll();
                Set<String> set = map.getOrDefault(word, new HashSet<>());
                map.put(word, set);
                for (String s : wordList)
                {
                    if (findDiffrence(s,word) == 1) 
                    {
                        if (!distance.containsKey(s)) {
                            queue.add(s);
                            distance.put(s, distance.get(word) + 1);
                        }
                        set.add(s);
                    }
                }
            }
        }
        return map;
    }
    
}
