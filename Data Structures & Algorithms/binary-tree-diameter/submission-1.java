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
    public int findHeight(TreeNode node) {
        if(node == null)
            return 0;
        
        return Math.max(findHeight(node.left), findHeight(node.right)) + 1;
    }

    public int findDiameter(TreeNode node)
    {
        if(node == null)
            return 0;

        int left = findHeight(node.left);
        int right = findHeight(node.right);

        int diameter = left + right;

        int other = Math.max(findDiameter(node.left), findDiameter(node.right));

        return Math.max(diameter, other);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return findDiameter(root);
    }
}
