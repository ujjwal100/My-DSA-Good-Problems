// 5
//  \
//   3 // -5 + 3, 3
//    \
//     -10
//      \
//       5
// getRunningPathSum() -> from N to leaf max sum

// for each node N 
// -> curvedPathSum = N.val + L.sum + R.sum
// -> runningPathSum = max(N.val, max(L.sum, R.sum) + N.val) 
// answer = max(answer, max(runningPathSum, curvedPathSum))

// O(N) Time O(H) Space
class Solution {
    int answer;
    public int maxPathSum(TreeNode root) {
        answer = Integer.MIN_VALUE;
        getRunningPathSum(root);
        return answer;
    }
    
    private int getRunningPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int lSum = getRunningPathSum(root.left);
            int rSum = getRunningPathSum(root.right);
            
            int curvedPathSum = root.val +lSum + rSum;
            int runningPathSum = Math.max(root.val, root.val + Math.max(lSum, rSum));
            
            answer = Math.max(answer, Math.max(runningPathSum, curvedPathSum));
            
            return runningPathSum;
        }
    }
}
