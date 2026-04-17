# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if root == None:
            return 0
        depth = 0

        curr = root
        stack = []
        stack.append([root.left, 1])
        stack.append([root.right, 1])

        while len(stack) > 0:
            curr = stack.pop()
            if curr[0] == None:
                continue
            depth = max(depth, curr[1])
            stack.append([curr[0].left, curr[1] + 1])
            stack.append([curr[0].right, curr[1] + 1])
        
        return depth + 1
        