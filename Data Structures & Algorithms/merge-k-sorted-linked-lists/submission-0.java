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
    public ListNode merge(ListNode l1, ListNode l2)
    {
        if(l1 == null && l2 == null)
            return null;
        else if(l2 == null) 
            return l1;
        else if(l1 == null) 
            return l2;

        ListNode head = new ListNode(Math.min(l1.val, l2.val));

        if(head.val == l1.val)
            l1 = l1.next;
        else
            l2 = l2.next;

        ListNode iter = head;

        while(l1 != null || l2 != null)
        {
            if(l1 == null) {
                iter.next = new ListNode(l2.val);
                l2 = l2.next;
            } else if(l2 == null) {
                iter.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                iter.next = new ListNode(Math.min(l1.val, l2.val));
                if(iter.next.val == l1.val)
                    l1 = l1.next;
                else
                    l2 = l2.next;
            }

            iter = iter.next;
        }

        return head;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;

        for(int i = 0; i < lists.length; i++) 
            head = merge(head, lists[i]);
        

        return head;
        
    }
}
