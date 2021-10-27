class Solution {
// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
// O(N) Time O(H) Space Solution

    static int i;
    public TreeNode bstFromPreorder(int[] preorder) {
        i = 0;
        return buildBST(preorder, null);
    }
    private TreeNode buildBST(int[] preorder, TreeNode ancestor) {
        if (i >= preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[i]);
        i++;
        
        if (i < preorder.length && preorder[i] < root.val) {
            root.left = buildBST(preorder, root);
        }
        
        if (i < preorder.length && (ancestor == null || preorder[i] < ancestor.val) ) {
            root.right = buildBST(preorder, ancestor);
        }
        
        return root;
    }
}
