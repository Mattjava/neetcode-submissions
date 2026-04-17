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
    public void generate(TreeNode root, List<Integer> values)
    {
        if(root == null)
            return;
        generate(root.left, values);
        values.add(root.val);
        generate(root.right, values);
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> treeValues = new LinkedList<Integer>();
        generate(root, treeValues);
        return treeValues.get(k-1);
    }
}
