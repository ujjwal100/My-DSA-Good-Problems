/*
Q (Google) : https://leetcode.com/problems/shortest-way-to-form-string/
TC : O(NM)
SC : O(N)
*/
class Solution {
    public int shortestWay(String source, String target) {
        int ans = getMinCount(source.toCharArray(), target.toCharArray(), 0, new Integer[target.length()]);
        return (ans == Integer.MAX_VALUE? -1 : ans);
    }
    
    int getMinCount(char[] source, char[] target, int start, Integer[] dp) {
        if (start >= target.length) {
            return 0;
        }
        
        if (dp[start] != null) {
            return dp[start];
        }
        
        int ans = Integer.MAX_VALUE;
        int i = 0, j = start;
        while (i < source.length && j < target.length) {
            if (source[i] == target[j]) {
                j++;
                int nextCount = getMinCount(source, target, j, dp);
                if (nextCount != Integer.MAX_VALUE) {
                    ans = Math.min(ans, 1 + nextCount);
                }
            } 
            
            i++;
        }
        
        return dp[start] = ans;
    }
}
