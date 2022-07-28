/*
Q : (LC Premium) : https://leetcode.com/problems/employee-free-time/
Q Pic : https://github.com/ujjwal100/LC-Premium/blob/main/Employee%20Free%20time.png
TC : Linear - Traversing all employee records once 
SC : Linear
*/

/* SOLUTION */

/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> nonFreeTimes;
        nonFreeTimes = schedule.get(0);
        for (int i = 1; i < schedule.size(); i++) {
            nonFreeTimes = addLists(nonFreeTimes, schedule.get(i));
        }
        
        nonFreeTimes = mergeIntervals(nonFreeTimes);
        
        List<Interval> freeTimes = new ArrayList<>();
        for (int i = 0; i < nonFreeTimes.size() - 1; i++) {
            freeTimes.add(new Interval(nonFreeTimes.get(i).end, nonFreeTimes.get(i+1).start));
        }
        return freeTimes;
    }
    
    private List<Interval> addLists(List<Interval> list1, List<Interval> list2) {
        // [1 4] [5 7]
        // [2 5] [6 8]
        int i = 0, j = 0;
        
        List<Interval> mergedList = new ArrayList<>();
        Interval curr;
        
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).start < list2.get(j).start) {
                    curr = list1.get(i++);
                } else if (list2.get(j).start < list1.get(i).start) {
                    curr = list2.get(j++);
                } else {
                    curr = list1.get(i).end <= list2.get(j).end ? list1.get(i++) : list2.get(j++);
                }
            mergedList.add(curr);
            
        }
        while (i < list1.size()) {
            mergedList.add(list1.get(i++));
            
        }
        
        while (j < list2.size()) {
            mergedList.add(list2.get(j++));
            
        }
        
        return mergedList;
    }
    
    private List<Interval> mergeIntervals(List<Interval> list) {
        List<Interval> ans = new ArrayList<>();
        int s = list.get(0).start;
        int e = list.get(0).end;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).start > e) {
                ans.add(new Interval(s, e));
                s = list.get(i).start;
                e = list.get(i).end;
            } else {
                e = Math.max(list.get(i).end, e);
            }
        }
        ans.add(new Interval(s, e));
        return ans;
    }
}
