// Problem Link : https://www.interviewbit.com/problems/smallest-sequence-with-given-primes/
// O(N) Time + Space
// Helper Video : https://www.youtube.com/watch?v=rRn1vBH-L-8
public class Solution {
    public ArrayList<Integer> solve(int A, int B, int C, int D) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        int i = 0, j = 0, k = 0;
        while (D-- > 0) { 
            int option1 = ans.get(i) * A;
            int option2 = ans.get(j) * B;
            int option3 = ans.get(k) * C;

            int min = Math.min(option1, Math.min(option2, option3));

            ans.add(min);

            if (min == option1) i++;
            if (min == option2) j++;
            if (min == option3) k++;
        }

        ans.remove(0); // remove 1 from beginning 
        return ans;
    }
}
