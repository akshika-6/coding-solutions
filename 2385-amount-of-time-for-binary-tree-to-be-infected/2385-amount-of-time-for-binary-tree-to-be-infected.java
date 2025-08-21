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
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        TreeNode startNode = buildParentMap(root, null, parent, start);

        // Step 2: BFS from start node
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        
        q.add(startNode);
        visited.add(startNode);
        
        int time = -1; // because minute 0 starts with start node
        
        while (!q.isEmpty()) {
            int size = q.size();
            time++; // increment minute
            
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                
                // Infect left
                if (node.left != null && !visited.contains(node.left)) {
                    q.add(node.left);
                    visited.add(node.left);
                }
                
                // Infect right
                if (node.right != null && !visited.contains(node.right)) {
                    q.add(node.right);
                    visited.add(node.right);
                }
                
                // Infect parent
                if (parent.get(node) != null && !visited.contains(parent.get(node))) {
                    q.add(parent.get(node));
                    visited.add(parent.get(node));
                }
            }
        }
        
        return time;
    }
    
    // Helper to build parent map and return start node
    private TreeNode buildParentMap(TreeNode node, TreeNode par, 
                                    Map<TreeNode, TreeNode> parent, int start) {
        if (node == null) return null;
        if (par != null) parent.put(node, par);
        if (node.val == start) return node;
        
        TreeNode left = buildParentMap(node.left, node, parent, start);
        if (left != null) return left;
        return buildParentMap(node.right, node, parent, start);
    }
}