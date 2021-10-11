class Solution {
  /**
  * Problem Link : https://practice.geeksforgeeks.org/problems/duplicate-subtree-in-binary-tree/1#
  * Time Complexity of My solution : O(N)
  * Space Complexity : O(H)
  * (Google Interview Problem)
  */
    private static class HashedString {
        String hashVal;
        HashedString() {
            hashVal = "";
        }
    }
    
    int checkDuplicateSubTree(Node root) { 
        Map<String, Integer> map = new HashMap<>();
        
        if (hashSubTrees(root, new HashedString(), map)) {
            return 1;
        }
        
        return 0;
    }
    private boolean hashSubTrees(Node root, HashedString str, Map<String, Integer> map) {
        if (root == null) {
            str.hashVal = "$";
            return false;
        }
        
        HashedString leftSubTree = new HashedString();
        HashedString rightSubTree = new HashedString();
        
        if (hashSubTrees(root.left, leftSubTree, map) || hashSubTrees(root.right, rightSubTree, map)) {
            return true;
        }
        
        
        str.hashVal = "$" + root.data + "$" + leftSubTree.hashVal + rightSubTree.hashVal;
        
        if (root.left != null || root.right != null) { // If Non Leaf (subtree size > 1)
            if (map.containsKey(str.hashVal)) {
                return true;
            } else {
                map.put(str.hashVal, 1);
            }
            
        } 
        
        return false;
    }
}
