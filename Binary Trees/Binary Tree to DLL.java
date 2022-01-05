class Solution
{
    //Function to convert binary tree to doubly linked list and return it.
    // Problem : https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1#
    // O(N) Time + O(H) Space
    static class Predecessor {
        Node pointer;
    }
    Node head;
    Node bToDLL(Node root)
    {
	//  Your code here
	    constructDLL(root, new Predecessor());
	    return head;
    }
    
    private void constructDLL(Node root, Predecessor predecessor) {
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
}
