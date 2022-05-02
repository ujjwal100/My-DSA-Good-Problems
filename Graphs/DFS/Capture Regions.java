/*
Q: https://www.interviewbit.com/problems/capture-regions-on-board/

Problem :
Given a 2D character matrix A of size N x M, containing 'X' and 'O', capture all regions surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.

TC : O(NM)
SC : O(NM)

*/
public class Solution {
	public void solve(ArrayList<ArrayList<Character>> a) {
        int n = a.size();
        int m = a.get(0).size();
        for (int i=0; i<n; i++) 
        for (int j=0; j < m; j++)
        if (i==0 || i == n-1 || j ==0 || j == m-1){
            if (a.get(i).get(j) == 'O') {
            dfs(i, j, a, 'O', '#');
            }
        }


        for (int i=0; i<n; i++)
        for (int j=0; j < m; j++)
        if (a.get(i).get(j) == 'O') {
            a.get(i).set(j, 'X');
        }
            


        for (int i=0; i<n; i++)
        for (int j=0; j < m; j++)
        if (a.get(i).get(j)=='#')
        a.get(i).set(j, 'O');



	}

    void dfs(int i, int j, ArrayList<ArrayList<Character>> a, char from, char to) {
        if (i >=0 && j >=0 && i < a.size() && j < a.get(0).size() && a.get(i).get(j)==from) {
            a.get(i).set(j, to);
            dfs(i+1, j, a, from, to);
            dfs(i-1, j, a, from, to);
            dfs(i, j+1, a, from, to);
            dfs(i, j-1, a, from, to);
        }
    }
}
