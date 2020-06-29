/*
 * Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a special character '#'). For each character they type except '#', you need to return the top 3 historical hot sentences that have prefix the same as the part of sentence already typed. Here are the specific rules:
 */
import java.util.*;

class SearchAutoCompleteSystemTrie {
    String pre;
    Node root;
    String[] ss;
    int[] ts;
    private class Node{
        Map<Character, Node> child;
        Map<String, Integer> cnt;
        public Node(){
            child = new HashMap<>();
            cnt = new HashMap<>();
        }
    }

    public SearchAutoCompleteSystemTrie(String[] ss, int[] ts) {
        pre = "";
        this.ss = ss;
        this.ts = ts;
        root = new Node();
        for (int i = 0; i < ss.length; i++) {
            build(ss[i], ts[i]);
        }
    }
    
    private void build(String s, int cnt) {
        Node curr = root;
        for (char c : s.toCharArray()) {
            Node next = curr.child.getOrDefault(c, new Node()); 
            curr.child.put(c, next);  // this is needed.
            curr = next;
            Map<String, Integer> m = curr.cnt;
            m.put(s, m.getOrDefault(s, 0) + cnt);
        }
    }
     
    public List<String> input(char a) {
        List<String> res = new ArrayList<>();
        if (a == '#') {    // this is critical
            build(pre, 1);
            pre = "";
            return res;
        }
        Node curr = root;
        pre = pre + a;
        for (char c : pre.toCharArray()) {
            if (!curr.child.containsKey(c)){
                return res;
            }
            curr = curr.child.get(c);
        }
        Map<String, Integer> map = curr.cnt;
        PriorityQueue<String> pq = new PriorityQueue<>(4, (c, b) -> (map.get(b) == map.get(c) ? b.compareTo(c) : map.get(c) - map.get(b)));   // max queue;
        for (String str : map.keySet()) {
            pq.offer(str);
            if (pq.size() > 3) pq.poll();
        }
        while(!pq.isEmpty()) {
            res.add(0, pq.poll());  // order matters.
        }
        return res;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
