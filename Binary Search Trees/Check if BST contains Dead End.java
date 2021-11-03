class GFG
{
  // Problem : https://practice.geeksforgeeks.org/problems/check-whether-bst-contains-dead-end/1#   
  // O(N) Time + O(H) Space  
  public static boolean isDeadEnd(Node root)
    {
        //Add your code here.
        return isDeadEndHelper(root, 0, Integer.MAX_VALUE);
        
    }
    private static boolean isDeadEndHelper(Node root, int pred, int succ) {
        if (root == null) {
            return false;
        }
        
        if (root.left == null && root.right == null && pred == root.data - 1 && succ == root.data + 1) {
            return true;
        } else {
            return isDeadEndHelper(root.left, pred, root.data) || isDeadEndHelper(root.right, root.data, succ);
        }
    }
}
