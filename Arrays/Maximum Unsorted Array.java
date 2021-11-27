public class Solution {
    /**
      * Problem : You are given an array (zero indexed) of N non-negative integers, A0, A1 ,…, AN-1.
      * Find the minimum sub array Al, Al+1 ,…, Ar so that if we sort(in ascending order) that sub array, then the whole array should get sorted.
      *
      * Link : https://www.interviewbit.com/problems/maximum-unsorted-subarray/
      * 
      * O(N) Time + O(1) Space
      */
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> answer = new ArrayList<>();
        int i, j;
        int n = A.size();

        for (i = 0; i < n - 1; i++) {
            if (A.get(i) > A.get(i + 1)) {
                break;
            }
        }
        if (i == n - 1) {
            answer.add(-1);
            return answer;
        }

        int min = A.get(i+1);
        for (int c = i+1; c < n; c++) {
            min = Math.min(min, A.get(c));
        }

        int l = getCeil(min, A, 0, i);

        for (j = n - 1; j > 0; j--) {
            if (A.get(j) < A.get(j - 1)) {
                break;
            }
        }

        int max = A.get(j - 1);

        for (int c = j - 1; c >= 0; c--) {
            max = Math.max(max, A.get(c));
        }

        int r = getFloor(max, A, j, n - 1);

        answer.add(l);
        answer.add(r);
        return answer;
    }

    private int getCeil(int key, ArrayList<Integer> A, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A.get(mid) > key && (mid == 0 || A.get(mid - 1) <= key)) {
                return mid;
            } else if (A.get(mid) > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private int getFloor(int key, ArrayList<Integer> A, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A.get(mid) < key && (mid == A.size() - 1 || A.get(mid + 1) >= key)) {
                return mid;
            } else if (A.get(mid) < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
