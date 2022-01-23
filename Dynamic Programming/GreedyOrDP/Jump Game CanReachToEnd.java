// [3 3 1 0 4]
// maxReach = 0 + 3 = 3 == n  - 1?
// O(N) Time O(1) Space
public class Solution {
    public int canJump(ArrayList<Integer> A) {
        int maxReach = 0;
        int n = A.size();
        int i = 0;
        while (i < n) {
            if (maxReach >= n - 1) {
                return 1;
            }
            if (i > maxReach) {
                return 0;
            }
            maxReach = Math.max(maxReach, i + A.get(i));
            i++;
        }
        return 0;
    }
}
