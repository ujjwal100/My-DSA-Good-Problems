/*
Q : https://leetcode.com/problems/redundant-connection/
TC : O(E)
SC : O(V)
*/
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] ans = new int[2];
        
        DSU dsu = new DSU(edges.length + 1);
        
        for (int i = 1; i <= edges.length; i++) {
            dsu.makeSet(i);
        }
        
        for (int[] edge : edges) {
            if (dsu.findSet(edge[0]) == dsu.findSet(edge[1])) {
                ans[0] = edge[0];
                ans[1] = edge[1];
                return ans;
            } else {
                dsu.unionSet(edge[0], edge[1]);
            }
        }
        
        return ans;
    }
    
    static class DSU {
        int[] parent;
        int[] size;
        
        public DSU (int v) {
            parent = new int[v];
            size = new int[v];
        }
        
        void makeSet(int v) {
            parent[v] = v;
            size[v] = 1;
        }
        
        int findSet(int v) {
           if (v == parent[v]) {
               return v;
           }
            return parent[v] = findSet(parent[v]);
        }
        
        void unionSet(int v1, int v2) {
            int par1 = findSet(v1);
            int par2 = findSet(v2);
            
            if (size[par1] < size[par2]) {
                int temp = par1;
                par1 = par2;
                par2 = temp;
            }
            
            parent[par2] = par1;
            size[par1] += size[par2];
        }
    }
}
