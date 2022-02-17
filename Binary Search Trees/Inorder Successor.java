// LC Premium : https://leetcode.com/problems/inorder-successor-in-bst/
// Given the root of a binary search tree and a node p in it, return the in-order successor of that node in the BST. 
// If the given node has no in-order successor in the tree, return null.

// O(H) Time & O(1) Space
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
             return null;
        }
        
        return getInorderSuccessor(root, p, null);
    }
    
    private TreeNode getInorderSuccessor(TreeNode root, TreeNode p, TreeNode successor) {
        
        while (root != null) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
        return successor;
    }
}
