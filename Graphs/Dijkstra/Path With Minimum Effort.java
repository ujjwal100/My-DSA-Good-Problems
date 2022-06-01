/*
Q (Google) : https://leetcode.com/problems/path-with-minimum-effort/
O(MNlogMN) TC
O(MN) SC
*/
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] efforts = new int[n][m];
        for (int[] row : efforts) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> {
            return a[0] - b[0];
        });
        
        pq.add(new int[]{0, 0, 0});
        efforts[0][0] = 0;
        
        while (!pq.isEmpty()) {
            int effort = pq.peek()[0];
            int parI = pq.peek()[1];
            int parJ = pq.poll()[2];
            
            if (effort > efforts[parI][parJ]) {
                continue;
            }
            
            int[][] dir = {{0, 1}, {0,-1}, {1,0}, {-1,0}};
            for (int k = 0; k < 4; k++) {
                int i = parI + dir[k][0];
                int j = parJ + dir[k][1];
               
                if (i >= 0 && i < n && j >=0 && j < m) {
                    int minEffort = Math.max(effort, Math.abs(heights[i][j] - heights[parI][parJ]));
                    if (efforts[i][j] > minEffort) {
                        efforts[i][j] = minEffort;
                        pq.add(new int[]{minEffort, i, j});
                    }
                }
            }
        }
        
        return efforts[n-1][m-1];
        
    }
}
