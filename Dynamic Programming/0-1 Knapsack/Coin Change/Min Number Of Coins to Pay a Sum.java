// Q -> Coin change -> Min no. of coins to pay a sum
// [1 2] sum = 3 -> 2

class Solution {
  int fun(int sum, int n) {
    if (sum == 0) return 0;
    if (n == 0) return Integer.MAX_VALUE;
    if (sum >= array[n - 1]) {
        int valIfTaken = fun(sum - array[n - 1]);
        if (valIfTaken != Integer.MAX_VALUE) {
          valifTaken++;
        }
        return Math.min(valIfTaken, fun(sum, n - 1)); 
    } else {
        return fun(sum, n - 1);
    }
  }
}
