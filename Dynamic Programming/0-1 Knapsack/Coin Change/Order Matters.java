// Q -> Order matters -> [1 2]	
// sum = 5 -> [2 2 1] [2 1 2] [1 2 2] [1 1 1 1 1] [1 1 2] [1 2 1] [2 1 1] [1 1 1 2] [2 1 1 1]

// sum = 3 -> [1 2] [2 1] [1 1 1]

// O(n * S) time O(S) space for dp
class Solution {
  int getWays(int sum) {
    if (sum == 0) return 1;
    if (dp[sum] != -1) return dp[sum];
    int ans = 0;
    for (int i = n - 1; i >= 0; i--) {
      ans += getWays(sum - array[i], n);
    } 
      return dp[sum] = ans;
  }
}
