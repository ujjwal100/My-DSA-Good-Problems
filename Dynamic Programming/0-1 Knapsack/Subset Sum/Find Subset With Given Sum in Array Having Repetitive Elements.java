// Q -> Count unique subsets with subset-sum = S // repetitive elements

// array = [1 1 2 3 4 5 ]

// if S = 4 -> [1 1 2] [1 3] [4] 
// if S = 6 -> [1 5] [2 4] [1 2 3] [1 1 4]

class Solution {
  int[] array; // input
  public int getUniqueSubsets(int sum) {
    Arrays.sort(array);
    return getCount(sum, array.length);
  }

  private int getCount(int sum, int n) {
    if (sum >= array[n - 1]) {
      int ans1 = getCount(sum - array[n - 1], n - 1);
      int element = array[n - 1];
      while (n > 0 && array[n - 1] == element) {
        n--;
    }
    int ans2 = getCount(sum, n);
    return ans1 + ans2;
    } else {
      return getCount(sum, n - 1);
    }
  }
}
