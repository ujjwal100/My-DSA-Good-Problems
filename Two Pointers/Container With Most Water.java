public class Solution {
    // Problem Link : https://www.interviewbit.com/problems/container-with-most-water/
    // O(N) Time + O(1) Space
    public int maxArea(ArrayList<Integer> A) {
        int i = 0, j = A.size() - 1, area = 0;
        while (i < j) {
            area = Math.max(area, (j - i)* Math.min(A.get(i), A.get(j)));
            if (A.get(i) < A.get(j)) {
                i++;
            } else {
                j--;
            }
        }

        return area;
    }
}
