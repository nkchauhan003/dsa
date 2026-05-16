package com.backendml.G0_TreeTraversal.BREADTH_FIRST_SEARCH;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class B_Iterative {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> nodes = new ArrayList<>();

        if (root == null) {
            return nodes;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> nodesInLevel = new ArrayList<>(levelSize); // Optimization: Pre-size the list

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.remove();
                nodesInLevel.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            nodes.add(nodesInLevel);
        }
        return nodes;
    }

    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
