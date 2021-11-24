public class Solution {
    // Problem : Given an array A of size N. You need to find the sum of Maximum and Minimum element 
    // in the given array in minimum no. of comparisons.
    // Link : https://www.interviewbit.com/problems/max-min-05542f2f-69aa-4253-9cc7-84eb7bf739c4/
    // O(N) Time + O(1) Space
    // No. of Comparisons = 3(N/2) - 2 { if N is EVEN }
    //                    = 3(N/2) - 3 { if N is ODD }
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int max, min;
        if (A.size() == 1) {
            return 2 * A.get(0);
        }

        if (A.get(0) > A.get(1)) {
            max = A.get(0);
            min = A.get(1);
        } else {
            max = A.get(1);
            min = A.get(0);
        }

        int i = 2;
        while (i < n - 1) {
            if (A.get(i) > A.get(i + 1)) {
                max = max > A.get(i) ? max : A.get(i);
                min = min < A.get(i + 1) ? min : A.get(i + 1);
            } else {
                max = max > A.get(i + 1) ? max : A.get(i + 1);
                min = min < A.get(i) ? min : A.get(i);
            }

            i+=2;
        }

        if (i < n) {
            max = max > A.get(i) ? max : A.get(i);
            min = min < A.get(i) ? min : A.get(i);
        }

        return min + max;
    }
}
