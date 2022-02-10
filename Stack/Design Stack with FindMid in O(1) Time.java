// O(1) Time Implementation of Push(), Pop(), getMid(), deleteMid() in Stack
class ModifiedStack {
  static class ListNode {
    int data;
    ListNode next, prev;
    ListNode(int data) {
      this.data = data;
      next = prev = null;
    }
  }

  ListNode head, tail, mid;
  int length;

  ModifiedStack() {
    head = tail = mid = null;
  }

  void push(int data) {
      if (head == null) {
          head = tail = mid = new ListNode(data);
      } else {
          tail.next = new ListNode(data);
          tail.next.prev = tail;
          tail = tail.next;
      }
      length++;
      if (length > 1 && length % 2 != 0) {
        mid = mid.next;
      }
  }

  int pop() {
      if (length == 0) {
          return -1;
      } else {
          int value = tail.data;
          if (tail == head) {
          tail = head = mid = null;
      } else {
          tail = tail.prev;
          tail.next = null;
      }
      if (length > 1 && length % 2 != 0) {
          mid = mid.prev;
      }
      length--;
      return value;
      }
  }

  int getMiddle() {
      if (length < 1) {
          return -1;
      } else {
          return mid.data;
      }
  }

  void deleteMiddle() {
      if (length > 0) {
          // if mid == head
          if (length == 1) {
              head = tail = mid = null;
          } else if (length%2 == 0) { 
              // 1 2 3 4 : mid = 2 len = even -> mid++
              mid.prev.next = mid.next;
              mid = mid.next;
          } else {
              // 1 2 3  : mid = 2 len = odd mid--
              mid.prev.next = mid.next;
              mid = mid.prev;
          }
          length--;
          }
      } 
}
