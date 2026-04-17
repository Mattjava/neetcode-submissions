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
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode iter = head;


        while(iter != null)
        {
            ListNode newNode = new ListNode(iter.val);
            newNode.next = prev;
            prev = newNode;
            iter = iter.next;
        }

        return prev;
    }

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode l1 = head;
        ListNode l2 = reverse(slow);
        ListNode pointer = null;

        while(l1 != slow && l2 != null) {
            System.out.println(l1.val + " | " + l2.val);
            ListNode copyNode = new ListNode(l2.val);
            ListNode temp = l1.next;
            l1.next = copyNode;
            copyNode.next = temp;
            pointer = copyNode;
            l1 = temp;
            l2 = l2.next;
        }

        if(l2 == null)
            pointer.next = null;
        else
            l1.next = null;
    }
}
