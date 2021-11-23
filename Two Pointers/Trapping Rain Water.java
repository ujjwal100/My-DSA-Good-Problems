public class Solution {
    // O(N) Time + O(1) Space
    public int trap(final List<Integer> A) {
        int l = 0, r = A.size() - 1;
        int lMax = 0, rMax = 0;
        int ans = 0;
        while (l < r) {
            lMax = Math.max(lMax, A.get(l));
            rMax = Math.max(rMax, A.get(r));
            ans += Math.min(lMax, rMax) - Math.min(A.get(l), A.get(r));
            if (A.get(l) < A.get(r)) {
                l++;
            } else {
                r--;
            }
        }

        return ans;
    }
}
