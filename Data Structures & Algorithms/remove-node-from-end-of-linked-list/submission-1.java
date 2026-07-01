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
        ListNode reverseHead = null;
        ListNode cur = head;

        while (cur != null) {
            var next = cur.next;
            cur.next = reverseHead;
            reverseHead = cur;
            cur = next;
        }

        int idx = 1;
        ListNode result = null;
        while (reverseHead != null) {
            ListNode next = reverseHead.next;
            if (idx != n) {
                reverseHead.next = result;
                result = reverseHead;
            } 
            reverseHead = next;
            idx++;
        }

        return result;
    }
}
