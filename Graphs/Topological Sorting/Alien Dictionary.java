
//Problem Link : https://practice.geeksforgeeks.org/problems/alien-dictionary/1

// [baa, abcd, abca, cab, cad]
// baa , abcd -> b -> a
// abcd abca -> d -> a
// abca cab -> a -> c
// cab cad -> b -> d
// b -> d -> a -> c

// O(N * L + K) ~ O(N*L) Time  + O(K) Aux. Space
// L = Min. Length of each adjacent pair of words

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < K; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        // abc abcd -> cannot say
        
        for (int i = 0; i < dict.length - 1; i++) {
            for (int j = 0; j < Math.min(dict[i].length(), dict[i+1].length()); j++) {
                if (dict[i].charAt(j) != dict[i+1].charAt(j)) {
                    graph.get(dict[i].charAt(j) - 'a').add(dict[i+1].charAt(j) - 'a');
                    break;
                }
            }
        }
        
        int[] indegree = new int[K];
        
        for (int i = 0; i < K; i++) {
            for (int j : graph.get(i)) {
                indegree[j]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < K; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int count = 0;
        String answer = "";
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            answer += (char) (node + 'a');
            count++;
            
            for (int adjacent : graph.get(node)) {
                indegree[adjacent]--;
                if (indegree[adjacent] == 0) {
                    queue.add(adjacent);
                }
            }
            
        }
        
        if (count < K) {
            return ""; // cycle present -> no valid order
        }
        
        return answer;
        
    }
}
