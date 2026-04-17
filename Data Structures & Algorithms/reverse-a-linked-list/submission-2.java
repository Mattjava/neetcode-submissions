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
        ListNode body = null;
        ListNode prev = null;

        ListNode iter = head;

        while(iter != null) {
            body = new ListNode(iter.val);
            body.next = prev;
            prev = body;
            iter = iter.next;
        }

        return body;
    }
}
