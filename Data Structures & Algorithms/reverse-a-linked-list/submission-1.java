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
        ListNode curr = null;
        ListNode prev = null;

        ListNode iter = head;

        while(iter != null)
        {
            curr = new ListNode(iter.val);
            curr.next = prev;
            prev = curr;
            iter = iter.next;
        }

        return curr;
    }
}
