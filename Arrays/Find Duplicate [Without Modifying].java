/*
// Q : https://leetcode.com/problems/find-the-duplicate-number/
O(N) TC + O(1) SC
*/
class Solution {
    public int findDuplicate(int[] arr) {
        int slow = 0, fast =0;
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);
        
        slow = 0;
        
        do {
            slow = arr[slow];
            fast = arr[fast];
        } while (slow != fast);
        
        return slow;
    }
}
