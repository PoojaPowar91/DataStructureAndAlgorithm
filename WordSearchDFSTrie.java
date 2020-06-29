/*
 * 
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells
 are those horizontally or vertically neighboring. The same letter cell may not be used more 
 than once in a word.
 * 
 */


import java.util.*;
class TrieNode
{
   TrieNode[] children; 
   String word;
   TrieNode()
   {
       children = new TrieNode[26];
       word = null;
   }
}

class WordSearchDFSTrie {
    Set<String> res = new HashSet<>(); 
    public List<String> findWords(char[][] board, String[] words) 
    {
       TrieNode root = new TrieNode();
       for(String word : words)
       {
         buildTree(root , word);
       }
       for(int i = 0 ; i < board.length ; i++)
       {
         for(int j = 0 ; j < board[i].length ; j++)
         {
            dfs(board , i ,j , root);
         }
       }
        
        List<String> result = new ArrayList<>();
        result.addAll(res);
        return result;
        
    }
    
    void dfs(char[][] board , int i , int j , TrieNode root)
    {
       if (i < 0 ||  j < 0 || i > board.length - 1 || j > board[i].length - 1  || board[i][j] == '1') {
            return;
        }
        
       
        
        if(root.children[board[i][j] - 'a'] == null)
        return;
        
         if(root.children[board[i][j] - 'a'].word != null)
        {
           res.add(root.children[board[i][j] - 'a'].word);
           
        }
        
     
        
        char temp = board[i][j];
        board[i][j] = '1';
        dfs(board , i + 1 , j, root.children[temp - 'a']);
        dfs(board , i - 1 , j, root.children[temp - 'a']);
        dfs(board , i , j + 1, root.children[temp - 'a']);
        dfs(board , i , j - 1, root.children[temp - 'a']);
        board[i][j] = temp;
    }
           
        
        
    
    void buildTree(TrieNode root , String words)
    {
          char[] charray = words.toCharArray();
          for(char c : charray)
          {
            if(root.children[c - 'a'] == null)
            {
               root.children[c - 'a'] = new TrieNode();
            }
            root = root.children[c - 'a'];
          } 
          
          root.word = words;
    }
}
