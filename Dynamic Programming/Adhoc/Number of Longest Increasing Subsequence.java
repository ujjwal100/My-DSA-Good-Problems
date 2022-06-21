/*
Q : https://leetcode.com/problems/number-of-longest-increasing-subsequence/
TC : O(N^2)
SC : O(N^2)
*/
class Solution {
    public int findNumberOfLIS(int[] nums) {
       int n = nums.length;
        int[] lis = new int[n];
        int[] numLis = new int[n];
        
        int maxLis = 0, numMaxLis = 0;
        
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            numLis[i] += 1;
            
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (lis[i] < lis[j] + 1) {
                        lis[i] = lis[j] + 1;
                        numLis[i] = numLis[j];
                    } else if (lis[i] == lis[j] + 1) {
                        numLis[i] += numLis[j];
                    }
                }
            }
            
            
            if (lis[i] == maxLis) {
                numMaxLis += numLis[i];
            } else if (lis[i] > maxLis) {
                maxLis = lis[i];
                numMaxLis = numLis[i];
            }
        }
        
        return numMaxLis;
    }
}
