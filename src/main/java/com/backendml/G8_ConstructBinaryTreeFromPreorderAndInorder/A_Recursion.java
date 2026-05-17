package com.backendml.G8_ConstructBinaryTreeFromPreorderAndInorder;

import java.util.HashMap;
import java.util.Map;

public class A_Recursion {
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // Inorder array for O(1) lookups
            Map<Integer, Integer> inorderMap = new HashMap();
            int n = inorder.length;

            // Populate the map with inorder elements
            for (int i = 0; i < n; i++) {
                inorderMap.put(inorder[i], i);
            }

            return splitTree(preorder, inorderMap, 0, 0, n - 1);
        }

        private TreeNode splitTree(int[] preorder, Map<Integer, Integer> inorderMap, int rootIndex, int left, int right) {
            // Current root
            TreeNode root = new TreeNode(preorder[rootIndex]);

            // Find where this root element splits the inorder array into left and right subtrees
            int mid = inorderMap.get(preorder[rootIndex]);

            // If there are elements to the left of 'mid', a left subtree exists
            if (mid > left) {
                // Next root in preorder is simply the very next element (rootIndex + 1)
                root.left = splitTree(preorder, inorderMap, rootIndex + 1, left, mid - 1);
            }

            // If there are elements to the right of 'mid', a right subtree exists
            if (mid < right) {
                // Right root index = current rootIndex + 1 (skip root) + (mid - left) (skip left subtree)
                root.right = splitTree(preorder, inorderMap, rootIndex + mid - left + 1, mid + 1, right);
            }

            return root;
        }
    }

    class TreeNode {
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
