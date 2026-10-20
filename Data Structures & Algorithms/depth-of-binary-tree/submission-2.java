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

// DFS solution

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int result = 0;
        // Node -> Depth
        Stack<Pair<TreeNode, Integer>> dfs = new Stack<>();
        dfs.push(new Pair<>(root, 1));

        while (!dfs.isEmpty()) {
            Pair<TreeNode, Integer> curr = dfs.pop();
            TreeNode cnode = curr.getKey();
            Integer cdepth = curr.getValue();

            if (cnode != null) {
                result = Math.max(result, cdepth);
                dfs.push(new Pair<>(cnode.left, cdepth + 1));
                dfs.push(new Pair<>(cnode.right, cdepth + 1));
            }
        }

        return result;
    }
}
