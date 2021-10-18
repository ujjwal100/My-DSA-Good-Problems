class Solution
{
    //Function to return the maximum sum of non-adjacent nodes.
    // Problem Link : https://practice.geeksforgeeks.org/problems/maximum-sum-of-non-adjacent-nodes/1/#
    // Time complexity : (DP Approach) : O(2N) ~ O(N) [ For Original Recursive Approach : O(4^N)] ; N = No. of Nodes in Bin Tree
    // Space Complexity : O(H)
    
    static Map<Node, Integer> maxSumRootAdded, maxSumRootNotAdded;
    
    public static int getMaxSum(Node root)
    {
        // add your code here
        maxSumRootAdded = new HashMap<>();
        maxSumRootNotAdded = new HashMap<>();
        return getMaxSumUtil(root, true);
    }
    
    private static int getMaxSumUtil(Node root, boolean flag) {
        if (root != null) {
            if (flag) {
                if (maxSumRootAdded.get(root) == null) {
                    //root added
                    int leftSum = getMaxSumUtil(root.left, !flag);
                    int rightSum = getMaxSumUtil(root.right, !flag);
                    int sumRootAdded = leftSum + rightSum + root.data;
                    
                    // root not added
                    leftSum = getMaxSumUtil(root.left, flag);
                    rightSum = getMaxSumUtil(root.right, flag);
                    int sumRootNotAdded = leftSum + rightSum;
                    
                    maxSumRootAdded.put(root, Math.max(sumRootAdded, sumRootNotAdded));
                }
                return maxSumRootAdded.get(root);
            } else {
                if (maxSumRootNotAdded.get(root) == null) {
                    int leftSum = getMaxSumUtil(root.left, !flag);
                    int rightSum = getMaxSumUtil(root.right, !flag);
                    maxSumRootNotAdded.put(root, leftSum + rightSum);
                }
                return maxSumRootNotAdded.get(root);
            }
        } else {
            return 0;
        }
    }
        
}
