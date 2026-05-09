package com.example.neetcode.linkedlists;


/*Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.



Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
Example 2:


Input: head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]*/

public class RevereseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k <= 1) return head;
        int counter = 0;
        ListNode curr = head;
        while(curr!=null){
            counter++;
            curr = curr.next;
        }

        int groups = counter/k;

        ListNode newHead = head;
        ListNode prevTail = null;
        curr = head;

        for (int g = 0; g < groups; g++) {
            ListNode groupHead = curr;
            ListNode prev = null;

            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            if (prevTail == null) {
                newHead = prev;
            } else {
                prevTail.next = prev;
            }

            prevTail = groupHead;
        }
        prevTail.next = curr;
        return newHead;
    }

    public static void main(String[] args) {
        // list node 1 -> 2 -> 3 ->  4 -> 5
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4,new ListNode(5)))));

        RevereseNodesInKGroup revereseNodesInKGroup = new RevereseNodesInKGroup();
        ListNode result =  revereseNodesInKGroup.reverseKGroup(listNode , 2);
        while(result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
        System.out.print(""+null);
        System.out.println();
    }
}
