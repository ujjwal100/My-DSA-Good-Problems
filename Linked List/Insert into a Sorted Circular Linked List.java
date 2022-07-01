/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/


/*
Q : https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/
TC: O(N)
SC : O(1)
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node insert = new Node(insertVal);
        insert.next = insert;
        if (head == null) {
            return insert;
        }
        
        Node largest= null, prev = head, curr = head.next;
        do {
            if (prev.val < insertVal && curr.val >= insertVal) {
                insert.next = curr;
                prev.next = insert;
                return head;
            }
            
            largest = (largest== null || largest.val <= curr.val ? curr : largest);
            
            prev = curr;
            curr = curr.next;
        } while (prev != head);
        
        insert.next = largest.next;
        largest.next = insert;
        return head;
    }
}
