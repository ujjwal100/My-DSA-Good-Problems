public class Solution {
    /* Problem : Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
     * Link : https://www.interviewbit.com/problems/max-distance/
     * Note : This is not like inversion count problem as it wants the EXACT index difference. 
     *        On straightforward sorting, the indices will change, giving wrong answer.
     * Time : O(NlogN)
     * Space : O(N)
     */
    static class Pair {
        int val, index;
        Pair(int v, int i) {
            val = v;
            index = i;
        }
    }
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {
        List<Pair> nums = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            nums.add(new Pair(A.get(i), i));
        }

        Collections.sort(nums, (Pair a, Pair b) -> a.val - b.val);

        int ans = 0;
        int minIndex = nums.get(0).index;
        for (Pair p : nums) {
            ans = Math.max(ans, p.index - minIndex);
            minIndex = Math.min(minIndex, p.index);
        }
        return ans;
    }
}
