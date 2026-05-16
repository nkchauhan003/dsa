package com.backendml.D5_ReorderList;

public class A_ThreeSteps {
    public void reorderList(ListNode head) {
        // An empty list or a single-node list requires no reordering
        if (head == null || head.next == null) {
            return;
        }

        // STEP 1: Find the midpoint of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // STEP 2: Split the list and reverse the second half
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null; // Sever the link

        while (curr != null) {
            ListNode nextCurr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextCurr;
        }

        // STEP 3: Merge the two halves
        ListNode firstHalfCursor = head;
        ListNode secondHalfCursor = prev; // 'prev' now holds the head of the reversed second half

        // The second half is always equal to or shorter than the first half, so we only check 'secondHalfCursor'
        while (secondHalfCursor != null) {
            ListNode tmp1 = firstHalfCursor.next;
            ListNode tmp2 = secondHalfCursor.next;

            firstHalfCursor.next = secondHalfCursor;
            secondHalfCursor.next = tmp1;

            firstHalfCursor = tmp1;  // Advance first half cursor
            secondHalfCursor = tmp2; // Advance second half cursor
        }
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
