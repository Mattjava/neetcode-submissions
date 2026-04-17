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
        int size = 0;
        ListNode iter = head;
        while(iter != null) {
            size++;
            iter = iter.next;
        }

        if(size == n)
            return head.next;

        int index = size - n;
        ListNode remover = head;

        for(int i = 0; i < index - 1; i++)
        {
            remover = remover.next;
        }

        remover.next = remover.next.next;

        return head;
    }
}
