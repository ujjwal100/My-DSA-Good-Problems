/*
Q : https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/
TC : O(L*Log(L))
SC : O(V)
*/
  
class Solution {
    public int earliestAcq(int[][] logs, int n) {
        DSU dsu = new DSU(n);
        Arrays.sort(logs, (a, b) -> {return a[0] - b[0];});
        for (int[]log : logs) {
            dsu.unionSet(log[1], log[2]);
            if (dsu.getSize(log[1]) == n) {
                return log[0];
            }
        }
        
        return -1;
    }
    
    static class DSU {
        int[] parent;
        int[] size;
        
        public DSU (int v) {
            parent = new int[v];
            size = new int[v];
            for (int i =0; i < v; i++) {
                makeSet(i);
            }
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
            if (par1 != par2) {
                if (size[par2] > size[par1]) {
                    int temp = par1;
                    par1=par2;
                    par2=temp;
                }
            
                parent[par2] = par1;
                size[par1] += size[par2];
            }
            
        }
        
        int getSize(int v) {
            return size[findSet(v)];
        }
    }
}
