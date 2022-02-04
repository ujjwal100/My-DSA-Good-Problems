// Problem : https://www.interviewbit.com/problems/ways-to-decode/
// 
// O(lenA) Time & Space
public class Solution {
    final int mod = (int)1e9 + 7;
    public int numDecodings(String A) {
        int[] dp = new int[A.length() + 1];
        Arrays.fill(dp, -1);
        return getWaysToDecode(A, A.length(), dp);
    }

    private int getWaysToDecode(String A, int lenA, int[] dp) {
        if (lenA == 0) {
            return 1;
        }

        if (dp[lenA] != -1) {
            return dp[lenA];
        }

        int answer = 0;
        if (isDecodable(A.substring(lenA - 1, lenA))) {
            answer = (answer%mod + getWaysToDecode(A, lenA - 1, dp)%mod)%mod;
        } 

        if (lenA >= 2 && isDecodable(A.substring(lenA - 2, lenA))) {
            answer = (answer%mod + getWaysToDecode(A, lenA - 2, dp)%mod)%mod;
        }

        return dp[lenA] = answer;
    }

    private boolean isDecodable(String str) {
        // '1' -> ascii of 1 
        int number = 0;
        number += (int) str.charAt(str.length() - 1) - '0';

        if (str.length() > 1) {
           int digit = ((int) str.charAt(str.length() - 2) - '0');
            if (digit == 0) {
                return false; // 2nd last digit != 0 like in 06 != 6
            }
            number += digit * 10;
        }

        return number >= 1 && number <= 26;
    }
}
