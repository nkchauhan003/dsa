package com.backendml.K2_CloneGraph;

import java.util.*;

public class B_BFSearch {

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        Node cloned = new Node(node.val);

        Map<Node, Node> map = new HashMap<>();
        map.put(node, cloned);

        while (!queue.isEmpty()) {
            Node existingNode = queue.poll();
            Node clonedNode = map.get(existingNode);

            for (Node existingNeighbor : existingNode.neighbors) {
                Node c = map.get(existingNeighbor);
                if (c == null) {
                    queue.offer(existingNeighbor);
                    c = new Node(existingNeighbor.val);
                    map.put(existingNeighbor, c);
                }
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

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}



