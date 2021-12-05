public class Solution {
  
    // Problem : Given a 2D integer matrix A of size N x N 
    // Find a B x B submatrix where B<= N and B>= 1, such that sum of all the elements in submatrix is maximum.
    //
    // Problem Link : https://www.interviewbit.com/problems/maximum-sum-square-submatrix/
    // O(N*N) Time + O(N*N) Space
    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        return getSubMatrixSum(getRowSum(A, B), getColSum(A, B), A, B); 
    }

    private int[][] getRowSum(ArrayList<ArrayList<Integer>> A, int B) {
        int N = A.size();
        
        int[][] rowSum = new int [N][N-B+1];

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < B; j++) {
                sum += A.get(i).get(j);
            }
            rowSum[i][0] = sum;
            for (int j = 1; j <= N-B; j++) {
                rowSum[i][j] = rowSum[i][j-1] - A.get(i).get(j-1) + A.get(i).get(j + B - 1);
            }
        }

        return rowSum;
        
    }

    private int[][] getColSum(ArrayList<ArrayList<Integer>> A, int B) {
        int N = A.size();
        int[][] colSum = new int [N-B+1][N];

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int c = 0; c < B; c++) {
                sum += A.get(c).get(i);
            }
            colSum[0][i] = sum;
            for (int j = 1; j <= N-B; j++) {
                colSum[j][i] = colSum[j-1][i] - A.get(j-1).get(i) + A.get(j + B - 1).get(i);
            }
        }

        return colSum;
    }

    private int getSubMatrixSum(int[][] rowSum, int[][] colSum, ArrayList<ArrayList<Integer>> A, int B) {
        int N = A.size();
        int[][] subMatrixSum = new int [N-B+1][N-B+1];

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < B; i++) {
            subMatrixSum[0][0] += colSum[0][i];
        }

        for (int i = 0; i <= N-B; i++) {
            if (i > 0) {
                subMatrixSum[i][0] = subMatrixSum[i-1][0] - rowSum[i-1][0] + rowSum[i+B-1][0];
            }
            ans = Math.max(ans, subMatrixSum[i][0]);

            for (int j = 1; j <= N-B; j++) {
                subMatrixSum[i][j] = subMatrixSum[i][j-1] - colSum[i][j-1] + colSum[i][j+B-1];
                ans = Math.max(ans, subMatrixSum[i][j]);
            }
        }

        return ans;

    }
}
