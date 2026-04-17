# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if root == None:
            return root
        curr = root

        queue = []

        def swap(node: TreeNode):
            temp = node.left
            node.left = node.right
            node.right = temp

        swap(curr)
        queue.append(root.left)
        queue.append(root.right)

        while len(queue) > 0:
            curr = queue.pop()
            if curr == None:
                continue
            swap(curr)
            queue.append(curr.left)
            queue.append(curr.right)

        return root