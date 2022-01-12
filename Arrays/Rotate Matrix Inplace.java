// Problem : https://www.interviewbit.com/problems/rotate-matrix/
// Observation : total shift i + j = dim - 1
// Observation : ORDER:  [j++,i++] -> [i++,j--] -> [j--,i--] -> [i--,j++]
// O(N^2) Time O(1) space
public class Solution {
	public void rotate(ArrayList<ArrayList<Integer>> a) {
        int dimension = a.size();
        int startRowCol = 0;
        int endRowCol = a.size() - 1;

        while (dimension > 0) {
            int i = startRowCol, j = startRowCol;

            int counter = 1;
            while (counter++ < dimension) {
                
                int curr = a.get(i).get(j);

                i += (dimension - 1) - (endRowCol - j); // total shift = dim - 1
                j = endRowCol;

                int next = a.get(i).get(j);
                a.get(i).set(j, curr);
                curr = next;

                j -= (dimension - 1) - (endRowCol - i);
                i = endRowCol;

                next = a.get(i).get(j);
                a.get(i).set(j, curr);
                curr = next;

                i -= (dimension - 1) - (j - startRowCol);
                j = startRowCol;

                next = a.get(i).get(j);
                a.get(i).set(j, curr);
                curr = next;

                j += (dimension - 1) - (i - startRowCol);
                i = startRowCol;
                
                a.get(i).set(j, curr);
                j++;
            }

            startRowCol++;
            endRowCol--;
            dimension -= 2;
        }
	}
}
