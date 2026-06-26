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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        return dfs(root,(long)targetSum) + pathSum(root.left,targetSum) + pathSum(root.right,targetSum);
    }
    private static int dfs(TreeNode root,long target){
        if(root == null){
            return 0;
        }
        int ans = 0;
        if(root.val == target){
            ans++;
        }
        ans+=dfs(root.left,target-root.val);
        ans+=dfs(root.right,target-root.val);

        return ans;
    } 
}