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

    static class Pair {
        TreeNode node; // store the node
        int index;     // store the index

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int minIndex = q.peek().index; // smallest index at this level
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Pair p = q.poll();  // take out Pair
                TreeNode node = p.node;
                int curIndex = p.index - minIndex; // normalize index

                if (i == 0) first = curIndex;
                if (i == size - 1) last = curIndex;

                if (node.left != null) {
                    q.offer(new Pair(node.left, 2 * curIndex + 1));
                }
                if (node.right != null) {
                    q.offer(new Pair(node.right, 2 * curIndex + 2));
                }
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        return maxWidth;
    }
}