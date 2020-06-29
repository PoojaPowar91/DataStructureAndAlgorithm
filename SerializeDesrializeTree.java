
/*
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SerializeDesrializeTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "X";
        else
        {
            String left = serialize(root.left);
            String right = serialize(root.right);
            return root.val + "," + left + "," + right;
        }
            
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] s = data.split(",");
        ArrayList<String> l = new ArrayList<>(Arrays.asList(s));
        return helperFunc(l);
        
    }
    
    TreeNode helperFunc(List<String> l)
    {
        if(l.get(0).equals("X"))
        {
              l.remove(0);
              return null;
        }
        else
        {
              TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
               l.remove(0);
               root.left = helperFunc(l);
               root.right = helperFunc(l);
               return root;
        }
          
      
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
