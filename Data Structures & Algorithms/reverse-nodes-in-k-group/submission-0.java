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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 1;

        ListNode last = null;
        ListNode iter = head;
        ListNode prev = null;
        ListNode current = null;

        while(iter != null && count <= k)
        {
            current = new ListNode(iter.val);
            current.next = prev;

            if(last == null)
                last = current;

            prev = current;
            iter = iter.next;
            count++;
        }

        if(count <= k)
            return head;
        
        last.next = reverseKGroup(iter, k);

        return prev;
    }
}
