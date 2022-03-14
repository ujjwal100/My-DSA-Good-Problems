/*
LC-2203 (Weekly Contest) : Return the minimum weight of a subgraph of the graph such that 
                           it is possible to reach dest from both src1 and src2 via a set 
                           of edges of this subgraph. In case such a subgraph does not exist, 
                           return -1

Idea : ans = min { (dist from src1 to LCA) + (dist from src2 to LCA) + (dist from LCA to Dest) }

O(ElogV) Time + O(V+E) Space

*/

class Solution {
    static class E {
        int node;
        long cost;
        E (int d, long c){
            node = d;
            cost = c;
        }
    }
    
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        ArrayList<ArrayList<E>> graph = new ArrayList<>();
        ArrayList<ArrayList<E>> revGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            revGraph.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];
            int cost = edge[2];
            
            graph.get(src).add(new E(dst, cost));
            revGraph.get(dst).add(new E(src, cost));
            
        }
        
        long[] cost1 = new long[n];
        long INF = Long.MAX_VALUE;
        Arrays.fill(cost1, INF);
        
        getPath(src1, graph, cost1);
        
        long[] cost2 = new long[n];
        Arrays.fill(cost2, INF);
        getPath(src2, graph, cost2);
        
        if (cost1[dest] == INF || cost2[dest] == INF)
            return -1;
        else {
            
            long[] cost3 = new long[n];
            Arrays.fill(cost3, INF);
            getPath(dest, revGraph, cost3);
            
            long ans = INF;
            for (int lca = 0; lca < n; lca++)
                if (cost1[lca] != INF && cost2[lca] != INF && cost3[lca] != INF)
                ans = Math.min(ans, cost1[lca] + cost2[lca] + cost3[lca]);
            
            return ans;
            
            
        }
            
        
    }
    
    void getPath(int src, ArrayList<ArrayList<E>> graph, long[] cost) {
        PriorityQueue<E> pq = new PriorityQueue<>((E a, E b) -> {
            if (a.cost == b.cost)return 0;
            else if (a.cost > b.cost) return 1;
            else return -1;
        });
        
        
        cost[src] = 0;
        pq.add(new E(src, 0));
        
        
        while (!pq.isEmpty()) {
            int s = pq.peek().node;
            long scost = pq.peek().cost;
            pq.poll();
            
            if (scost > cost[s]) 
                continue;
            
            for (E adj : graph.get(s))
                if (cost[adj.node] > scost + adj.cost){
                    cost[adj.node] = scost + adj.cost;
                    pq.add(new E(adj.node, cost[adj.node]));
                }
            
        }
        
    }
    
    
}
