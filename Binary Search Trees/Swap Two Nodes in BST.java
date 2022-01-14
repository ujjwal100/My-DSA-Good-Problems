// Problem : https://leetcode.com/problems/recover-binary-search-tree/
// O(N) Time + O(H) Space
//
// Original Tree
//    10
//    /\
//   5  15
//  /\   \
//  2 8  25  

// first mid last
// Case I 
//    10
//    /\
//   15 5
//  /\   \
//  2 8  25  first = 15 mid = 8 last = 5 -> swap (15, 5) -> first with last

// Case II
//    10
//    /\
//   5  25
//  /\   \
//  2 8  15  first = 25 mid = 15 last = null -> swap (25, 15) -> first with mid
class Solution {
    TreeNode first, mid, last, prev;
    public void recoverTree(TreeNode root) {
        first = mid = last = prev = null;
        inorder(root);
        
        if (last != null) {
            swap(first, last);
        } else {
            swap(first, mid);
        }
    }
    
    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            if (prev != null && root.val < prev.val) {
                if (first == null) {
                    first = prev; // 3
                    mid = root; // 2
                } else {
                    last = root; // 1
                }
                // System.out.println(prev.val);
            }
            prev = root;
            inorder(root.right);
        }
    }
    
    private void swap (TreeNode x, TreeNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}
