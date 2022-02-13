// GOOGLE Question (IBit) Link : https://www.interviewbit.com/problems/rod-cutting/
// O(N^3) Time + O(N^2) Aux Space
//
// Points to Note :
// 1. As in the problem N goes up to 10^9, So instead of operating directly on N, we operate on n = No. of Partitions = size of the paritions(cuts) array 
// (which is much smaller than 10^9 and supports O(n^3) operation.)
//
// 2. We could have directly stored the required order array along with min cost in dp. But storing the full Array everytime causes MLE.
// So we instead store the partition indices along with min cost in dp and back-calculate to get the order.
//
public class Solution {
    static class Cost {
        long cost;
        int partition;

        Cost(long c, int p) {
            cost = c;
            partition = p;
        }
    }

    public ArrayList<Integer> rodCut(int N, ArrayList<Integer> cuts) {
        ArrayList<Integer> cutPoints = new ArrayList<>();
        cutPoints.add(0);
        cutPoints.addAll(cuts);
        cutPoints.add(N);
        Collections.sort(cutPoints);

        int n = cutPoints.size();

        Cost[][] dp = new Cost[n+1][n+1];
        for (Cost[] vector : dp) {
            Arrays.fill(vector, null);
        }


        getMinCost(0, n - 1, cutPoints, dp);
        ArrayList<Integer> answer = new ArrayList<>();

        getOrder(0, n - 1, cutPoints, dp, answer);

        return answer;
    }

    private Cost getMinCost(int start, int end, ArrayList<Integer> cutPoints, Cost[][] dp) {

        if (dp[start][end] != null) {
            return dp[start][end];
        }

        Cost answer = new Cost(0, -1);

        ArrayList<Cost> costs = new ArrayList<>();

        long minCost = Long.MAX_VALUE;

        for (int i = start + 1; i <= end - 1; i++) {
                Cost leftCost = getMinCost(start, i, cutPoints, dp);
                Cost rightCost = getMinCost(i, end, cutPoints, dp);
                long cost = leftCost.cost + rightCost.cost + cutPoints.get(end) - cutPoints.get(start);
                minCost = Math.min(minCost, cost);
                costs.add(new Cost(cost, i));
        }

        for (Cost cost : costs) {
            if (cost.cost == minCost) {
                answer = cost;
                break;
            }
        }

        dp[start][end] = answer;

        return answer;
    }

    private void getOrder( int start, int end, ArrayList<Integer> cutPoints, Cost[][] dp, ArrayList<Integer> order) {
        if (dp[start][end].cost != 0) {
            int k = dp[start][end].partition;
            order.add(cutPoints.get(k));
            getOrder(start, k, cutPoints, dp, order);
            getOrder(k, end, cutPoints, dp, order);
        }
    }
}
