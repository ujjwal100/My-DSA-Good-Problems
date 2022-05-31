/*
Q : https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
TC : O(MNK)
SC : O(MNK)
*/
class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][][] = new boolean[n][m][k+1];
        
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{0, 0, k});
        int dist = 0;
        
        while (!q.isEmpty()) {
            int s = q.size();
            while (s-- > 0) {
                int[] cell = q.poll();
                int i = cell[0];
                int j = cell[1];
                int cellK = cell[2];
                
                if (i == n - 1 && j == m - 1) {
                    return dist;
                }
                
                int dir[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}};
                
                for (int d = 0; d < 4; d++) {
                    int x = i + dir[d][0];
                    int y = j + dir[d][1];
                    
                    if (x >= 0 && x < n && y >= 0 && y < m) {
                        int kVal = cellK;
                        if (grid[x][y] == 1) {
                            kVal--;
                        }
                        
                        if (kVal >= 0 && !vis[x][y][kVal]) {
                            vis[x][y][kVal] = true;
                            q.add(new int[]{x, y, kVal});
                        }
                    }
                }
            }
            dist++;
        }
        
        return -1;
    }
}
