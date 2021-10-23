class Solution {
  // Q : Find Duplicate number (there can be multiple duplicates) in array of (n + 1) integers in O(N) T, O(1) S, without modifying array
  // Link https://leetcode.com/problems/find-the-duplicate-number/
  
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];
        
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        
        tortoise = nums[0];
        
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }
}
