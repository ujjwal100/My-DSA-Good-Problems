// LC Problem : https://leetcode.com/problems/3sum/
// O(N^2) TC + O(1) SC
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i =0;i < nums.length; i++) {
            if (i !=0 && nums[i] == nums[i-1]) {
                continue;
            }
            getTwoSum(-1 * nums[i], i, nums, ans);

        }
        return ans;
        
    }
    
    void getTwoSum(int target, int currIndex, int[] nums, List<List<Integer>> ans) {
        int left = currIndex+1, right = nums.length - 1;
        
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                
                ans.add(new ArrayList<>(List.of(nums[currIndex], nums[left], nums[right])));
                
                while (left + 1 < right && nums[left + 1]==nums[left]) {
                    left++;
                }
                left++;
                
                while (right > left && nums[right - 1] == nums[right]) {
                    right--;
                }
                right--;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        } 
    }
}
