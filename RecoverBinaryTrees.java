import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class RecoverBinaryTrees {
	
	void swap(TreeNode a, TreeNode b) {
		int temp = a.val;
		a.val = b.val;
		b.val = temp;
	}
	
	 public void recoverTree(TreeNode root) 
	 {
		 TreeNode x = null; 
		 TreeNode y = null;
		 TreeNode pred = null;
		 Stack<TreeNode> s = new Stack<>();
		 while(!s.empty() || root != null)
		 {
			 while(root != null)
			 {
				 s.push(root);
				 root = root.left;
			 }
			 
		     root = s.pop();
		     if(pred != null && root.val < pred.val )
		     {
		    	 y = root;
		    	 if( x == null)
		    		 x = pred;
		    	 else
		    		 break;
		     }
		     pred = root;
		     root = root.right;
		     
				 
		 }
		 swap(x , y);
	 }
	 

}
