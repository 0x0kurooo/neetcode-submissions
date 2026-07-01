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
        // First reverse the list
        ListNode reverse = null;
        ListNode cur = head;
        int size = 0;

        while (cur != null) {
            var next = cur.next;
            cur.next = reverse;
            reverse = cur;
            cur = next;
            size++;
        }

        cur = null;
        int idx = 1;
        while (reverse != null) {
            ListNode reverseNext = reverse.next;
            if (idx != n) {
                reverse.next = cur;
                cur = reverse;
            } 
            reverse = reverseNext;
            idx++;
        }

        return cur;
    }
}
