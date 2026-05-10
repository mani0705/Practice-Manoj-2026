package com.example.neetcode.linkedlists;

/*A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.



        Example 1:


Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
Example 2:


Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]
Example 3:



Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]


Constraints:

        0 <= n <= 1000
        -104 <= Node.val <= 104
Node.random is null or is pointing to some node in the linked list.*/


import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {


//    Just iterate the linked list and create copies of the nodes on the go.
//    Since a node can be referenced from multiple nodes due to the random pointers,
//    ensure you are not making multiple copies of the same node.
    public Node copyRandomList(Node head) {
        /*Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]*/
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        //Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
        //Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

        CopyListWithRandomPointer copyListWithRandomPointer = new CopyListWithRandomPointer();
        Node result =  copyListWithRandomPointer.copyRandomList(node1);
        Node result2 =  copyListWithRandomPointer.copyRandomListOptimized(node1);
        copyListWithRandomPointer.printList(result);
        System.out.println("Optimized:");
        copyListWithRandomPointer.printList(result2);
    }

    public void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print("[" + curr.val + ", " + (curr.random != null ? curr.random.val : "null") + "] -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
    public Node copyRandomListOptimized(Node head) {
        if (head == null) return null;

        // Step 1: Create new nodes and interleave them with original nodes
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // Step 2: Assign random pointers for the new nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the original and copied nodes
        Node copyHead = head.next;  // First copy
        Node current = head;
        Node copyCurr = copyHead;
        while (current != null) {
            current.next = current.next.next;      // Original skips copy
            copyCurr.next = (copyCurr.next != null) ? copyCurr.next.next : null;
            current = current.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }

}
