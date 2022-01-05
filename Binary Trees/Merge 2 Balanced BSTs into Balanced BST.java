/*********************************************************

	Following is the TreeNode structure:

	class TreeNode<T> {
	    T data;
	    TreeNode<T> left;
	    TreeNode<T> right;

	    public TreeNode(T data) {
	        this.data = data;
	    }
	}

********************************************************/

public class Solution {
  // Poblem : https://www.codingninjas.com/codestudio/problems/h_920474?leftPanelTab=0
  // O(M + N) Time + O(max(log(M), log(N)) Space

   static TreeNode < Integer > mergeBST(TreeNode < Integer > root1, TreeNode < Integer > root2) {

      // Write your code here.
       return getDeserialisedTree(mergeDLLs(flattenTreeToDLL(root1), flattenTreeToDLL(root2)));
   }

    static class Predecessor {
        TreeNode< Integer > pointer;
    }
    static TreeNode< Integer > head;
    private static TreeNode< Integer > flattenTreeToDLL(TreeNode< Integer > root)
    {
	//  Your code here
        head = null;
	    constructDLL(root, new Predecessor());
	    return head;
    }
    
    private static void constructDLL(TreeNode< Integer > root, Predecessor predecessor) {
        if (root != null) {
            constructDLL(root.left, predecessor);
            
            if (predecessor.pointer != null) {
                predecessor.pointer.right = root;
                root.left = predecessor.pointer;
            } else {
                head = root;
            }
            
            predecessor.pointer = root;
            
            constructDLL(root.right, predecessor);
        }
    }
    
    private static TreeNode< Integer > mergeDLLs(TreeNode< Integer > head1, TreeNode< Integer > head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        } else {
            TreeNode< Integer > head = null, current = null, next = null;
            while (head1 != null && head2 != null) {
                if (head1.data <= head2.data ) {
                    next = head1;
                    head1 = head1.right;
                } else {
                    next = head2;
                    head2 = head2.right;
                }

                if (head == null) {
                    head = current = next;
                } else {
                    current.right = next;
                    next.left = current;
                    current = next;
                }
            }
            
            if (head1 != null) {
                current.right = head1;
                head1.left = current;
            }
            
            if (head2 != null) {
                current.right = head2;
                head2.left = current;
            }
            
            return head;
        }
    }
    
    private static TreeNode< Integer > getDeserialisedTree(TreeNode< Integer > root) {
        TreeNode< Integer > mid = getMiddleNode(root);
        if (mid.left != null) {
            mid.left.right = null;
            mid.left = getDeserialisedTree(root);
        }
        
        if (mid.right != null) {
            mid.right.left = null;
            mid.right = getDeserialisedTree(mid.right);
        }
        
        return mid;
    }
    
    private static TreeNode< Integer > getMiddleNode(TreeNode< Integer > head) {
        if (head == null || head.right == null) {
            return head;
        }
        
        TreeNode< Integer > slow = head, fast = head.right;
        while (fast != null && fast.right != null) {
            fast = fast.right.right;
            slow = slow.right;
        }
        
        return slow;
    }

}
