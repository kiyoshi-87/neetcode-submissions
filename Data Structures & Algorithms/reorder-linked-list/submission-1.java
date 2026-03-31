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
    private boolean flag = false;
    
    public void reorderList(ListNode head) {
        ListNode t1 = head;
        if (isNullHead(head) || isSingleElementList(head) || isDoubleElementList(head)) {
            return;
        }
        ListNode t2 = findTail(t1);
        ListNode temp = t1.next;


        while (temp!=null) {
            t1.next = t2;
            t2.next = temp;

            t1 = temp;
            temp = temp.next;
            t2 = findTail(temp);
            
            if (flag) {
                break;
            }
        }
    }

    private boolean isNullHead(ListNode head) {
        return head == null;
    }

    private boolean isSingleElementList(ListNode head) {
        return head.next == null;
    }

    private boolean isDoubleElementList(ListNode head) {
        return head.next.next == null;
    }

    private ListNode findTail(ListNode node) {
        if (node == null) {
            return null;
        }
        
        if (node.next == null) {
            flag = true;
            return null;
        }

        while(node.next.next!=null) {
            node = node.next;
        }
        
        ListNode tail = node.next;
        node.next = null;

        return tail;
    }
}
