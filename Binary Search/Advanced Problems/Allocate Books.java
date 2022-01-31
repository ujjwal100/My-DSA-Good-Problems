// O(NlogN) Time O(1) Space
public class Solution {
    public int books(ArrayList<Integer> A, int B) {
        // if B > n return -1 -> B <= n
        // min = min (A[i])
        // max = Sum of A[i]

        if (B > A.size()) return -1;

        int sumOfPages = 0;
        int minPages = Integer.MAX_VALUE;
        for (int pages : A) {
            sumOfPages += pages;
            minPages = Math.min(pages, minPages);
        }

        return getMinAllocation(A, minPages, sumOfPages, B);

    }

    private int getMinAllocation(ArrayList<Integer> A, int low, int high, int B) {
        int minTotalPagesPerHead = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossibleAllocation(A, mid, B)) {
                minTotalPagesPerHead = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            
        }

        return minTotalPagesPerHead;
    }

    private boolean isPossibleAllocation(ArrayList<Integer> A, int mid, int B) {
        int allocatedStudents = 0; 
        int sumOfPages = 0;

        // check allocation
        for (int book : A) {
            
            if (book > mid) {
                return false;
            } else {
                if (sumOfPages + book <= mid) {
                    sumOfPages += book;
                } else {
                    sumOfPages = book;
                    allocatedStudents++;
                }
            }
            
        }

        if (sumOfPages > 0) {
            allocatedStudents++;
        }

        
        return allocatedStudents <= B;

    }    
}
