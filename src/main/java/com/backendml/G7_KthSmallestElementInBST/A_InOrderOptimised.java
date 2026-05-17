package com.backendml.G7_KthSmallestElementInBST;

import java.util.ArrayList;
import java.util.List;

public class A_InOrderOptimised {

    public class Solution {

        public int kthSmallest(TreeNode root, int k) {
            // Initialize list with an initial capacity of k
            List<Integer> list = new ArrayList<>(k);

            // In-order traversal with early stopping
            inOrder(root, list, k);

            // Retrieve the k-th element
            return list.get(k - 1);
        }

        public void inOrder(TreeNode root, List<Integer> list, int k) {
            // Stop if node is null, or we already found k elements
            if (root == null || list.size() == k) {
                return;
            }

            // Traverse the left subtree (smaller elements)
            inOrder(root.left, list, k);

            // Process the current node only if we still need elements
            if (list.size() < k) {
                list.add(root.val);
            }

            // Traverse the right subtree only if we still need elements
            if (list.size() < k) {
                inOrder(root.right, list, k);
            }
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
