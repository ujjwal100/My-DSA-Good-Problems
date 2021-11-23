public class Solution {
    // Problem Link : https://www.codingninjas.com/codestudio/problems/deletion-in-circular-linked-list_630409?leftPanelTab=0
    // O(N) Time + O(1) Space
    public static Node<Integer> deleteNode(Node<Integer> head, int key) {
        //Your code goes here
        if (head == null) {
        	return head;
        }
        
        Node<Integer> pointer = head, start = head; 
      
        if (head.data == key) {
        	if (head.next == head) { // important edge case for single-noded circular linked list
            	return null;
            } else {
            	head = head.next;
            }
        }
        
        do {
        	if (pointer.next.data == key) {
            	pointer.next = pointer.next.next;
              break;
            }
            pointer = pointer.next;
        } while(pointer != start);
        
        return head;
    }
}
