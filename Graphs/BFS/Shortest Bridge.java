/*
LC-934 : https://leetcode.com/problems/shortest-bridge/

O(NM) TC + O(N+M) SC
*/
class Solution {
    static class Pair {
        int row, col;
        Pair(int r, int c) {
            row = r;
            col = c;
        }
    }
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<Pair> q = new LinkedList<Pair>();
        
        boolean foundIsland1 = false;
        for (int i = 0; i < n && !foundIsland1; i++)
            for (int j = 0; j < n && !foundIsland1; j++)
                if (grid[i][j] == 1) {
                    fetchIsland1(i, j, grid, q);
                   foundIsland1 = true;
                }
        
        

        int distance = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            distance++;
            while (size-- > 0) {
                int row = q.peek().row;
                int col = q.peek().col;
                q.poll();

                int[] dr = {0,0,1,-1};
                int[] dc = {1,-1,0,0};

                for (int k = 0; k < 4; k++) {
                    int row_ = row + dr[k];
                    int col_ = col + dc[k];
                    if (row_ >= 0 && row_ < n && col_ >= 0 && col_ < n) {
                        if (grid[row_][col_] == 1) {
                            return distance;

                        } else if (grid[row_][col_] == 0) {
                            grid[row_][col_] = 2;
                            q.add(new Pair(row_, col_));
                        }
                    }
                }
            }
            
            
        }
        
        return distance;
        
    }
    
    void fetchIsland1(int row, int col, int[][] grid, Queue<Pair> q) {
        int n = grid.length;
        if (row < 0 || row >= n || col < 0 || col >= n || grid[row][col] == 0 || grid[row][col] == 2) {
            return;
        }
        grid[row][col] = 2;
        q.add(new Pair(row, col));
        
        fetchIsland1(row+1, col, grid, q);
        fetchIsland1(row-1, col, grid, q);
        fetchIsland1(row, col+1, grid, q);
        fetchIsland1(row, col-1, grid, q);
    }
    
    
    
}
