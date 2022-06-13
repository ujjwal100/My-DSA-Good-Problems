/*
Q : https://leetcode.com/problems/max-consecutive-ones-iii/
TC : O(N)
SC : O(1)
*/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, zeroes = nums[r]==0?1:0, ans=0;    
        while (r < nums.length) {
            if (zeroes <= k) {
                ans = Math.max(ans, r - l + 1);
                r++;
                if (r < nums.length && nums[r] == 0) {
                    zeroes++;
                }
            } else {
                l++;
                if (nums[l-1] == 0) {
                    zeroes--;
                }
            }
        }
        
        return ans;
    }
}
