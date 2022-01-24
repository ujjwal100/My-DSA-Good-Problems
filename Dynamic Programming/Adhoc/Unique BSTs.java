// for x in [1..A] 
//            x
//-> f(x - 1) *  f(A - x) 
// f(0) = 1
// f(1) = 1
// O(N^2) Time O(N) Space
public class Solution {
    int[]dp; // -> dp[x] means count of unique bsts with roots in [1..x]
    public int numTrees(int A) {
        dp = new int[A + 1];
        Arrays.fill(dp, -1);
        return getUniqueBSTCount(A);
    }

    private int getUniqueBSTCount(int num) {
        if (num == 0) {
            return 1;
        }
        if (num == 1) {
            return 1;
        }
        if (dp[num] != -1) {
            return dp[num];
        }

        int count = 0;
        for (int i = 1; i <= num; i++) {
            count += getUniqueBSTCount(i - 1) * getUniqueBSTCount(num - i);
        }

        return dp[num] = count;
    }
}
