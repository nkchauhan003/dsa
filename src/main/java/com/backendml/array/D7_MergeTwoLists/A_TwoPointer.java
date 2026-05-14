package com.backendml.array.D7_MergeTwoLists;

public class A_TwoPointer {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Base cases: if one list is empty, return the other list
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode head = null;

        // Initialize the head of the merged list with the smaller initial value
        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }

        // Pointer to track the current tail node of the merged list
        ListNode currentTail = head;

        // Traverse both lists, appending the smaller value to the merged list
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                currentTail.next = list1;
                list1 = list1.next;
            } else {
                currentTail.next = list2;
                list2 = list2.next;
            }
            currentTail = currentTail.next;
        }

        // Append the remaining nodes of list1 or list2 if any exist
        if (list1 != null) {
            currentTail.next = list1;
        }
        if (list2 != null) {
            currentTail.next = list2;
        }

        return head;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
