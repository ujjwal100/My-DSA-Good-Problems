public class Solution {
    // Given an array A of N non-negative numbers and you are also given non-negative number B.
    // You need to find the number of subarrays in A having sum less than B. We may assume that there is no overflow.
    // Problem : https://www.interviewbit.com/problems/counting-subarrays/
    // O(N) Time + O(1) Space
    public int solve(ArrayList<Integer> A, int B) {
        int l = -1, r = 0, n = A.size();
        int ans = 0;

        for (int i = 1; i < n; i++) {
            A.set(i, A.get(i - 1) + A.get(i));
        }

        while (r < n && l < n) {
            int sum = A.get(r) - (l >= 0? A.get(l) : 0);
            if (sum < B) {
                ans += (r - l);
                r++;
            } else {
                l++;
            }
        }

        return ans;
    }
}
