public class Solution {
    // Problem (Uber, HARD) : Given an array A of positive integers,
    // call a (contiguous,not necessarily distinct) subarray of A good if the number of different integers in that subarray is exactly B.
    // Return the number of good subarrays of A.
    // 
    // Link : https://www.interviewbit.com/problems/subarrays-with-distinct-integers/
    // O(N) Time + O(N) Space
    public int solve(ArrayList<Integer> A, int B) {
        return getDistinctIntLessThanOrEqualToB(A, B) - getDistinctIntLessThanB(A, B);
    }

    private int getDistinctIntLessThanOrEqualToB(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> freq = new HashMap<>();
        int l = 0, r = 0;
        freq.put(A.get(l), 1);
        int count = 0;
        while (r < A.size()) {
            if ( freq.size() <= B) {
                count += r - l + 1;
                r++;
                if (r < A.size()) {
                    if (freq.get(A.get(r)) == null) {
                        freq.put(A.get(r), 1);
                    } else {
                        freq.put(A.get(r), freq.get(A.get(r)) + 1);
                    }
                }
            } else {
                if (freq.get(A.get(l)) == 1) {
                    freq.remove(A.get(l));
                } else {
                    freq.put(A.get(l), freq.get(A.get(l)) - 1);
                }
                l++;
            }
        }

        return count;
    }

    private int getDistinctIntLessThanB(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> freq = new HashMap<>();
        int l = 0, r = 0;
        freq.put(A.get(l), 1);
        int count = 0;
        while (r < A.size()) {
            if ( freq.size() < B) {
                count += r - l + 1;
                r++;
                if (r < A.size()) {
                    if (freq.get(A.get(r)) == null) {
                        freq.put(A.get(r), 1);
                    } else {
                        freq.put(A.get(r), freq.get(A.get(r)) + 1);
                    }
                }
            } else {
                if (freq.get(A.get(l)) == 1) {
                    freq.remove(A.get(l));
                } else {
                    freq.put(A.get(l), freq.get(A.get(l)) - 1);
                }
                l++;
            }
        }

        return count;
    }
}
