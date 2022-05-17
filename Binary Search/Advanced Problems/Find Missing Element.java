/*
TC : O(logN)
SC : O(1)
*/
class Solution {
    public int missingElement(int[] nums, int k) {
        int l = 0, h = nums.length - 1, n = nums.length;
        while (l <= h) {
            int m = l + (h - l)/2;
            int missingCount = nums[m] - nums[l] - (m - l);
            if (k <= missingCount) {
                h = m - 1;
            } else if (m < n - 1 && nums[m+1] - nums[m] - 1 >= k - missingCount) {
                return nums[m] + k - missingCount;
            } 
            else {
                l = m + 1;
                if (l < n) k -= missingCount + nums[m+1]-nums[m] - 1;
            }
        }
        
   
        
        return  nums[h] + k;
    }
}
