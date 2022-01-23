// Problem : https://www.interviewbit.com/problems/min-jumps-array/
// O(N) Time O(1) space
public class Solution {
    public int jump(ArrayList<Integer> A) {
        int maxReach = 0;
        int n = A.size();
        int minJump = 0;
        int i = 0;
        int steps = 1;

        while (i < n) {
            if ( i > maxReach) {
                return -1;
            }

            maxReach = Math.max(maxReach, i + A.get(i));
            steps--;
            if (steps == 0) {
                if (maxReach > i) {
                    minJump++;
                    steps = maxReach - i;
                }
                
                if (maxReach >= n - 1) {
                    return minJump;
                }
            }
            i++;

        }


        return -1;
    }
}
