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
        ListNode newListHead = null;
        ListNode iter = null;
        while(list1 != null || list2 != null) {
            ListNode newNode = null;

            if(list1 == null) {
                newNode = new ListNode(list2.val);
                list2 = list2.next;
            } else if(list2 == null) {
                newNode = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                int val = Math.min(list1.val, list2.val);

                if(val == list1.val)
                    list1 = list1.next;
                else
                    list2 = list2.next;

                newNode = new ListNode(val);
            }

            if(newListHead == null) {
                newListHead = newNode;
                iter = newListHead;
                continue;
            }

            iter.next = newNode;
            iter = iter.next;
        } 

        return newListHead;
    }
}