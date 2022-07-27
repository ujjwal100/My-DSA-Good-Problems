/*
LC (Google) : https://leetcode.com/problems/minimum-time-difference/
TC : O (NlogN)
SC : O(N)
*/

class Solution {
    static final int twentyFourHr = 24 * 60;
    
    public int findMinDifference(List<String> timePoints) {
        int ans = Integer.MAX_VALUE;
        List<Integer> timePointsMins = new ArrayList<>();
        
        timePoints.forEach((timePoint) -> {
            timePointsMins.add(getMins(timePoint));
        });
        
        Collections.sort(timePointsMins);
        
        for (int i = 0; i < timePointsMins.size() - 1; i++) {
            ans = Math.min(ans, timePointsMins.get(i+1) - timePointsMins.get(i));
        }
        
        int first = timePointsMins.get(0), last = timePointsMins.get(timePointsMins.size() - 1);
        
        ans = Math.min(ans, twentyFourHr - last + first);
        
        return ans;
    }
    
    
    int getMins(String timePoint) {
        String[] time = timePoint.split(":");
        return Integer.valueOf(time[0]) * 60 + Integer.valueOf(time[1]);
    }
}
