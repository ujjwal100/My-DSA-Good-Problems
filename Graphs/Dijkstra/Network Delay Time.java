// Problem : https://leetcode.com/problems/network-delay-time/
//
// O(N + ElogN) Time + O(N + E) Aux Space 
// N -> No. of Vertices, E -> no. of Connections
class Solution {
    static class Node {
        int value;
        int time;
        
        Node (int value, int time) {
            this.value = value;
            this.time = time;
        }
    }
    
    
    public int networkDelayTime(int[][] times, int n, int k) {
        // build graph
        
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] time : times) {
            graph.get(time[0]).add(new Node(time[1], time[2]));
        }
        
        // perform dijkstra
        
        int[] timeToReach = new int[n+1];
        Arrays.fill(timeToReach, Integer.MAX_VALUE);
        timeToReach[k] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>(n, (Node a, Node b) -> {
            return a.time - b.time;
        });
        
        pq.add(new Node(k, 0));
        
        while(!pq.isEmpty()) {
            int node = pq.peek().value;
            int time = pq.peek().time;
            
            pq.poll();
            
            for (Node adjacent: graph.get(node)) {
                if (time + adjacent.time < timeToReach[adjacent.value]) {
                    timeToReach[adjacent.value] = time + adjacent.time;
                    pq.add(new Node(adjacent.value, timeToReach[adjacent.value]));
                }
            }
        }
        
        int answer = 0;
        
        for (int i = 1; i < n+1; i++) {
            answer = Math.max(answer, timeToReach[i]);
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
