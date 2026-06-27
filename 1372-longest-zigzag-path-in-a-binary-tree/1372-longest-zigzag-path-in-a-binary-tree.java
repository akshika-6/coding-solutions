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
    int ans = 0;
    public int longestZigZag(TreeNode root) {
        if(root.left != null){
            dfs(root.left,true,1);
        }
        if(root.right != null){
            dfs(root.right,false,1);
        }
        return ans;
    }
    private void dfs(TreeNode root,boolean cameFromLeft,int len){
        if(root == null){
            return;
        }
        ans = Math.max(ans,len);
        if(cameFromLeft){
            dfs(root.right,false,len+1);
            dfs(root.left,true,1);
        }else{
            dfs(root.left,true,len+1);
            dfs(root.right,false,1);
        }
    }
}