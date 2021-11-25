public class Solution {
    // Question : Given a read only array of n + 1 integers between 1 and n, 
    // find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.
    //
    // Link : https://www.interviewbit.com/problems/find-duplicate-in-array/
    // Note : Hare & Tortoise can't be used here as they use varaiable iterations and NOT CONSTANT [O(1)] iterations
    //
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int repeatedNumber(final List<Integer> A) {
        int n = A.size() - 1;
        int m = (int) Math.sqrt(n);
        int len = n/m + 1;
        int[] count = new int[len];

        for (int i = 0; i < A.size(); i++) {
            int pos = (A.get(i) - 1) / m;
            count[pos]++;
        }
        
        int i = 0;
        while (i < len) {
            if (count[i] > m) {
                break;
            }
            i++;
        }

        if (i == len) { // Edge Case : When the extra element is in the last block, with size of each block not exceeding m.
            i--;        // Example : N = 7, Array = [ 1, 2, 3, 4, 5, 6, 7, 7] Here m = root(N) = 2, len = n/m + 1 = 4
        }               // The blocks are [1, 2], [3, 4], [5, 6], [7, 7]. The duplicate element 7 is in last block. No Block size exceeds m. 

        int[] freq = new int[m];

        for (int num : A) {
            if ((num - 1) / m == i) {
                if (freq[num % m] > 0)
                    return num;
                freq[num % m]++;
            }
        }

        return -1;
    }
}
