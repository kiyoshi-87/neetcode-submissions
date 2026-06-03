/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }

        int count = 1;

        ListNode t1 = head;
        ListNode t2;

        while(t1.next != null) {
            t1 = t1.next;
            count++;
        }

        int index = count - n + 1; 

        if (index == 1) {
            return head.next;
        }

        t1 = head;
        count = 1;

        while (count != index-1) {
            t1 = t1.next;
            count++;
        }

        t2 = t1.next;

        ListNode t3 = t2.next != null ? t2.next : null;
        
        t2.next = null;
        t1.next = t3;
        
        return head;
    }
}
