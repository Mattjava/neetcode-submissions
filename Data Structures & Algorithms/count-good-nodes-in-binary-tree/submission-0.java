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
    private List<Integer> goodNodes;

    public void iterate(TreeNode root, int max)
    {
        if(root == null)
            return;

        if(root.val >= max)
            goodNodes.add(root.val);
        
        int newMax = Math.max(max, root.val);

        iterate(root.left, newMax);
        iterate(root.right, newMax);
    }

    public int goodNodes(TreeNode root) {
        goodNodes = new LinkedList<Integer>();
        goodNodes.add(root.val);

        iterate(root.left, root.val);
        iterate(root.right, root.val);

        return goodNodes.size();
    }
}
