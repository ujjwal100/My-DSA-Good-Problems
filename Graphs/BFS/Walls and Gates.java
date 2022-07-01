/* 
Q : https://leetcode.com/problems/walls-and-gates/
TC+ SC : O(MN)
*/
class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }
        
        while (!q.isEmpty()) {
            int[] gate = q.poll();
                int[][] adjs = {{gate[0]+1, gate[1]}, {gate[0]-1, gate[1]}, {gate[0], gate[1]+1}, {gate[0], gate[1]-1}};
                for (int[] adj : adjs) {
                    if (adj[0] >= 0 && adj[0] < rooms.length && adj[1] >=0 && adj[1] < rooms[0].length && rooms[adj[0]][adj[1]] > 1 + rooms[gate[0]][gate[1]]) {
                        rooms[adj[0]][adj[1]] = 1 + rooms[gate[0]][gate[1]];
                        q.add(new int[]{adj[0], adj[1]});
                    }
                }
        }
    }
}
