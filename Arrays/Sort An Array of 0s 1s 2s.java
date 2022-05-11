/*
O(N) Time + O(1) Space

*/
class Solution {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        int i = 0;
        
        while (i <= r) {
            if (nums[l] == nums[i] && nums[i] == 0) {
                l++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                swap (nums, l++, i);
            } else {
                swap(nums, r--, i);
            }
        }
        
        
    }
    
    void swap(int[] nums, int a, int b) {
            int t = nums[a];
            nums[a] = nums[b];
            nums[b] = t;
        }
}
