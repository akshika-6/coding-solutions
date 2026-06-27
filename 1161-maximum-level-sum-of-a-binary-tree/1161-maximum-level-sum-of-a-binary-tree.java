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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 1;
        int ans = 1;
        int maxSum = Integer.MIN_VALUE;

        while(!queue.isEmpty()){
            int len = queue.size();
            int sum = 0;
            for(int i = 0;i<len;i++){
                TreeNode node = queue.poll();
                sum += node.val;

                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            if(sum > maxSum){
                maxSum = sum;
                ans = level;
            }
            level++;
        }
        return ans;
    }
}