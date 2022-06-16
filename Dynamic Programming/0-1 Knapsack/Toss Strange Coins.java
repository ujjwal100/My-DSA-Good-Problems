/*
Q (LC - Premium) : https://leetcode.com/problems/toss-strange-coins/
Q : https://github.com/ujjwal100/LC-Premium/blob/main/Toss%20Strange%20Coins.png
TC + SC : O(N^2)
*/
class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        int n = prob.length;
        return prob(n, target, new Double[n+1][target+1], prob);
    }
    
    double prob(int n, int target, Double[][] dp, double[] prob) {
        if (n == 0) {
            if (target == 0) {
                 return 1;
            } else {
                return 0;
            }
        }
        
        if (dp[n][target] != null) {
            return dp[n][target];
        }
        
        
        double ans = (1 - prob[n-1]) * prob(n-1, target, dp, prob);
        if (target > 0) {
            ans += prob[n-1] * prob(n-1, target - 1, dp, prob);
        }
        
        return dp[n][target] = ans;
    } 
}
