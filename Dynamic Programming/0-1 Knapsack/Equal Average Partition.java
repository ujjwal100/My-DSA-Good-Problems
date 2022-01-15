// Question : Given an array A with non negative numbers, divide the array into two parts such that the average of both the parts is equal.
// Problem (HARD) : https://www.interviewbit.com/problems/equal-average-partition/
// LC Link : https://leetcode.com/problems/split-array-with-same-average/
// O(n * S * n) Time 
public class Solution {
    ArrayList<ArrayList<Integer>> answer;
    ArrayList<Integer> partition1, partition2;
    int[][][] dp;
    public ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> A) {
        int n = A.size();
        Collections.sort(A, Collections.reverseOrder()); // O(nlogn) time
        answer = new ArrayList<>();
        int totalsum = 0;
        for (int i : A) {
            totalsum += i;
        }
        partition1 = null;

        // O(n * S * n)
        for (int partition1Size = 1; partition1Size <= n - 1; partition1Size++) {
            if ((totalsum * partition1Size) % n == 0) {
                int partition1Sum = (totalsum * partition1Size) / n; 
                partition1 = null;

                dp = new int[partition1Sum + 1][partition1Size + 1][n + 1];
                for (int i = 0; i < partition1Sum + 1; i++) {
                    for (int j = 0; j < partition1Size + 1; j++) {
                        for (int k = 0; k < n + 1; k++) {
                            dp[i][j][k] = -1;
                        }
                    }
                }

                if (checkIfPartitionExists(A, partition1Sum, partition1Size, n, new ArrayList<Integer>()) == 1) {
                    partition2 = getPartition2(A);
                    answer.add(partition1);
                    answer.add(partition2);
                    return answer;
                }
            }
        }

        return answer;
    }

    // O(S*N) Time for this function
    private int checkIfPartitionExists(ArrayList<Integer> A, int S, int N, int n, ArrayList<Integer> result) {
        // if N == 0 && S==0 -> true
        // if N == 0 && S != 0 -> false
        // if S == 0 && N != 0 -> false
        if (N == 0 && S == 0) {
            updateAnswer(result);
            return 1;
        } else if (N == 0 || S == 0 || n == 0) {
            return 0;
        }

        if (dp[S][N][n] != -1) {
            return dp[S][N][n];
        }
        
        if (S >= A.get(n - 1)) {
            result.add(A.get(n-1));
            int taken = checkIfPartitionExists(A, S - A.get(n - 1), N - 1, n - 1, result);
            result.remove(result.size() - 1);
            int notTaken = checkIfPartitionExists(A, S, N, n - 1, result);
            return dp[S][N][n] = Math.max(taken, notTaken);
        } else {
            return dp[S][N][n] = checkIfPartitionExists(A, S, N, n - 1, result);
        }
    }

    private void updateAnswer(ArrayList<Integer> result) {
        if (partition1 == null || isLexSmallerThan(result, partition1)) {
            partition1 = new ArrayList<>(result);
        } 
    }

    private boolean isLexSmallerThan(ArrayList<Integer> a, ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < a.get(i)) {
                return false;
            }
        }

        return true;
    }

    private ArrayList<Integer> getPartition2(ArrayList<Integer> A) {
        ArrayList<Integer> partition2 = new ArrayList<>();
        // partition1 is sorted asc and A is sorted desc -> Use 2P for getting partition2
        int i = 0, j = A.size() - 1;
        while (i < partition1.size() && j >= 0) {
            if (A.get(j) == partition1.get(i)) {
                i++;
                j--;
            } else {
                partition2.add(A.get(j--));
            }
        }

        while (j >= 0) {
            partition2.add(A.get(j--));
        }

        return partition2;
    }
}
