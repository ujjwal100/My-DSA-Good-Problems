// Problem : https://www.interviewbit.com/problems/distinct-subsequences/
// O(lenA * lenB) Time & Space
public class Solution {
    int[][]dp;
    public int numDistinct(String A, String B) {
        dp = new int[A.length() + 1][B.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getCount(A, B, A.length(), B.length());
    }

    private int getCount(String A, String B, int lenA, int lenB) {
        if (lenB == 0) {
            return 1;
        }

        if (lenA == 0) {
            return 0;
        }

        if (dp[lenA][lenB] != -1) {
            return dp[lenA][lenB];
        }

        dp[lenA][lenB] = 0;
        if (A.charAt(lenA - 1) == B.charAt(lenB - 1)) {
            dp[lenA][lenB] += getCount(A, B, lenA - 1, lenB - 1);
        }
        return dp[lenA][lenB] += getCount(A, B, lenA - 1, lenB);
 
    }
}
