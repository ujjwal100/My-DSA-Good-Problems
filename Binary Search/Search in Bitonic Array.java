public class Solution {
    // Q : Find a number B in Arraylist A, which is first strictly increasing & then strictly decreasing (Bitonic)
    // Problem link : https://www.interviewbit.com/problems/search-in-bitonic-array/
    // O(logN)
    
    public int solve(ArrayList<Integer> A, int B) {
        int bitonicPoint = getBitonicPoint(A, 0, A.size() - 1);

        int ans1 = binSearchIncArray(A, 0, bitonicPoint, B);

        if (ans1 != -1) {
            return ans1;
        }

        return binSearchDescArray(A, bitonicPoint + 1, A.size() - 1, B);
    }

    private int getBitonicPoint(ArrayList<Integer> A, int low, int high) {
        int mid = low + (high - low) / 2;

        if (mid == 0) {
            return -1;
        } else if (mid == A.size() - 1) {
            return mid;
        }
        else {
            if (A.get(mid) > A.get(mid - 1) && A.get(mid) > A.get(mid + 1)) {
                return mid;
            } else if (A.get(mid) > A.get(mid - 1)) {
                return getBitonicPoint(A, mid + 1, high);
            } else {
                return getBitonicPoint(A, low, mid - 1);
            }
        }
    }

    private int binSearchIncArray(ArrayList<Integer> A, int low, int high, int B) {
        if (low > high) {
            return -1;
        } else {
            int mid = low + (high - low) / 2;
            if (A.get(mid) == B) {
                return mid;
            } else if (B > A.get(mid)) {
                return binSearchIncArray(A, mid + 1, high, B);
            } else {
                return binSearchIncArray(A, low, mid - 1, B);
            }
        }
    }

    private int binSearchDescArray(ArrayList<Integer> A, int low, int high, int B) {
        if (low > high) {
            return -1;
        } else {
            int mid = low + (high - low) / 2;

            if (A.get(mid) == B) {
                return mid;
            } else if (B > A.get(mid)) {
                return binSearchDescArray(A, low, mid - 1, B);
            } else {
                return binSearchDescArray(A, mid + 1, high, B);
            }
        }
    }
}
