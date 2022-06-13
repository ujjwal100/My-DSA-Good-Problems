/*
Q : https://leetcode.com/problems/wiggle-subsequence/
TC : O(N)
SC : O(N)
*/
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[][] wiggle = new int[n][2]; 
        // wiggle[i][0] -> longest length of wiggle sequence in [0..i] index-range, nums[i] > nums[i-1]
        // wiggle[i][1] -> longest length of wiggle sequence in [0..i] index-range, nums[i] < nums[i-1]
        
        for (int[] row : wiggle) {
            Arrays.fill(row, 1);
        }
        
        int ans = 1;
        
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i-1]) {
                wiggle[i][0] = 1 + wiggle[i-1][1];
                wiggle[i][1] = wiggle[i-1][1];
            } else if (nums[i] < nums[i-1]) {
                wiggle[i][1] = 1 + wiggle[i-1][0];
                wiggle[i][0] = wiggle[i-1][0];
            } else {
                wiggle[i][0] = wiggle[i-1][0];
                wiggle[i][1] = wiggle[i-1][1];
            }
        }
        
        ans = Math.max(wiggle[n-1][0], wiggle[n-1][1]);
        
        return ans;
    }
}
