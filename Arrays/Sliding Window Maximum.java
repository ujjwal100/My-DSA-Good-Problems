// Problem : https://leetcode.com/problems/sliding-window-maximum/
// O(N) Time + O(N-K) Aux.Space
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> maxInWindow = new ArrayDeque<>();
        int index = 0;
        int maxIndex = 0;
        while (index < k) {
            if (nums[index] >= nums[maxIndex] ) {
                maxIndex = index;
            }
            index++;
        }
        
        maxInWindow.add(maxIndex);
        int left = 0;// -> beginning of window
        int[] answer = new int[nums.length - k + 1];
        answer[left] = nums[maxIndex];
        
        while (index < nums.length) {
            while (!maxInWindow.isEmpty() && nums[index] >= nums[maxInWindow.peekLast()]) {
                maxInWindow.removeLast();
            }
            maxInWindow.addLast(index);
            index++;
            if (left == maxInWindow.peekFirst()) {
                maxInWindow.removeFirst();
            }
            left++;
            answer[left] = nums[maxInWindow.peekFirst()];
        }
        
        return answer;
    }
}
