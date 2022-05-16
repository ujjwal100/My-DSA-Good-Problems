// O(logN) TC + O(1) SC
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, l = 0 , h = m * n - 1;
        
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int r = mid/n;
            int c = mid % n;
            if (matrix[r][c] == target) return true;
            else if (matrix[r][c] > target) h = mid - 1;
            else l = mid + 1;
        }
        
        return false;
    }
}
