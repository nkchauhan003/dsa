package com.backendml.G7_KthSmallestElementInBST;

import java.util.ArrayList;
import java.util.List;

public class A_InOrder {

    public class Solution {

        public int kthSmallest(TreeNode root, int k) {
            // List to store tree elements in sorted ascending order
            List<Integer> list = new ArrayList<>();

            // In-order traversal
            inOrder(root, list);

            // Retrieve the k-th element
            return list.get(k - 1);
        }

        public void inOrder(TreeNode root, List<Integer> list) {
            // Base case
            if (root == null) {
                return;
            }

            // Traverse the left subtree (smaller elements)
            inOrder(root.left, list);

            // Process the current node
            list.add(root.val);

            // Traverse the right subtree (larger elements)
            inOrder(root.right, list);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
