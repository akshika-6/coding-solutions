/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        buildParentMap(root, null, parent);

        // Step 2: BFS from target
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.add(target);
        visited.add(target);
        int dist = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            if (dist == k) break; // we reached required distance
            dist++;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                // check neighbors: left, right, parent
                if (node.left != null && !visited.contains(node.left)) {
                    q.add(node.left);
                    visited.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    q.add(node.right);
                    visited.add(node.right);
                }
                if (parent.get(node) != null && !visited.contains(parent.get(node))) {
                    q.add(parent.get(node));
                    visited.add(parent.get(node));
                }
            }
        }

        // Collect all nodes in queue (these are distance k away)
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            result.add(q.poll().val);
        }

        return result;
    }

    // Helper to build parent map
    private void buildParentMap(TreeNode node, TreeNode par, Map<TreeNode, TreeNode> parent) {
        if (node == null) return;
        parent.put(node, par);
        buildParentMap(node.left, node, parent);
        buildParentMap(node.right, node, parent);
    }
}