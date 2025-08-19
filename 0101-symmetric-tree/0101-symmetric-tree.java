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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMirror(root.left,root.right);
    }
    private static boolean isMirror(TreeNode p,TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        return (p.val == q.val) && isMirror(p.left,q.right) && isMirror(p.right,q.left);
    }
}
    
//         if (root == null) return true;
//         return isMirror(root.left, root.right);
//     }
    
//     private boolean isMirror(TreeNode t1, TreeNode t2) {
//         if (t1 == null && t2 == null) return true;   // both null → symmetric
//         if (t1 == null || t2 == null) return false;  // only one null → notsymmetric
//         return (t1.val == t2.val) 
//             && isMirror(t1.left, t2.right)   // outer children
//             && isMirror(t1.right, t2.left); // inner children
//     }
// }