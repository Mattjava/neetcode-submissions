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
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> levels = new LinkedList<List<Integer>>();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);

        while(!queue.isEmpty())
        {
            List<Integer> level = new LinkedList<Integer>();

            for(int i = queue.size(); i > 0; i--)
            {
                TreeNode current = queue.poll();
                if(current != null) {
                    level.add(current.val);
                    if(current.left != null)
                        queue.offer(current.left);
                    if(current.right != null)
                        queue.offer(current.right);
                }
                
            }

            if(level.size() > 0)
                levels.add(level);
        }

        List<Integer> lastValues = new LinkedList<Integer>();

        for(List<Integer> level : levels)
            lastValues.add(level.get(level.size() - 1));
        

        return lastValues;
    }
}
