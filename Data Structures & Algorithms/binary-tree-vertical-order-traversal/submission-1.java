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
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int start = 0;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();

        nodeQueue.add(root);
        colQueue.add(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int col = colQueue.poll();

            start = Math.min(start, col);
            List<Integer> list = map.getOrDefault(col, new LinkedList<Integer>());
            list.add(node.val);
            map.put(col, list);

            if (node.left != null) {
                nodeQueue.add(node.left);
                colQueue.add(col - 1);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
                colQueue.add(col + 1);
            }
        }

        List<List<Integer>> result = new LinkedList<>();
        while (map.containsKey(start)) {
            result.add(map.get(start));
            start++;
        }

        return result;
    }
}