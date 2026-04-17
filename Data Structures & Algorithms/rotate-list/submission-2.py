# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head or not head.next or k < 1:
            return head

        size = 0

        curr = head

        while curr:
            size += 1
            curr = curr.next

        if size < 1:
            return head

        if k > size:
            k = k % size

        end = size - k

        saved = head
        dummy = None
        curr = head

        for i in range(end):
            dummy = curr
            curr = curr.next

        if dummy:
            dummy.next = None
        
        head = curr

        while curr.next:
            curr = curr.next

        if saved != head:
            curr.next = saved

        return head
        
        