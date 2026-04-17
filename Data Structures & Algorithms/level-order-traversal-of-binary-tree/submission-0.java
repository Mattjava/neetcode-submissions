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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new LinkedList<List<Integer>>();

        HashMap<Integer, List<Integer>> levels = new HashMap<>();

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();

        nodeQueue.offer(root);
        levelQueue.offer(0);

        while(!nodeQueue.isEmpty()) {
            TreeNode curr = nodeQueue.poll();
            int level = levelQueue.poll();

            List<Integer> levelList = levels.getOrDefault(level, new LinkedList<Integer>());
            levelList.add(curr.val);
            levels.put(level, levelList);

            if(curr.left != null) {
                nodeQueue.offer(curr.left);
                levelQueue.offer(level+1);
            }

            if(curr.right != null) {
                nodeQueue.offer(curr.right);
                levelQueue.offer(level+1);
            }
        }

        List<List<Integer>> result = new LinkedList<List<Integer>>();

        for(List<Integer> level : levels.values())
            result.add(level);

        return result;

    }
}
