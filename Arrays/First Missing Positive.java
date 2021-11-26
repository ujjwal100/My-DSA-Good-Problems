class Solution {
  // Q (LC - 41): Find MEX of unsorted array (can have multiple repeating instances of a number) in O(N) T, O(1) S
  // helper video : https://youtu.be/-lfHWWMmXXM
  
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                //swap
                int temp = nums[nums[i] - 1] ;
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }
        
        i = 0;
        while (i < n) {
            if (nums[i] != i+1) {
                return i+1;
            }
            i++;
        }
        return n + 1;
    }
  
  /*
   * ALTERNATE SOLUTION : Mark Index Negative
   * O(N) Time (3 Iterations) + O(1) Space
   */
  public int firstMissingPositiveAlternateMethod(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0 && Math.abs(nums[i]) <= n) {
                if (nums[Math.abs(nums[i]) - 1] > 0)
                    nums[Math.abs(nums[i]) - 1] *= (-1);
                else if (nums[Math.abs(nums[i]) - 1] == 0)
                    nums[Math.abs(nums[i]) - 1] = -(n + 1); 
            } 
        }
        
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }
        
        return n + 1;
    }
}
