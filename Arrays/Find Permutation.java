public class Solution {
    /**
      * Given a positive integer n and a string s consisting only of letters D or I, 
      * you have to find any permutation of first n positive integer that satisfy the given input string.
      * D means the next number is smaller, while I means the next number is greater.
      *
      * Problem Link : https://www.interviewbit.com/problems/find-permutation/
      * 
      * O(N) Time + O(N) Space
      */
    public ArrayList<Integer> findPerm(final String A, int B) {
        int n = A.length() + 1;

        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        int l = 0, r = n - 1;

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'D') {
                answer.add(nums.get(r--));
            } else {
                answer.add(nums.get(l++));
            }
        }

        answer.add(nums.get(l));

        return answer;
    }
}
