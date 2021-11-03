
class Solution {
    
    // Return the size of the largest sub-tree which is also a BST
    // Problem : https://practice.geeksforgeeks.org/problems/largest-bst/1#
    // O(N) Time + O(H) Space
    
    static int answer;
  
    static class SubtreeInfo{
      boolean isBST = true;
      int size = 0;
      int minVal = Integer.MAX_VALUE;
      int maxVal = Integer.MIN_VALUE;
    }
    
  /* 
   * Helper function to get SubTree Info  
   */
  static SubtreeInfo getSubTreeInfo(Node root){
        if(root == null) {
            return new SubtreeInfo();
        }
            
        SubtreeInfo left = getSubTreeInfo(root.left);
        
        SubtreeInfo right = getSubTreeInfo(root.right);
        
        SubtreeInfo curr = new SubtreeInfo();
       
        if(left.isBST && right.isBST && root.data > left.maxVal && root.data < right.minVal) {
            
            curr.size = 1+ left.size + right.size;
            answer = Math.max(answer, curr.size);
            
            curr.minVal = Math.min(root.data, left.minVal);
            curr.maxVal = Math.max(root.data, right.maxVal);
        }
        else {
            curr.isBST = false;
        }
            
        return curr;
    }
  
    static int largestBst(Node root)
    {
        // Write your code here
        
        answer = 0;
        getSubTreeInfo(root);
        return answer;     
    }
    
}
