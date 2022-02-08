// Problem Link : https://leetcode.com/problems/cheapest-flights-within-k-stops/
//
// Brute force -> Backtracking -> O(N^M) , N = no of cities in route, M possible routes from each city
// final dst can be max K+1 level from src
//
// O(K * N) Time + O (K * N) Aux Space
class Solution {
    static class Pair {
        int node;
        int price;
        Pair(int node, int price) {
            this.node = node;
            this.price = price;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // form the graph
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] flight : flights) {
            graph.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
        
        // compute min cost
        
        int[][] dp = new int[k+2][n+1]; // dp[i][j] represents min cost of reaching node j in (i - 1) stops
        
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
            
        }
        
        dp[0][src] = 0;
        
        // level = 0  node = 0 dp-> 0 -> dp[level = 1][node = 1] = 100, dp[level = 1][node = 2] = 500
        // level = 1; node = 1 -> dp[level = 2][node = 2] = 100 + 100 = 200
        
        for (int level = 0; level <= k; level++) {
            for (int node = 0; node < n; node++) {
                if (dp[level][node] != Integer.MAX_VALUE) {
                    for (Pair adjacent : graph.get(node)) {
                        dp[level + 1][adjacent.node] = Math.min(dp[level + 1][adjacent.node], adjacent.price + dp[level][node]);
                    }
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i <= k + 1; i++) {
            answer = Math.min(answer, dp[i][dst]);
        }
        
        return answer == Integer.MAX_VALUE? -1 : answer;
        
    }
}
