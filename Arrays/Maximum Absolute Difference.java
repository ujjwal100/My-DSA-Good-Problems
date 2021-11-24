public class Solution {
    /*
     * Problem : You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N. 
     * f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
     *
     * Link : https://www.interviewbit.com/problems/maximum-absolute-difference/
     *
     * Hint : Remove the modulus and try simplifying the expression.
     *
     * O(N) Time + O(1) Space Solution
     */
    public int maxArr(ArrayList<Integer> A) {
        final int MAX = Integer.MAX_VALUE;
        final int MIN = Integer.MIN_VALUE;

        int maxIndexAdd = MIN; // Stores max (A[i] + i) value
        int minIndexAdd = MAX; // Stores min (A[i] + i) value
        int maxIndexDiff = MIN; // Stores max (A[i] - i) value
        int minIndexDiff = MAX; // Stores min (A[i] - i) value

        for (int i = 0; i < A.size(); i++) {
            maxIndexAdd = Math.max(maxIndexAdd, A.get(i) + i);
            minIndexAdd = Math.min(minIndexAdd, A.get(i) + i);

            maxIndexDiff = Math.max(maxIndexDiff, A.get(i) - i);
            minIndexDiff = Math.min(minIndexDiff, A.get(i) - i);
        }

        return Math.max( maxIndexAdd - minIndexAdd, maxIndexDiff - minIndexDiff);
    }
}
