public class Solution {
  // Problem : https://www.interviewbit.com/problems/rotate-matrix/
  // O(N*N) Time + O(1) Space
	public void rotate(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        int step = n - 1;
        int iStart = 0, jStart = 0;
        int i, j;

        int curr, next;

        while (step > 0) {
            i = iStart;
            j = jStart;

            for (int count = 0; count < step; count++, j++) {
                curr = a.get(i).get(j);

                j = j + (step - count);
                i = i + count;

                next = a.get(i).get(j);
                a.get(i).set(j, curr);
                curr = next;


                i = i + (step - count);
                j = j - count; 

                next = a.get(i).get(j);
                a.get(i).set(j, curr);
                curr = next;


                j = j - (step - count);
                i = i - count;

                next = a.get(i).get(j);
                a.get(i).set(j, curr);
                curr = next;


                i = i - (step - count);
                j = j + count;

                next = a.get(i).get(j);
                a.get(i).set(j, curr);
                curr = next;

            }

            step -= 2;
            iStart++;
            jStart++;
        }
	}
}
