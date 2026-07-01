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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        // Moving 2 pointers, ulti reached end of list
        // Now slow is at the middle, then we can reverse the end and merge with the head
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        if (fast != null) {
            prev = slow;
            slow = slow.next;
        }

        prev.next = null; // Terminate fisrt half to prevent loop

        // Reverse the 2 list
        ListNode tail = null;
        ListNode cur = slow;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = tail;
            tail = cur;
            cur = next;
        }

        // Merge back the reversed list to head
        cur = head;
        ListNode tailCur = tail;

        while (cur != null && tailCur != null) {
            System.out.println(tailCur.val);
            ListNode curNext = cur.next;
            ListNode tailNext = tailCur.next;

            cur.next = tailCur;
            cur.next.next = curNext;

            cur = curNext;
            tailCur = tailNext;
        }

    }
}
