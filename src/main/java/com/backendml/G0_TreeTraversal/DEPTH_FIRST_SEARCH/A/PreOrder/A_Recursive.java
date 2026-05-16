package com.backendml.G0_TreeTraversal.DEPTH_FIRST_SEARCH.A.PreOrder;

import java.util.ArrayList;
import java.util.List;

public class A_Recursive {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        helper(root, nodes);
        return nodes;
    }

    public void helper(TreeNode root, List<Integer> nodes) {
        if (root == null)
            return;
        nodes.add(root.val);
        helper(root.left, nodes);
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
