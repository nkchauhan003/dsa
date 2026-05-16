package com.backendml.array.G0_TreeTraversal.DEPTH_FIRST_SEARCH.InOrder;

import java.util.ArrayList;
import java.util.List;

public class A_Recursive {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        helper(root, nodes);
        return nodes;
    }

    public void helper(TreeNode root, List<Integer> nodes) {
        if (root == null)
            return;
        helper(root.left, nodes);
        nodes.add(root.val);
        helper(root.right, nodes);
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
