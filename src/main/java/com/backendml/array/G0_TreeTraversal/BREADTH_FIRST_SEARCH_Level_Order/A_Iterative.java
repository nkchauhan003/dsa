package com.backendml.array.G0_TreeTraversal.BREADTH_FIRST_SEARCH_Level_Order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class A_Iterative {
    public List<Integer> levelOrder(Node root) {
        List<Integer> nodes = new ArrayList<>();
        if (root == null)
            return nodes;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            nodes.add(n.data);
            if (n.left != null)
                queue.offer(n.left);
            if (n.right != null)
                queue.offer(n.right);
        }
        return nodes;
    }

    private static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int val) {
            data = val;
        }
    }
}
