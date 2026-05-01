package com.example.neetcode.linkedlists;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
    private static ListNode mergeKLists(ListNode[] lists) {

        Queue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);  // Min-heap by val

        // Step 1: Seed heap with all non-null heads (O(K log K))
        for (ListNode node : lists) {
            if (node != null) pq.offer(node);
        }

        ListNode dummy = new ListNode();  // Familiar dummy!
        ListNode curr = dummy;

        // Step 2: Build result (O(N log K) total)
        while (!pq.isEmpty()) {
            ListNode min = pq.poll();     // O(log K): Get global smallest
            curr.next = min;              // Splice it in
            curr = curr.next;
            if (min.next != null) {
                pq.offer(min.next);       // O(log K): Add its successor
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // list node 1 -> 4 -> 5
        // list node 1 -> 3 -> 4
        // list node 2 -> 6
        ListNode listNode = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode listNode1 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode2 = new ListNode(2, new ListNode(6));
        ListNode result =  mergeKLists(new ListNode[]{listNode, listNode1, listNode2});
        while(result!=null){
            System.out.print(result.val+" ");
            result = result.next;
        }
    }
}
