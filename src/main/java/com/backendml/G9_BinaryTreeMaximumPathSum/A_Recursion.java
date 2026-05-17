package com.backendml.G9_BinaryTreeMaximumPathSum;

public class A_Recursion {
    // Global maximum
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // Get max gain from subtrees, ignore negative results
        int leftGain = Math.max(dfs(node.left), 0);
        int rightGain = Math.max(dfs(node.right), 0);

        // Check if the path through the current node is the new maximum
        maxSum = Math.max(maxSum, node.val + leftGain + rightGain);

        // Return the max path extending to the parent
        return node.val + Math.max(leftGain, rightGain);
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
