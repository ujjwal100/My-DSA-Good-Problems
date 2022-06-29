/*
Q : https://leetcode.com/problems/maximum-length-of-pair-chain/
TC :O(NLogN)
SC : O(1)
*/
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (int[] pair1, int[] pair2) -> {
           return pair1[1] - pair2[1];
        });
        
        int ans=0;
        int lastVal = Integer.MIN_VALUE;
        
        for (int i =0; i < pairs.length; i++) {
            if (pairs[i][0] > lastVal) {
                lastVal = pairs[i][1];
                ans++;
            }
        }
        
        return ans;
    }
    
}
