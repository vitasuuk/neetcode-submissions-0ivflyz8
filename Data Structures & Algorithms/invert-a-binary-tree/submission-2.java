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
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;

        recursiveHelper(root);
        return root;
    }

    private void recursiveHelper(TreeNode node) {
        // switch children
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        if (node.left != null) {
            recursiveHelper(node.left);
        }

        if (node.right != null) {
            recursiveHelper(node.right);
        }
    }
}
