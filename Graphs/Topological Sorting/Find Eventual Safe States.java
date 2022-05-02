/*
Q : https://leetcode.com/problems/find-eventual-safe-states/
TC : O(N)
SC : O(N)
*/
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] isSafe=new boolean[n];
        
        for (int i=0; i < n; i++) {
            if (!vis[i]) {
                isSafe(i, graph, vis, isSafe);
            }
        }
        
        List<Integer> safe = new ArrayList<>();
        for (int i=0; i < n; i++) {
            if (isSafe[i])
                safe.add(i);
        }
        
        return safe;
    }
    
    boolean isSafe(int source, int[][] graph, boolean[] vis, boolean[] isSafe) {
        vis[source] = true;
        boolean isSourceSafe=true;

        for (int adj : graph[source]) {
            if (!vis[adj]) {
                isSourceSafe &= isSafe(adj, graph, vis, isSafe);
            } else if (!isSafe[adj]) {
                isSourceSafe = false;
            }
        }

        return isSafe[source] = isSourceSafe;
    }
}
