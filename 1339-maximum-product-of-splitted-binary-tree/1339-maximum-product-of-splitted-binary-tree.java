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
    long totalSum = 0;
    long maxProduct = 0;
    int MOD = 1_000_000_007;
    public int maxProduct(TreeNode root) {
       totalSum = findTotalSum(root);

        // 2️⃣ Try all possible splits
        findSubtreeSum(root);

        // 3️⃣ Return result modulo
        return (int)(maxProduct % MOD);
    }

    // First DFS → total sum of tree
    private long findTotalSum(TreeNode node) {
        if (node == null) return 0;

        return node.val
                + findTotalSum(node.left)
                + findTotalSum(node.right);
    }

    // Second DFS → compute subtree sums & max product
    private long findSubtreeSum(TreeNode node) {
        if (node == null) return 0;

        long left = findSubtreeSum(node.left);
        long right = findSubtreeSum(node.right);

        long subtreeSum = node.val + left + right;

        // product if we cut above this node
        long product = subtreeSum * (totalSum - subtreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subtreeSum; 
    }
}