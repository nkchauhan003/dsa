package com.backendml.G3_SameTree;

public class A_Recursive {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 1. If both are null, they are identical
        if (p == null && q == null) return true;

        // 2. If only one is null, or values don't match, they are different
        if (p == null || q == null || p.val != q.val) return false;

        // 3. Recursively check left and right subtrees
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
