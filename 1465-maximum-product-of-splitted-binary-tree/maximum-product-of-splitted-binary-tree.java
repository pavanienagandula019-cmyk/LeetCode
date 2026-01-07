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
    static final int MOD = 1_000_000_007;
    long totalSum = 0;
    long maxProduct = 0;

    // Step 1: Calculate total sum of tree
    void getTotalSum(TreeNode root) {
        if (root == null) return;
        totalSum += root.val;
        getTotalSum(root.left);
        getTotalSum(root.right);
    }

    // Step 2: Post-order DFS to compute subtree sums
    long dfs(TreeNode root) {
        if (root == null) return 0;

        long left = dfs(root.left);
        long right = dfs(root.right);

        long subSum = root.val + left + right;

        // Try cutting above this subtree
        maxProduct = Math.max(
            maxProduct,
            subSum * (totalSum - subSum)
        );

        return subSum;
    }

    public int maxProduct(TreeNode root) {
        getTotalSum(root);  // O(n)
        dfs(root);          // O(n)
        return (int)(maxProduct % MOD);
    }
}
