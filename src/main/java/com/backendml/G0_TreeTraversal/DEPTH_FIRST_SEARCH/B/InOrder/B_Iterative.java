package com.backendml.G0_TreeTraversal.DEPTH_FIRST_SEARCH.B.InOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class B_Iterative {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root; //Avoid modifying the parameter pointer
        while (curr != null || !stack.empty()) {
            // Go as left as possible
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Process the current node
            curr = stack.pop();
            nodes.add(curr.val);

            // Move to the right subtree
            curr = curr.right;

        }
        return nodes;
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
