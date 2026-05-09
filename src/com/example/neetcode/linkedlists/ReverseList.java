package com.example.neetcode.linkedlists;

/*Given the head of a singly linked list, reverse the list, and return the reversed list
Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]


Example 2:
Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []*/

public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prevP = null;
        ListNode nextP = null;

        while(curr!=null){
            nextP = curr.next;
            curr.next = prevP;
            prevP = curr;
            curr = nextP;
        }
        return prevP;
    }

    public static void main(String[] args) {
        // list node 1 -> 2 -> 3 -> 4
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4))));

        ReverseList reverseList = new ReverseList();
        ListNode rev = reverseList.reverseList(listNode);
        while(rev!=null){
            System.out.print(rev.val+"->");
            rev  = rev.next;
        }
        System.out.print(""+null);
    }
}
