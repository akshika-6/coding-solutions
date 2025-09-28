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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return buildtree(nums,0,nums.length-1);
    }
    public static TreeNode buildtree(int[] nums,int i,int j){
        if(i > j){
            return null;
        }
        int mid = i + (j-i)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildtree(nums,i,mid-1);
        root.right = buildtree(nums,mid+1,j);
        return root;
    }
}