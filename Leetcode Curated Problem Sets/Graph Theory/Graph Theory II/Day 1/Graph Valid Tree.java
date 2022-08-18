/*
Q : https://leetcode.com/problems/graph-valid-tree/
Link : https://tinyurl.com/graph-valid-tree
TC : O(E + V)
SC : O(E + V)
*/

class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        
        boolean answer = isValidTree(0, graph, visited, -1);
        
        if (answer) {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    answer = false;
                }
            }
        }
        
        return answer;
    }
    
    boolean isValidTree(int source, List<List<Integer>> graph, boolean[] visited, int parent) {
        visited[source] = true;
        boolean isValid = true;
        for (int adj : graph.get(source)) {
            if (!visited[adj]) {
                isValid &= isValidTree(adj, graph, visited, source);
            } else if (adj != parent) {
                return false;
            }
        }
        return isValid;
    }
}
