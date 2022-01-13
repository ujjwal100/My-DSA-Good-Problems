
// Problem Link : https://www.codingninjas.com/codestudio/problems/kth-ancestor-of-a-node-in-binary-tree_842561
// O(N) Time O(H) Space
//
// Algo :
// getHeightFromTargetNode() -> x -> if x = 0 if node not found
// x = 1 if node = targetNode 
// x = Math.max(left , right) -> if x == k, mark root.val as answer else if x != 0 -> return x+1 else return 0
public class Solution {
    static int answer;
    static int findKthAncestor(BinaryTreeNode<Integer> root, int targetNodeVal, int kth) {
        // Write your code here.
        answer = -1;
        getHeightFromTargetNode(root, targetNodeVal, kth);
        return answer;
    }
    static int getHeightFromTargetNode(BinaryTreeNode<Integer> root, int targetNodeVal, int kth) {
        if (root!= null) {
            if (root.data == targetNodeVal) {
                return 1;
            } else {
                int heightFromTarget = Math.max(getHeightFromTargetNode(root.left, targetNodeVal, kth), getHeightFromTargetNode(root.right, targetNodeVal, kth));
                
                if (heightFromTarget > 0) {
                    if (heightFromTarget == kth) {
                    	answer = root.data;
                	} 
                    return heightFromTarget + 1;
                } else {
                    return 0;
                }
            }
        } else {
            return 0;
        }
    }
}   
