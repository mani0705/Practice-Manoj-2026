package com.example.neetcode.linkedlists;


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
public class Merge2SorteLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                if (head == null) {
                    head = new ListNode(list1.val);
                } else {
                    ListNode temp = head;
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = new ListNode(list1.val);
                }
                list1 = list1.next;
            } else {
                if (head == null) {
                    head = new ListNode(list2.val);
                } else {
                    ListNode temp = head;
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = new ListNode(list2.val);
                }
                list2 = list2.next;
            }
        }
        if (list1 == null && list2 != null) {
            while (list2 != null) {
                if (head == null) {
                    head = new ListNode(list2.val);
                } else {
                    ListNode temp = head;
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = new ListNode(list2.val);
                }
                list2 = list2.next;
            }
        } else if (list2 == null && list1 != null) {
            while (list1 != null) {
                if (head == null) {
                    head = new ListNode(list1.val);
                } else {
                    ListNode temp = head;
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = new ListNode(list1.val);
                }
                list1 = list1.next;
            }
        }
        return head;

    }

    private ListNode mergeTwoListsOptimised(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();  // Permanent anchor (never changes)
        ListNode temp = head;  // Working pointer (advances)
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if (list1 == null) {
            temp.next = list2;
        } else if (list2 == null) {
            temp.next = list1;
        }
        return head.next;

    }

    public static void main(String[] args) {

    }
}
