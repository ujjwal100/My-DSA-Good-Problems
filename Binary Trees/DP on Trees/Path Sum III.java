/*
Problem Link : https://leetcode.com/problems/path-sum-iii/

Problem : Given the root of a binary tree and an integer targetSum, return the number of paths 
where the sum of the values along the path equals targetSum. The path does not need to start or end at the root or a leaf, 
but it must go downwards (i.e., traveling only from parent nodes to child nodes).

O(N) TC + O(H) SC

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    static class Ans {
        int paths;
    }
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        Ans ans = new Ans();
        ans.paths = 0;
        getPaths(root, 0, targetSum, ans, freq);
        return ans.paths;
    }
    
    void getPaths(TreeNode root, int sum, int targetSum, Ans ans, HashMap<Integer, Integer> freq) {
        if (root != null) {
            sum += root.val;
            if (freq.containsKey(sum - targetSum)) {
                ans.paths += freq.get(sum - targetSum);
            }
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
            getPaths(root.left, sum, targetSum, ans, freq);
            getPaths(root.right, sum, targetSum, ans, freq);
            freq.put(sum, freq.get(sum) - 1);
        }
    } 
}
