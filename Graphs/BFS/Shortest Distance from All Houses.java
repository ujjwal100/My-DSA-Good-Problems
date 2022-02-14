// GOOGLE LC HARD Premium : https://leetcode.com/problems/shortest-distance-from-all-buildings/
//
//PROBLEM : You are given an m x n grid grid of values 0, 1, or 2, where:
// each 0 marks an empty land that you can pass by freely,
// each 1 marks a building that you cannot pass through, and
// each 2 marks an obstacle that you cannot pass through.
// You want to build a house on an empty land that reaches all buildings in the shortest total travel distance. You can only move up, down, left, and right.
// Return the shortest travel distance for such a house. If it is not possible to build such a house according to the above rules, return -1.
// The total travel distance is the sum of the distances between the houses of the friends and the meeting point.
//
// O((NM)^2) Time + O(NM) Aux Space
class Solution {
    static class Distance {
        int buildings;
        int distance;
    }
    
    static class Cell {
        int row, col;
        Cell(int r, int c) {
            row = r;
            col = c;
        }
    }
    
    public int shortestDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Distance[][] dist = new Distance[n][m];
        Queue<Cell> q = new LinkedList<>();
        int buildings =0;
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                dist[i][j] = new Distance();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    buildings++;
                    q.add(new Cell(i, j));
                    boolean[][] isVisited = new boolean[n][m];
                    
                    int level = 0;
        
                    while (!q.isEmpty()) {
                        level++;
                        int s = q.size(); {
                            while (s-- > 0) {
                                int row = q.peek().row;
                                int col = q.peek().col;
                                q.poll();

                                int[] rows = {0, 0, 1, -1};
                                int [] cols = {1, -1, 0, 0};
                                
                                for (int k = 0; k < 4; k++) {
                                    int newRow = row + rows[k];
                                    int newCol = col + cols[k];

                                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 0 && !isVisited[newRow][newCol]) {
                                        isVisited[newRow][newCol] = true;
                                        dist[newRow][newCol].buildings++;
                                        dist[newRow][newCol].distance += level;
                                        q.add(new Cell(newRow, newCol));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 && dist[i][j].buildings == buildings) {
                    answer = Math.min(answer, dist[i][j].distance);
                }
            }
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
        
    }
}
