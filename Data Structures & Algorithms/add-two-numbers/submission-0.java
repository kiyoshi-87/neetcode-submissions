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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode t = null;
        int carry = 0;

        while (l1!=null && l2!=null) {
            int sum = l1.val + l2.val + carry;

            if (sum<10) {
                ListNode temp = new ListNode(sum);
                if (head == null) {
                    head = temp;
                } else {
                    t.next = temp;
                }
                t = temp;
                carry = 0;
            }  else {
                carry = 1;
                ListNode temp = new ListNode(sum%10);
                if (head == null) {
                    head = temp;
                } else {
                    t.next = temp;
                }
                t = temp;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1!=null) {
            int sum = l1.val + carry;
            
            if (sum<10) {
                ListNode temp = new ListNode(sum);
                t.next = temp;
                t = temp;
                carry = 0;
            } else {
                ListNode temp = new ListNode(0);
                t.next = temp;
                t = temp;
                carry = 1;
            }
            
            l1 = l1.next;
        }

        while (l2!=null) {
            int sum = l2.val + carry;

            if (sum<10) {
                ListNode temp = new ListNode(sum);
                t.next = temp;
                t = temp;
                carry = 0;
            } else {
                ListNode temp = new ListNode(0);
                t.next = temp;
                t = temp;
                carry = 1;
            }

            l2 = l2.next;
        }
        
        if (carry!=0) {
            ListNode temp = new ListNode(carry);
            
            t.next = temp;
        }

        return head;
    }
}
