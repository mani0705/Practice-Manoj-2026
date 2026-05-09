package com.example.neetcode.linkedlists;


/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.



Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]


Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz

* */
public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode t1 = head, t2 = head;
        while (n != 0) {
            t1 = t1.next;
            n--;
        }
        if (t1 == null) {
            head = head.next;
        } else {
            while (t1.next != null) {
                t1 = t1.next;
                t2 = t2.next;
            }
            t2.next = t2.next.next;
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4,new ListNode(5)))));
        RemoveNthNodeFromEnd removeNthNodeFromEnd = new RemoveNthNodeFromEnd();
        ListNode result = removeNthNodeFromEnd.removeNthFromEnd(listNode, 2);
        while(result!=null){
            System.out.print(result.val+"->");
            result  = result.next;
        }
        System.out.print(""+null);
    }

}
