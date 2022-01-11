// Problem Link : https://www.interviewbit.com/problems/3-sum/
//O(N^2)Time O(1) Space
public class Solution {
    public int threeSumClosest(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int ans = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < A.size() - 2; i++) {
            int left = i + 1;
            int right = A.size() - 1;

            while (left < right) {
                int sum = A.get(i) + A.get(left) + A.get(right);
                if (Math.abs(B - sum) - 1 < diff) { // -1 added to convert -inf to inf, as Math.abs(-inf) != inf
                    diff = Math.abs(B - sum) - 1;
                    ans = sum;
                }
                if (sum == B) {
                    break;
                } else if (sum < B) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }
}
