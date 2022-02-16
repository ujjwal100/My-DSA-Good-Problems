// GOOGLE LC Premium : https://leetcode.com/problems/find-leaves-of-binary-tree/
//
// Problem : Given the root of a binary tree, collect a tree's nodes as if you were doing this:
//     Collect all the leaf nodes.
//     Remove all the leaf nodes.
//     Repeat until the tree is empty.

/*
  2  level = 1
  /\
 4 5 -> level = 0
*/
// O(N) Time + O(H) Aux Space
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        getLevel(root, answer);
        return answer;
    }
    
    private int getLevel(TreeNode root, List<List<Integer>> answer) {
        if (root == null) {
            return -1;
        }
        int currentLevel = 1 + Math.max(getLevel(root.left, answer), getLevel(root.right, answer));
        if (answer.size() <= currentLevel) {
            answer.add(new ArrayList<>());
        }
        answer.get(currentLevel).add(root.val);
        return currentLevel;
    }
}
