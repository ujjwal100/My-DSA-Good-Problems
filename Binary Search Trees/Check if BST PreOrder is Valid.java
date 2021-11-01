class Solution {
    // Problem : https://www.codingninjas.com/codestudio/problems/check-if-preorder-traversal-is-valid_1164410?leftPanelTab=0
    // O(N) Time + O(H) Space Solution 
    
    static int index;
    
    public boolean isPreorderValid(int[] preorder) {
        final int MIN = Integer.MIN_VALUE;
        final int MAX = Integer.MAX_VALUE;
        
        index = 0;
        
        return isPreorderValidHelper(preorder, MIN, MAX);
    }
    
    private boolean isPreorderValidHelper(int[] preorder, int lower, int upper) {
        if (index >= preorder.length) {
            return true;
        }
        
        int root = preorder[index];
        
        if (root < lower || root > upper) {
            return false;
        }
        
        index++;
        
        isPreorderValidHelper(preorder, lower, root - 1);
        
        return isPreorderValidHelper(preorder, root + 1, upper);
        
    }
}
