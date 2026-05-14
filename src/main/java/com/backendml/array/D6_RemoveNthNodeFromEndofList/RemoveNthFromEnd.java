package com.backendml.array.D6_RemoveNthNodeFromEndofList;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode curr = head;

        // Pass 1: Find total length
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        // Edge Case: Remove the head node
        if (length == n) {
            return head.next;
        }

        // Pass 2: Count down to the target node
        int stepsToPrev = length - n;
        curr = head;
        while (stepsToPrev > 1) {
            curr = curr.next;
            stepsToPrev--;
        }

        // Delete the target node
        curr.next = curr.next.next;
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
