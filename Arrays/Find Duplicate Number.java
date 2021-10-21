class Solution {
  // Q : Find Duplicate number (there can be multiple duplicates) in array of (n + 1) integers in O(N) T, O(1) S, without modifying array
  // Link https://leetcode.com/problems/find-the-duplicate-number/
  
    public int findDuplicate(int[] nums) {
        while (nums[0] != nums[nums[0]]) {
            int temp = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = temp;
        }
        
        return nums[0];
    }
}
