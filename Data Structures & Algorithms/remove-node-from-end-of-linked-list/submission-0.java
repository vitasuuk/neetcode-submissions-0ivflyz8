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
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        int breakoff = length - n;
        curr = head;
        ListNode separation = null;

        // Since there is nothing to separate and stitch
        if (length == 1) {
            return null;
        }

        if (length == n) {
            return head.next;
        }

        for(int i = 1; i <= length; i++) {
            if(i < breakoff) {
                curr = curr.next;
                continue;
            } else {
                separation = curr.next;
                curr.next = null;
                break;
            }
        }

        // Skip one in separation, stitch two parts together
        if(separation != null) {  // edge case when there is nothing after
            separation = separation.next;
        }
        curr.next = separation;

        return head;

    }
}
