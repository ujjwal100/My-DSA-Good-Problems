/*
Q (LC premium) : https://leetcode.com/problems/tree-diameter/
Pic : https://github.com/ujjwal100/LC-Premium/blob/main/Tree%20Diamter.png
TC + SC : O(N)
*/
class Solution {
    static int ans;
    public int treeDiameter(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        boolean[] vis = new boolean[n];
        
        ans = 0;
        
        getDistFromLeaf(0, graph, vis);
        
        return ans;
    }
    
    int getDistFromLeaf(int src, List<List<Integer>> graph, boolean[] vis) {
        vis[src] = true;
        int max1=0, max2 = 0;
        for (int adj : graph.get(src)) {
            if (!vis[adj]) {
                int dist = 1 + getDistFromLeaf(adj, graph, vis);
                if (dist > max1) {
                    max2 = max1;
                    max1=dist;
                } else if (dist > max2) {
                    max2 = dist;
                }
            }
        }
        
        ans = Math.max(ans, max1 + max2);
        
        return max1;
    }
}
