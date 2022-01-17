// O(n*n) time + O(n) space
class Solution{
    int[] dp;
    public int cutRod(int price[], int n) {
        //code here
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return getMaxPriceByLength(price, n);
    }
    
    private int getMaxPriceByLength(int price[], int n) {
        if (n == 0) {
            return 0;
        }
        
        if (dp[n] != -1) {
            return dp[n];
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, price[i] + getMaxPriceByLength(price, n - i - 1));
        }
        return dp[n] = answer;
    }
}
