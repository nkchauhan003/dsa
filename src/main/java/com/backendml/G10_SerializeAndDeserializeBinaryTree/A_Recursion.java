package com.backendml.G10_SerializeAndDeserializeBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class A_Recursion {
    public String serialize(TreeNode root) {
        if (root == null) return "N";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("N,");
            } else {
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        // Remove trailing comma
        return sb.substring(0, sb.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("N")) return null;

        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode parent = queue.poll();

            // Handle left child
            if (!values[i].equals("N")) {
                parent.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(parent.left);
            }
            i++;

            // Handle right child
            if (i < values.length && !values[i].equals("N")) {
                parent.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(parent.right);
            }
            i++;
        }
        return root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
