public class Solution {
    // Problem : https://www.interviewbit.com/problems/capacity-to-ship-packages-within-b-days/
    // O(NlogN) Time + O(1) Space
    public int solve(ArrayList<Integer> A, int B) {
        int totalWeight = 0;
        for (int weight : A) {
            totalWeight += weight;
        }
        return getMinWeight(A, B, 1, totalWeight);
    }

    private int getMinWeight(ArrayList<Integer> A, int B, int low, int high) {
        int minWeight = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int days = getDaysToShip(A, mid);

            if (days > B) {
                low = mid + 1;
            } else {
                minWeight = Math.min(minWeight, mid);
                high = mid - 1;
            }
        }
        return minWeight;
    }

    private int getDaysToShip(ArrayList<Integer> A, int capacity) {
        int days = 0;
        int sum = 0;
        for (int weight : A) {
            if (weight > capacity) {
                return Integer.MAX_VALUE;
            }

            sum += weight;
            if (sum > capacity) {
                sum = weight;
                days++;
            }

        }
        days++;
        return days;

    }
}
