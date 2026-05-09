package com.example.neetcode.linkedlists;

/*You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.



Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]*/

public class ReorderList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4,new ListNode(5)))));
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(listNode);
    }


    public void reorderList(ListNode head) {
        ReverseList reverseList = new ReverseList();
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode revP = slow.next;
        revP = reverseList.reverseList(revP);
        slow.next = null;
        ListNode temp1 = head;
        ListNode temp2 = revP;
        ListNode tail = null;
        while (temp1 != null && temp2 != null) {
            ListNode next1 = temp1.next;
            ListNode next2 = temp2.next;
            temp2.next = null;
            temp1.next = temp2;
            if (tail == null) {
                tail = temp1.next;
            } else {
                tail.next = temp1;
                temp1.next = temp2;
                tail = temp1.next;
            }
            temp1 = next1;
            temp2 = next2;
        }
        if (temp1 != null && tail != null) {
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = temp1;
        }
        if (temp2 != null && tail != null) {
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = temp2;
        }
        ListNode result = head;
        while(result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
        System.out.print(""+null);
    }
}
