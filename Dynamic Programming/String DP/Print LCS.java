class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
		char[] A = {'A', 'B', 'C'};
		char[] B = {'A','X','B','Y','A','Z','C'};
		int n = A.length;
		int m = B.length;
		int[][] dp = new int[n + 1][m + 1];
		String lcs = "";
		
		
		// First find LCS :
		for (int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if (A[i - 1] == B[j - 1]) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				}
		
			dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j], dp[i][j - 1]));
			}
		}
		
		System.out.println(dp[n][m]);
    
    // PRINT LCS

		int i = n, j = m;

		while (i > 0 && j > 0) {
			int max = 0;
			if (A[i - 1] == B[j - 1]) {
				max = dp[i - 1][j - 1] + 1;
			}
			max = Math.max(max, Math.max(dp[i - 1][j], dp[i][j - 1]));
			if (A[i-1] == B[j-1] && max == dp[i - 1][j - 1] + 1) {
				lcs += A[i - 1];
				i--;
				j--;
			} else if (max == dp[i -1][j]) {
				i--;
			} else {
				j--;
			}
		} 
    
		System.out.println(lcs);

	}
}

