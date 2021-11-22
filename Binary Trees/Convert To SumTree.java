class Solution{
    // O(N) Time + O(H) Space
    // Problem link : https://practice.geeksforgeeks.org/problems/transform-to-sum-tree/1
  
    public void toSumTree(Node root){
         //add code here. 
         toSumTreeUtil(root);
         }
         
     private int toSumTreeUtil(Node root) {
         if (root == null) {
             return 0;
         }
         
         int subtreeSum = toSumTreeUtil(root.left) + toSumTreeUtil(root.right);
         
         int ans = root.data + subtreeSum;
         
         root.data = subtreeSum;
         
         return ans;
     }     
}
