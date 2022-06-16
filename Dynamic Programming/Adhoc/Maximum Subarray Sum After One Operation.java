/*
Q (LC Premium) : https://leetcode.com/problems/maximum-subarray-sum-after-one-operation/
Q.Link -> https://github.com/ujjwal100/LC-Premium/blob/main/Maximum%20Subarray%20Sum%20After%20One%20Operation.png
TC : O(N)
SC : O(N)
*/
class Solution {
    public int maxSumAfterOperation(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int dp[][] = new int[nums.length][2];
        
        // dp[i][0] -> means running subarray sum from {0..i} index where no index has been taken as nums[k] * nums[k]
        // dp[i][1] -> means running subarray sum from {0..i} index where exactly one index in {0..i} has been taken as nums[k] * nums[k]
        
        dp[0][0] = nums[0];
        dp[0][1] = nums[0] * nums[0];
        ans = Math.max(ans, Math.max(dp[0][0], dp[0][1]));
        
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0] + nums[i], nums[i]);
            dp[i][1] = Math.max(Math.max(dp[i-1][0] + nums[i] * nums[i], nums[i] * nums[i]), dp[i-1][1] + nums[i]);
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        
        return ans;
    }
}
