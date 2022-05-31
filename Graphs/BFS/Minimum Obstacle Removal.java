/*
Q : https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/
TC : O(NM)
SC : O(NM)
*/
class Solution {
    public int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] obstacles = new int[n][m];
        for(int[] row : obstacles) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        obstacles[0][0] = 0;
        
        while (!q.isEmpty()) {
            int[] parent = q.poll();
            int parI = parent[0];
            int parJ = parent[1];
            
            int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}}; 
            
            for (int k = 0; k < 4; k++) {
                int i = parI + dir[k][0];
                int j = parJ + dir[k][1];
                
                if (i >= 0 && i < n && j >= 0 && j < m) {
                    int obs = obstacles[parI][parJ];
                    
                    if (grid[i][j] == 1) 
                        obs++;
                    if (obs < obstacles[i][j]) {
                        obstacles[i][j] = obs;
                        q.add(new int[]{i, j});
                    }
                }
            }
        }
        
        
        
        return obstacles[n-1][m-1];
    }
}
