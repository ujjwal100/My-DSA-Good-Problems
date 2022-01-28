// Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area.
// https://www.interviewbit.com/problems/max-rectangle-in-binary-matrix/
// O(N^2) Time & Space
public class Solution {
    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        int[][] countOfOnesAlongCol = getCountOfOnesAlongCol(A);

        int maxArea = 0;

        for (int[] row : countOfOnesAlongCol) {
            maxArea = Math.max(maxArea, getMaxAreaFromHistogram(row));
        }

        return maxArea;
        
    }

    private int[][] getCountOfOnesAlongCol(ArrayList<ArrayList<Integer>> A) {
        int[][] countOfOnesAlongCol = new int[A.size()][A.get(0).size()];

        for (int col = 0; col < A.get(0).size(); col++) {
            int oneCount = 0;
            for (int row = 0; row < A.size(); row++) {
                if (A.get(row).get(col) == 1) {
                    oneCount++;
                } else {
                    oneCount = 0;
                }
                countOfOnesAlongCol[row][col] = oneCount;
            }
        }

        return countOfOnesAlongCol;
    }

    // O(N) Time O(N) Space
    private int getMaxAreaFromHistogram(int[] heights) {
        int n = heights.length;
        int[] nextSmaller = getNextSmallerIndices(heights);
        int[] prevSmaller = getPreviousSmallerIndices(heights);

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, (nextSmaller[i] - prevSmaller[i] - 1) * heights[i]);
        }

        return maxArea;
    }

    private int[] getPreviousSmallerIndices(int[] heights) {
        int n = heights.length;
        int[] prevSmaller = new int[n];

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < n) {
            if (stack.isEmpty()) {
                prevSmaller[i] = -1;
                stack.add(i++);
            } else if (heights[i] > heights[stack.peek()]) {
                prevSmaller[i] = stack.peek();
                stack.add(i++);
            } else {
                stack.pop();
            }
        }

        return prevSmaller;
    }

    private int[] getNextSmallerIndices (int[] heights) {
        int n = heights.length;
        int[] nextSmaller = new int[n];

        Stack<Integer> stack = new Stack<>();
        int i = n - 1;
        while (i >= 0) {
            if (stack.isEmpty()) {
                nextSmaller[i] = n;
                stack.add(i--);
            } else if (heights[i] > heights[stack.peek()]) {
                nextSmaller[i] = stack.peek();
                stack.add(i--);
            } else {
                stack.pop();
            }
        }

        return nextSmaller;
    }
}
