package com.backendml.K2_CloneGraph;

import java.util.*;

public class B_BFSearch {

    public Node cloneGraph(Node node) {

        if (node == null)
            return null;

        // BFS traversal queue
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        // Clone starting node
        Node cloned = new Node(node.val);

        // Original Node -> Cloned Node
        Map<Node, Node> map = new HashMap<>();
        map.put(node, cloned);

        while (!queue.isEmpty()) {

            // Current original node
            Node existingNode = queue.poll();
            // Corresponding cloned node
            Node clonedNode = map.get(existingNode);

            // Traverse neighbors
            for (Node existingNeighbor : existingNode.neighbors) {
                Node c = map.get(existingNeighbor);
                // Clone neighbor if not cloned yet
                if (c == null) {
                    queue.offer(existingNeighbor);
                    c = new Node(existingNeighbor.val);
                    map.put(existingNeighbor, c);
                }
                // Connect cloned neighbor
                clonedNode.neighbors.add(c);
            }
        }

        return cloned;
    }

    private class Node {

        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val,
                    ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}