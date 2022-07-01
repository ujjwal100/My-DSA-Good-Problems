/*
 Q : https://leetcode.com/problems/out-of-boundary-paths/
 TC, SC : O(N*M*maxMoves)
 */
class Solution {
  
    final static int mod = (int)1e9 + 7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        return (int)getPaths(startRow, startColumn, m, n, maxMove, new Long[m][n][maxMove+1]);
    }
    
    long getPaths(int row, int col, int m, int n, int moves, Long[][][] dp) {
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 1;
        }
       
        
        if (dp[row][col][moves] != null) {
            return dp[row][col][moves];
        } 
        
       
        long ans = 0;
        
        if (moves > 0) {

            ans = (getPaths(row + 1, col, m, n, moves-1, dp)%mod + getPaths(row, col + 1, m, n, moves-1,  dp)%mod + getPaths(row-1, col, m, n, moves-1,  dp)%mod + getPaths(row, col-1, m, n, moves-1, dp)%mod)%mod;
        }
        
        return dp[row][col][moves] = ans;
        
    }
}
