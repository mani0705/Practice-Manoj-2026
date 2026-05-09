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
        int c=0;
        int loopCounter = 0;
        while(c<groups){
            head = reverseList(head,loopCounter,k , groups , c);
            c++;
        }
        return head;
    }


    private ListNode reverseList(ListNode head ,int loopCounter , int k , int number , int c) {
        ListNode temp = head;
        ListNode prevA = null;
        int min = 0;
        ListNode prevP = null;
        while(c!=0 && min<c*k){
            prevA = temp;
            temp=temp.next;
            min++;
        }
        ListNode curr = temp;
        ListNode prevp = null;

        ListNode nextP = null;
        while(loopCounter<k){
            nextP = curr.next;
            curr.next = prevP;
            prevP = curr;
            curr = nextP;
            loopCounter++;
        }
        ListNode dummy = prevP;
        while(dummy.next!=null){
            dummy = dummy.next;
        }
        dummy.next=curr;
        if(prevA!=null){
            prevA.next=prevP;
        }
        return prevP;
    }

    public static void main(String[] args) {
        // list node 1 -> 2 -> 3 ->  4 -> 5
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4,new ListNode(5)))));
        RevereseNodesInKGroup revereseNodesInKGroup = new RevereseNodesInKGroup();
        ListNode result
                =  revereseNodesInKGroup.reverseKGroup(listNode , 2);
        while(result!=null){
            System.out.print(result.val+"->");
            result = result.next;
        }
        System.out.print(""+null);
    }
}
