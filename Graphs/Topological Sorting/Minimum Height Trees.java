/*
Q : https://leetcode.com/problems/minimum-height-trees/
TC : O(N)
SC : O(N)

*/
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        int[] edgeCount = new int[n];
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            edgeCount[edge[0]]++;
            edgeCount[edge[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (edgeCount[i] == 0 || edgeCount[i] == 1) {
                q.add(i);
            }
        }
        
        while(!q.isEmpty()) {
            ans = new ArrayList<Integer>();
            int s = q.size();
            while(s-- > 0) {
                int node = q.poll();
                ans.add(node);
                for (int adj : graph.get(node)) {
                    edgeCount[adj]--;
                    if(edgeCount[adj] == 1) {
                       q.add(adj); 
                    }
                }
            }
        }
        
        return ans;
    }
    
}
