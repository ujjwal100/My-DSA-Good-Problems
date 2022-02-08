// n = 6 [ 0 - 1 - 2 - 0   0 -> 3] [4] [5]
// if we have N conn components -> min answer = N - 1
// if no. of cycles in graph == N - 1 -> possible

// O(N + E) Time & Space
class Solution {
    public int makeConnected(int n, int[][] connections) {
        // make graph
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] connection : connections) {
            graph.get(connection[0]).add(connection[1]);
            graph.get(connection[1]).add(connection[0]);
        }
        
        
        
        // find connected components & cycles 
        
        int cycles = 0, components = 0;
        
        boolean[] isVisited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                cycles += getCycles(i, graph, isVisited, -1);
                components++;
            }
        }
        
        cycles /= 2;
        
        if (cycles >= components - 1) {
            return components - 1;
        } else {
             return -1;
        }
        
    }
    
    private int getCycles(int src, ArrayList<ArrayList<Integer>> graph, boolean[] isVisited, int parent) {
        int cycles = 0;
        isVisited[src] = true;
        
        for (int adjacent : graph.get(src)) {
            if (!isVisited[adjacent]) {
                cycles+= getCycles(adjacent, graph, isVisited, src);
            } else if (parent != adjacent) {
                cycles++;
            }
        }
        
        
        return cycles;
    }
}
