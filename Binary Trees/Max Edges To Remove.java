//       1
//     / | \
//     2  3  4
//    /\    /\
//    7 8  5 6
//    /       \
//    9        10
// if subtree node count is even -> remove the subtree
//  any node -> getTotalChildren() -> if even -> count++
//  n/2 - 1

// O(A) Time + O(A) Space
// Problem : https://www.interviewbit.com/problems/maximum-edge-removal/
public class Solution {
    int edges;
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        edges = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (ArrayList<Integer> edge : B) {
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }
        Set<Integer> visited = new HashSet<>();
        getTotalChildren(1, graph, visited);

        return edges;
    }

    private int getTotalChildren(int source, ArrayList<ArrayList<Integer>> graph, Set<Integer> visited) {
        visited.add(source);
        int children = 0;
        for (int child : graph.get(source)) {
            if (!visited.contains(child)) {
                int subtreeNodeCount = getTotalChildren(child, graph, visited);
                if (subtreeNodeCount %2 == 0) {
                    edges++;
                }
                children+= subtreeNodeCount;
            }
        }
        return children + 1;
    }
}
