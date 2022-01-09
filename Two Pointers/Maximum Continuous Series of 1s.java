public class Solution {
  // Problem : https://www.interviewbit.com/problems/max-continuous-series-of-1s/
  // // O(N) time O(N) space
    public ArrayList<Integer> maxone(ArrayList<Integer> A, int M) {
        int n = A.size();
        int[] oneCount = new int[n];
        int[] zeroCount = new int[n];

        for (int i = 0; i < n ; i++) {
            oneCount[i] = (A.get(i) == 1? 1 : 0) + (i == 0? 0 : oneCount[i - 1]);
            zeroCount[i] = (A.get(i) == 1? 0 : 1) +  (i == 0? 0 : zeroCount[i - 1]);
        }

        int start = 0, end = 0;
        int maxOnes = 0;

        int l = -1, r = 0;

        while (r < n) {
            int zeroes = zeroCount[r] - (l == -1? 0 : zeroCount[l]);
            int ones = oneCount[r] - (l == -1? 0 : oneCount[l]);

            if (zeroes <= M) {
                if (maxOnes < ones + zeroes) {
                    maxOnes = ones + zeroes;
                    start = l + 1;
                    end = r;
                }
                r++;
            } else {
                l++;
            }
        }

        
        ArrayList<Integer> maxOneSeries = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            maxOneSeries.add(i);
        }

        return maxOneSeries;

    }
}
