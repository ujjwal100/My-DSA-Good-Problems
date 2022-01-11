class Solution {
 /**
  * Problem Link : https://practice.geeksforgeeks.org/problems/duplicate-subtree-in-binary-tree/1#
  * Time Complexity of My solution : O(N)
  * Space Complexity : O(N)
  * (Google Interview Problem)
  */
    static String inorderTraversalForSubtree;
    Set<String> subtrees;
    int dupSub(Node root) {
        // code here 
        subtrees = new HashSet<String>();
        return (hasDuplicateSubtree(root) == true? 1 : 0);
    }
    
    private boolean hasDuplicateSubtree(Node root) {
        if (root == null) {
            inorderTraversalForSubtree = "";
            return false;
        } else {
            if (hasDuplicateSubtree(root.left)) {
                return true;
            }
            String leftSubtree = inorderTraversalForSubtree;
            
            if (hasDuplicateSubtree(root.right)) {
                return true;
            }
            
            String rightSubtree = inorderTraversalForSubtree;
            
            inorderTraversalForSubtree = leftSubtree + " " + root.data + " " + rightSubtree;
            
            if (subtrees.contains(inorderTraversalForSubtree) && (leftSubtree.length() > 0 || rightSubtree.length() > 0)) {
              // left | right subtree is non-null
                return true;
            } else {
                subtrees.add(inorderTraversalForSubtree);
                return false;
            }
             
        }
    }
}
