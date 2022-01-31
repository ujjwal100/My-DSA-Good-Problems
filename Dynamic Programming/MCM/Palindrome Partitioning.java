// Problem Link : https://www.interviewbit.com/problems/palindrome-partitioning-ii/
//
// Question : Given a string A, partition A such that every substring of the partition is a palindrome.
// Return the minimum cuts needed for a palindrome partitioning of A.
//
// boolean[i][j] isPalindrome -> shows A[i,,,j] is palindrome
//  abba
//a 1001
//b _110 
//b __1_
//a ___1
// isPalindrome[i][j] = A[i] == A[j] && isPalindrome[i+1][j-1]
//
// O(N^2) Time & Space
public class Solution {
    public int minCut(String A) {
        int len = A.length();
        boolean isPalindrome[][] = new boolean[len][len];
        
        for (int wordLength = 1; wordLength <= len; wordLength++) {
            for (int i = 0; i < len; i++) { 
                int j = Math.min(len - 1, i + wordLength - 1);
                isPalindrome[i][j] = A.charAt(i) == A.charAt(j);
                if (i + 1 <= j - 1) {
                    isPalindrome[i][j] &= isPalindrome[i + 1][j - 1]; // if there are letters in between
                }
            }
        }

        int[] dp = new int[len + 1];
        Arrays.fill(dp, -1);

        return getMinCuts(A, len, isPalindrome, dp);
    }

    private int getMinCuts(String A, int len, boolean[][] isPalindrome, int[] dp) {
        if (len == 0) {
            return 0;
        }
        if (isPalindrome[0][len - 1]) {
            return 0;
        }

        if (dp[len] != -1) {
            return dp[len];
        }

        dp[len] = Integer.MAX_VALUE;

        for (int i = len - 1; i > 0; i--) {
            if (isPalindrome[i][len - 1]) {
                int minCutsForComplement = getMinCuts(A, i, isPalindrome, dp);
                if (minCutsForComplement != Integer.MAX_VALUE) {
                    dp[len] = Math.min(dp[len], 1 + minCutsForComplement);
                }
            }
        }

        return dp[len];
    }
}
