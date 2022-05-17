// Problem : https://www.interviewbit.com/problems/rotate-matrix/
// O(N^2) Time O(1) space
public class Solution {
	public void rotate(ArrayList<ArrayList<Integer>> a) {
		int n=matrix.size() , m=matrix[0].size();
		reverse(matrix.begin(),matrix.end());
		for(int i=0;i<n;i++)
			for(int j=i+1;j<m;j++)
				swap(matrix[i][j],matrix[j][i]);
	}
}
