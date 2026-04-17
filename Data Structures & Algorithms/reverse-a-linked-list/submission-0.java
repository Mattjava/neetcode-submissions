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
        ListNode iter = head;

        ListNode current = null;
        ListNode previous = null;

        while(iter != null) {
            current = new ListNode(iter.val);
            current.next = previous;
            previous = current;
            iter = iter.next;
        }

        return current;
    }
}
