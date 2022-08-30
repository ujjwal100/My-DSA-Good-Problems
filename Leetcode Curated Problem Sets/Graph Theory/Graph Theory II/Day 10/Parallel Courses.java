/*
Q : https://leetcode.com/problems/parallel-courses/
TC, SC : O(V + E)
*/
class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int[] relation : relations) {
            graph.get(relation[0] - 1).add(relation[1] - 1);
            indegree[relation[1] - 1]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        int sems = 0, coursesCovered = 0;
        while(!q.isEmpty()) {
            int s = q.size();
            sems++;
            
            while (s-- > 0) {
               int v = q.poll();
                coursesCovered++;
                for (int adj : graph.get(v)) {
                    indegree[adj]--;
                    if (indegree[adj] == 0) {
                        q.add(adj);
                    }
                }
            }
        }
        
        return coursesCovered == n? sems : -1;
        
    }
}
