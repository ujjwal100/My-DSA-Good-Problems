/*
Problem : https://leetcode.com/problems/snakes-and-ladders/
TC : O(N^2)
SC : O(N^2)
N -> dimension of Board
  */
class Solution {
    
    public int snakesAndLadders(int[][] board) {
        int start = 1;
        int n = board.length;
        HashSet<Integer> vis = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        
        q.add(start);
        vis.add(start);
        int moves =0;
        
        while (!q.isEmpty()) {
            int s = q.size();
            while (s-->0) {
            int curr = q.poll();
            if (curr == n * n) return moves;
            for (int k = 1; k <= 6; k++) {
                    int next = Math.min(curr + k, n*n);
                    int nextRow = getRow(next, n);
                    int nextCol = getCol(next, n);
                    if (board[nextRow][nextCol] !=-1) next = board[nextRow][nextCol];
                    if (!vis.contains(next)) {
                        vis.add(next);
                        q.add(next);
                    }
                }
            }
            
            moves++;
        }
        
        return -1;
    }
    
    int getRow(int curr, int n) {
        int r = (curr-1)/n;
        return n-1-r;
    }
    
    int getCol(int curr, int n) {
        int r = (curr-1)/n;
        int c = (curr-1)%n;
        
        return (r%2==0?c:(n-1-c));
    }
}
