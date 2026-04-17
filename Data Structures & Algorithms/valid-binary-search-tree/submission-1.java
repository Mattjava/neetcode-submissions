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
    public boolean checkValidity(TreeNode current, int[] range) {
        if (current.val <= range[0] || current.val >= range[1])
            return false;
        
        return true;
    }

    public boolean isValid(TreeNode current, int[] range)
    {
        if(current == null)
            return true;
        else if(!checkValidity(current, range))
            return false;
        
        int[] leftRange = {range[0], current.val};
        int[] rightRange = {current.val, range[1]};

        return isValid(current.left, leftRange) && isValid(current.right, rightRange);
    }

    public boolean isValidBST(TreeNode root) {
        int[] leftRange = {Integer.MIN_VALUE, root.val};
        int[] rightRange = {root.val, Integer.MAX_VALUE};

        return isValid(root.left, leftRange) && isValid(root.right, rightRange);
    }
}
