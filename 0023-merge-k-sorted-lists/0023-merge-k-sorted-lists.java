/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Initialize a min-heap with a comparator for ListNode values.
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each linked list to the min-heap, ignoring null lists.
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.add(head);
            }
        }

        // Create a dummy node to serve as the starting point of the merged list.
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Loop until the heap is empty.
        while (!minHeap.isEmpty()) {
            // Poll the node with the smallest value from the heap.
            ListNode smallestNode = minHeap.poll();
            
            // Append this node to our result list.
            current.next = smallestNode;
            current = current.next; // Move the current pointer forward.

            // If the polled node has a next node, add it to the heap.
            if (smallestNode.next != null) {
                minHeap.add(smallestNode.next);
            }
        }

        // The dummy's next node is the head of the fully merged list.
        return dummy.next;
    }
}






