class Solution
{
    // Problem : https://practice.geeksforgeeks.org/problems/merge-two-bst-s/1#
    // O(M+N) Time + O(max(H1, H2)) Space
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    public List<Integer> merge(Node root1,Node root2)
    {
        // Write your code here
        List<Integer> answer = new ArrayList<>();
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        
        while (!stack1.isEmpty() || !stack2.isEmpty() || root1 != null || root2 != null) {
            
            while (root1 != null) {
                stack1.add(root1);
                root1 = root1.left;
            }
            
            while (root2 != null) {
                stack2.add(root2);
                root2 = root2.left;
            }
            
            Node next;
            
            if (stack1.isEmpty()) {
                next = stack2.pop();
                if (next.right != null) {
                    root2 = next.right;
                }
                
            } else if (stack2.isEmpty()) {
                next = stack1.pop();
                if (next.right != null) {
                    root1 = next.right;  
                }
                
            } else {
                if (stack1.peek().data <= stack2.peek().data) {
                    next = stack1.pop();
                    if (next.right != null) {
                        root1 = next.right;
                    }

                } else {
                    next = stack2.pop();
                    if (next.right != null) {
                        root2 = next.right;
            
                        
                    }
                }
            }
            
            
            answer.add(next.data);
            
        }
        
        return answer;
    }
}
