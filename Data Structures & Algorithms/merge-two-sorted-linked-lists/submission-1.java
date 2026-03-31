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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode curr;
        ListNode head;

        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        if (p1.val> p2.val) {
            head = p2;
            p2 = p2.next;
        } else {
            head = p1;
            p1 = p1.next;
        }

        curr = head;

        while (p1!=null && p2!=null) {
            if (p2.val < p1.val) {
                curr.next = p2;
                curr = p2;
                p2 = p2.next;
            } else {
                curr.next = p1;
                curr = p1;
                p1 = p1.next;
            }
        }

        if (p1 == null) {
            curr.next = p2;
        }

        if (p2 == null) {
            curr.next = p1;
        }
        
        return head;
    }
}