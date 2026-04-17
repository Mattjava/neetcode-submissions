# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if p == None and q == None:
            return True
        elif p == None or q == None:
            return False
        pQueue = []
        qQueue = []

        pQueue.append(p)
        qQueue.append(q)

        while len(pQueue) > 0 or len(qQueue) > 0:
            pCurr = pQueue.pop(0)
            qCurr = qQueue.pop(0)
            if pCurr == None and qCurr == None:
                continue
            elif pCurr == None and qCurr != None or pCurr != None and qCurr == None:
                return False

            if pCurr.val != qCurr.val:
                return False 

            pQueue.append(pCurr.left)
            pQueue.append(pCurr.right)
            qQueue.append(qCurr.left)
            qQueue.append(qCurr.right)

        return True


        