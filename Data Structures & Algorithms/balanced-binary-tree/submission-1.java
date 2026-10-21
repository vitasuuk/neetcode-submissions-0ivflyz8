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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftH = maxSubtreeHeight(root.left);
        int rightH = maxSubtreeHeight(root.right);

        if (Math.abs(leftH - rightH) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxSubtreeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        return 1 + Math.max(maxSubtreeHeight(node.left),
                            maxSubtreeHeight(node.right));
    }
}
