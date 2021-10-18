public class Solution {    
    // Problem Link : https://www.codingninjas.com/codestudio/problems/kth-ancestor-of-a-node-in-binary-tree_842561
    // Time : O(N)
    // Space : O(H), NO AUXILIARY DATA STRUCTURE USED (Like array etc.)
    
    static class AncestorLevel {
        int level;
        AncestorLevel(int a) {
            level = a;
        }
    }
    
    static int findKthAncestor(BinaryTreeNode<Integer> root, int targetNodeVal, int kth) {
        // Write your code here.
        BinaryTreeNode<Integer> ancestor = findKthAncestorUtil(root, targetNodeVal, kth, new AncestorLevel(0));
        return (ancestor == null? -1 : ancestor.data);
    }
    
    static BinaryTreeNode<Integer> findKthAncestorUtil(BinaryTreeNode<Integer> root, int targetNodeVal, int kth, AncestorLevel ans) {
        if (root == null) {
             return root;
        }
        if (root.data == targetNodeVal) {
            ans.level++;
            return null;
        }
        BinaryTreeNode<Integer> leftAns = findKthAncestorUtil(root.left, targetNodeVal, kth, ans);
        if (leftAns != null) {
            return leftAns;
        } else if (ans.level > 0) {
            if (ans.level == kth) {
                return root;
            } else {
                ans.level++;
                return null;
            }
        } else {
            BinaryTreeNode<Integer> rightAns = findKthAncestorUtil(root.right, targetNodeVal, kth, ans);
            if (rightAns != null) {
                return rightAns;
            } else if (ans.level > 0) {
                if (ans.level == kth) {
                    return root;
                } else {
                    ans.level++;
                    return null;
                }
        	} else {
                return null;
            }
        }
    }
}
