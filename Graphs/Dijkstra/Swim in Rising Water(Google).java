// Google LC Hard : https://leetcode.com/problems/swim-in-rising-water/
// O(N*N*logN) Time + O(N*N) Aux Space
class Solution {
    static class Cell {
        int row, col, minTime;
        Cell(int i, int j, int m) {
            row = i;
            col = j;
            minTime = m;
        }
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] minTime = new int[n][n];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                minTime[i][j] = Integer.MAX_VALUE;
            }
        }
        
        PriorityQueue<Cell> pq = new PriorityQueue<>((Cell a, Cell b) -> {
            return a.minTime - b.minTime;
        });
        
        pq.add(new Cell(0, 0, grid[0][0]));
        minTime[0][0] = grid[0][0];
        
        while (!pq.isEmpty()) {
            Cell source = pq.poll();
            int[] rowChange = {0, 0, -1, 1};
            int[] colChange = {-1, 1, 0, 0};
            for (int i = 0; i < 4; i++) {
                int row = rowChange[i] + source.row;
                int col = colChange[i] + source.col;
                if (row >= 0 && col >=0 && row < n && col < n  && minTime[row][col] > Math.max(grid[row][col], minTime[source.row][source.col])) {
                    minTime[row][col] = Math.max(grid[row][col], minTime[source.row][source.col]);
                    pq.add(new Cell(row, col, minTime[row][col]));
                }
            }
        }
        
        return minTime[n-1][n-1];
    }
}
        
