package com.backendml.K2_CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A_DFSearch {
    Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        // Already cloned
        Node cloned = map.get(node);

        if (cloned != null) {
            return cloned;
        }

        // Create clone
        cloned = new Node(node.val);
        // Store in map
        map.put(node, cloned);
        // Clone neighbors
        for (Node neighbor : node.neighbors) {
            cloned.neighbors.add(
                    cloneGraph(neighbor)
            );
        }
        return cloned;
    }

    class Node {

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