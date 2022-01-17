// Q -> Coin change -> Order does NOT matter
// [1, 2, 5, 10, 20, 50, 100..], sum = S

// sum = 5 -> [5] [2 2 1] [2 1 1 1]

// O(S*n) time + space
class Soluiton {
  int getWays(int sum, int n) {
    if (sum == 0) {
      return 1;
    }
    if (n == 0) {
      return 0;
    }
    if (sum >= array[n-1]) {
      return getWays(sum, n - 1) + getWays(sum - array[n - 1], n);
    } else {
      return getWays(sum, n - 1);
    }
  }
}

