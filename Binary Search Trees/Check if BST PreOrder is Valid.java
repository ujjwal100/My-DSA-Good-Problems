class Solution {
    // Problem : https://practice.geeksforgeeks.org/problems/preorder-traversal-and-bst4006/1/
    // O(N) Time + O(H) Space
    static int index;
    static int canRepresentBST(int arr[], int N) {
        // code here
        index = 0;
        return (isCorrectOrder(arr, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0);
    }
    
    static boolean isCorrectOrder(int[] preorder, int low, int high) {
        if (index >= preorder.length) {
            return true;
        }
        
        if (preorder[index] >= low && preorder[index] <= high) {
            int root = preorder[index++];
            return isCorrectOrder(preorder, low, root - 1) && isCorrectOrder(preorder, root + 1, high);
            
        } else if (preorder[index] < low) {
            return false;
        } else {
            return true;
        }
    }
}
