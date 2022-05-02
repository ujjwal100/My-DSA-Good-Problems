/*
Q: https://www.interviewbit.com/problems/water-flow/

Problem: 
Given an N x M matrix A of non-negative integers representing the height of each unit cell in a continent, 
the "Blue lake" touches the left and top edges of the matrix and the "Red lake" touches the right and bottom edges.
Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the number of cells from where water can flow to both the Blue and Red lake.

TC : O(NM)
SC : O(NM)
*/
public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        boolean [][][] dp = new boolean[n][m][2];
        // [][][0] -> top, left,  
        // [][][1] -> bottom, right
        
        int ans =0;
        for (int i=0; i < n; i++)
        for (int j =0; j < m; j++)  {
            if (i==0 || j ==0) 
            dfs(i, j, 0, -1, A, dp);

            if (i==n-1 || j == m-1)
            dfs(i, j, 1, -1, A, dp);

        }

        for (int i=0; i < n; i++)
        for (int j =0; j < m; j++) 
        ans += dp[i][j][0] && dp[i][j][1]?1:0;

        return ans;

    }

    void dfs(int i, int j, int type, int par, ArrayList<ArrayList<Integer>> A, boolean [][][] visited) {
       if (i>=0 && i < A.size() && j >=0 && j < A.get(0).size() && !visited[i][j][type] && A.get(i).get(j) >= par) {
           visited[i][j][type] = true;
           dfs(i+1, j, type, A.get(i).get(j), A, visited);
           dfs(i-1, j, type, A.get(i).get(j), A, visited);
           dfs(i, j+1, type, A.get(i).get(j), A, visited);
           dfs(i, j-1, type, A.get(i).get(j), A, visited);
       }
    }
}
