// Leetcode HARD Premium MICROSOFT Question
// Link : https://leetcode.com/problems/palindrome-removal/
// Given an integer array arr, in one move you can select a palindromic subarray arr[i], arr[i+1], ..., arr[j] where i <= j, 
// and remove that subarray from the given array. Note that after removing a subarray, 
// the elements on the left and on the right of that subarray move to fill the gap left by the removal.

// Return the minimum number of moves needed to remove all numbers from the array.
// Example 1:

// Input: arr = [1,2]
// Output: 2
// Example 2:

// Input: arr = [1,3,4,1,5]
// Output: 3
// Explanation: Remove [4] then remove [1,3,1] then remove [5].
  
// O(N^3) Time + O(N^2) DP 
class Solution {
    public int minimumMoves(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        
        for (int len = 1; len <= n; len++) {
            for (int start = 0; start <= n - len ; start++) {
                int end = start + len - 1;
                if (arr[start] == arr[end]) {
                    dp[start][end] = Math.max(1, ((start + 1 <= end - 1) ? dp[start+1][end-1] : 0));
                } else {
                    dp[start][end] = Integer.MAX_VALUE;
                    for (int k = start; k < end; k++) {
                        dp[start][end] = Math.min(dp[start][end], dp[start][k] + dp[k+1][end]);
                    }
                }
            }
        }
        
        return dp[0][n-1];
    }
}
