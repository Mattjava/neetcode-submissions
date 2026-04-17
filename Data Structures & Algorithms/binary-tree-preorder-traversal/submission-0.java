/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        
        if(root != null)
            nodeStack.push(root);

        while(!nodeStack.isEmpty()) {
            TreeNode current = nodeStack.pop();
            list.add(current.val);

            if(current.right != null)
                nodeStack.push(current.right);
            if(current.left != null)
                nodeStack.push(current.left);
        }

        return list;
    }
}