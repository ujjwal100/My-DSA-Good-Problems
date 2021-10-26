class Solution {
  // O(H) Time & O(H) Space 
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.right != null && root.left != null) {
            // find inOrder Successor
            TreeNode inOrderSuccessor = findInOrderSuccessor(root.right);
            root.val = inOrderSuccessor.val;
            root.right = deleteNode(root.right, inOrderSuccessor.val);
            return root;
        } else if (root.right != null) {
            return root.right;
        } else if (root.left != null) {
            return root.left;
        } else {
            // if both null
            return null;
        }
        
    }
    
    private TreeNode findInOrderSuccessor(TreeNode root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
}
