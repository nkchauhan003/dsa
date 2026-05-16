package com.backendml.G4_SubtreeOfAnotherTree;

public class A_UsingSameTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        // 1. Check if the current tree matches subRoot
        if (isSameTree(root, subRoot)) return true;

        // 2. If not, look in the left and right children
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Helper method to verify if two trees are completely identical
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    private class TreeNode {
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
