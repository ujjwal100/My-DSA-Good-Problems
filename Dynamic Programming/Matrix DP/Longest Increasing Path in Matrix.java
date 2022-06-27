class Solution { 
  /*
  Q (LC-Google) : https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
  TC : O(NM)
  SC : O(NM)
  
  */
  public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        
        
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, getLongestPath(i, j, 1, matrix, dp));
            }
        }
        return ans;
    }
    
    int getLongestPath(int i, int j, int val, int[][] matrix, int[][] dp) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
            int[][] dir = {{i + 1, j}, {i - 1, j}, {i, j + 1}, {i, j - 1}};
            
            int ans = 1;
            
            for (int k =0; k < 4; k++) {
                int x = dir[k][0];
                int y = dir[k][1];
                
                if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && matrix[x][y] > matrix[i][j] ) {
                    ans = Math.max(ans, 1 + getLongestPath(x, y, val + 1, matrix, dp));
                }
            }
        
        return dp[i][j] = ans;
    }
}
