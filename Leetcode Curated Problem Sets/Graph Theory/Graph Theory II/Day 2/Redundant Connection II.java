/*
Topic : Graph Theory - Union Find Application
Problem : https://leetcode.com/problems/redundant-connection-ii/
Difficulty : HARD
TC : O(E + V)
SC : O(V)
Helper Video : https://youtu.be/d0tqBMRZ6UQ
*/

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int nodes = edges.length + 1;
        int[] indegree = new int[nodes];
        
        int[] edge1 = null, edge2 = null;
        
        for (int[] edge : edges) {
            if (indegree[edge[1]] > 0) {
                edge1 = new int[]{indegree[edge[1]], edge[1]};
                edge2 = edge;
                break;
            } else {
               indegree[edge[1]] = edge[0]; 
            }
        }
        
        
        if (edge1 != null) {
            // case for 2 parents
            
            // remove edge2[] from edges and check if it works.
            int[][] edges2 = new int[edges.length - 1][2];
            int i = 0;
            for (int[] edge : edges) {
                if (edge[0] == edge2[0] && edge[1] == edge2[1]) {
                    continue; 
                } else {
                    edges2[i++] = edge;
                }
            }
            
            int[] ans = getRedundantConnectionFromCycle(edges2, nodes);
            if (ans[0] == -1) {
                return edge2;
            } else {
                return edge1;
            }
        } else {
            // case for cycle
            return getRedundantConnectionFromCycle(edges, nodes);
        }
        
        
    }
    
    int[] getRedundantConnectionFromCycle(int[][] edges, int nodes) {
        int[] ans = new int[2];
        ans[0]=ans[1]= -1;
        
        DSU dsu = new DSU(nodes + 1);
        
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
            
            
            parent[par2] = par1;
            size[par1] += size[par2];
        }
    }
}
