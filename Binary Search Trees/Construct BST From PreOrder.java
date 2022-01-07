class Solution {
// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
// O(N) Time O(H) Space Solution

    static int index;
    public TreeNode bstFromPreorder(int[] preorder) {
        index = 0;
        return getBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode getBST(int[] preorder, int low, int high) {
        if (index >= preorder.length || preorder[index] < low || preorder[index] > high) {
            return null;
        } else {
            TreeNode root = new TreeNode(preorder[index++]);
            
            root.left = getBST(preorder, low, root.val - 1);
            root.right = getBST(preorder, root.val + 1, high);
            
            return root;
        }
    }
}
