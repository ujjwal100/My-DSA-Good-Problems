import java.util.*;

public class Solution 
{
    public static int aggressiveCows(ArrayList<Integer> stalls, int k) 
    {
        //    Write your code here.
      int n = stalls.size();
      Collections.sort(stalls);
			int l = 1;
			int h = stalls.get(n - 1) - stalls.get(0);
			int ans = 1;

			while (l <= h) {
				int mid = l + (h - l) / 2;
				if (isPossibleAllocation(mid, k, stalls)) {
					ans = mid;
					l = mid + 1;
				} else {
					h = mid - 1;
				}
			}
        
        return ans;
    }
  
    private static boolean isPossibleAllocation(int dist, int totalCows, ArrayList<Integer> stalls) {
		int i = 0;
		int curr = stalls.get(0);
		int next;
		int cows = 1;

		while (i < stalls.size()) {
			next = stalls.get(i);
			if (next - curr >= dist) {
				curr = next;
				cows++;
			}
			i++;
		}

		return cows >= totalCows;
	}
}
