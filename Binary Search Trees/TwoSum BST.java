//Problem : https://www.interviewbit.com/problems/2sum-binary-tree/
// O(N) Time O(H) Space -> 2 Stacks
public class Solution {
    public int t2Sum(TreeNode A, int B) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        TreeNode pointer1 = A, pointer2 = A;
        while (pointer1 != null || pointer2 != null || !stack1.isEmpty() || !stack2.isEmpty()) {
            while (pointer1 != null) {
                stack1.add(pointer1);
                pointer1 = pointer1.left;
            }

            while (pointer2 != null) {
                stack2.add(pointer2);
                pointer2 = pointer2.right;
            }

            if (stack1.peek() == stack2.peek()) {
                return 0;
            } else if (stack1.peek().val + stack2.peek().val == B) {
                return 1;
            } else if (stack1.peek().val + stack2.peek().val < B) {
                // move left
                TreeNode leftPointer = stack1.pop();
                if (leftPointer.right != null) {
                    pointer1 = leftPointer.right;
                }
            } else {
                // move right
                TreeNode rightPointer = stack2.pop();
                if (rightPointer.left != null) {
                    pointer2 = rightPointer.left;
                }
            }
        }

        return 0;
    }
}
