class Solution {
  // O(N^2) DP Approach
  // Problem : https://www.geeksforgeeks.org/find-minimum-number-of-merge-operations-to-make-an-array-palindrome/
	
  public int minOperations(int[] arr) {
	int[][] dp = new int[arr.length][arr.length];
	return minCount(arr, 0, arr.length - 1, dp);
}
  
  private int minCount(int[] arr, int low, int high, int[][]dp) {
	if (low == high) {
	return 0;
	}
    
	if (arr[low] == arr[high]) {
	return dp[low][high] = minCount(arr, low + 1, high - 1, dp);
	}

	arr[low + 1] += arr[low];
	int alt1 = minCount(arr, low + 1, high, dp);
	arr[low + 1] -= arr[low];

	arr[high - 1] += arr[high];
	int alt2 = minCount(arr, low, high - 1, dp);
	arr[high - 1] -= arr[high];

	return dp[low][high] = 1 + Math.min(alt1, alt2);
  }

}
