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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long num1 = 0;
        long num2 = 0;

        int power = 0;

        ListNode l1Iter = l1;
        ListNode l2Iter = l2;

        while(l1Iter != null || l2Iter != null)
        {
            if(l1Iter != null)
            {
                num1 += l1Iter.val * Math.pow(10, power);
                l1Iter = l1Iter.next;
            }

            if(l2Iter != null)
            {
                num2 += l2Iter.val * Math.pow(10, power);
                l2Iter = l2Iter.next;
            }

            power++;
        }


        long sum = num1 + num2;
        ListNode sumHead = new ListNode((int) (sum % 10));
        ListNode iter = sumHead;
        sum /= 10;

        while(sum > 0)
        {
            ListNode newNode = new ListNode((int) (sum % 10));
            iter.next = newNode;
            iter = iter.next;
            sum /= 10;
        }

        return sumHead;
    }
}
