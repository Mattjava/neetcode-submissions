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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode iter1 = list1;
        ListNode iter2 = list2;

        if(iter1 == null)
            return iter2;
        else if(iter2 == null)
            return iter1;

        ListNode head = new ListNode(Math.min(iter1.val, iter2.val));
        if(head.val == iter1.val)
            iter1 = iter1.next;
        else
            iter2 = iter2.next;
        ListNode iter = head;

        while(iter1 != null || iter2 != null)
        {
            if(iter1 == null || iter2 == null)
            {
                if(iter1 == null) {
                    iter.next = new ListNode(iter2.val);
                    iter2 = iter2.next;
                } else {
                    iter.next = new ListNode(iter1.val);
                    iter1 = iter1.next;
                }

                iter = iter.next;

                continue;
            }

            int value = Math.min(iter1.val, iter2.val);

            if(value == iter1.val)
                iter1 = iter1.next;
            else
                iter2 = iter2.next;

            iter.next = new ListNode(value);
            iter = iter.next; 
        }

        return head;
    }
}