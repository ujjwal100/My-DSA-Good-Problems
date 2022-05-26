/*
Q: https://leetcode.com/problems/divide-chocolate/
LC-Prem Link : https://github.com/ujjwal100/LC-Premium/blob/main/Divide%20Chocolate.png
TC : O(NlogM) 
SC : O(1) 
*/
class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int ans = -1;
        int low = Integer.MAX_VALUE, high = 0;
        
        for (int val : sweetness) {
            high += val;
            low = Math.min(low, val);
        }
        
        
        while (low <= high) {
            int limit = low + (high - low) / 2;
            int total = 0, sum = 0;
            int i;
            for (i=0; i < sweetness.length; i++) {
                sum += sweetness[i];
                if (sum >= limit) {
                    sum=0;total++;
                } 
            }
            
            
            if (total < k + 1) {
                high = limit - 1;
            } else {
                ans = Math.max(ans, limit);
                low = limit + 1;
            }
        }
        
        return ans;
        
    }
}
