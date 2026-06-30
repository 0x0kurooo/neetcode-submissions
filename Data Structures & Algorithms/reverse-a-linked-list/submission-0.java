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
    public ListNode reverseList(ListNode head) {
        ListNode res = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;

            cur.next = res;
            res = cur;
            cur = next;
        }

        return res;
    }
}
