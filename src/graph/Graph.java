package graph;

import java.util.*;

public class Graph {
    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        Node node = new Node(label);
        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void removeNode(String label) {
        Node node = nodes.get(label);
        if (node == null) {
            return;
        }
        for (Node source : adjacencyList.keySet()) {
            List<Node> targets = adjacencyList.get(source);
            targets.remove(node);
        }
        adjacencyList.remove(node);
        nodes.remove(node);
    }

    public void addEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        if (fromNode == null) {
            throw new IllegalStateException();
        }
        Node toNode = nodes.get(to);
        if (toNode == null) {
            throw new IllegalStateException();
        }
        adjacencyList.get(fromNode).add(toNode);
    }

    public void removeEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if (fromNode == null || toNode == null) {
            return;
        }
        adjacencyList.get(fromNode).remove(toNode);
    }

    public void print() {
        for (Node source : adjacencyList.keySet()) {
            List<Node> targets = adjacencyList.get(source);
            if (!targets.isEmpty()) {
                System.out.println(source + " is connected to " + targets);
            }
        }
    }

    public void traverseDepthFirst(String from) {
        Node fromNode = nodes.get(from);
        if (fromNode == null) {
            return;
        }
        traverseDepthFirst(fromNode, new HashSet<>());
    }

    private void traverseDepthFirst(Node node, Set<Node> visitedNodes) {
        System.out.println(node);
        visitedNodes.add(node);
        List<Node> targets = adjacencyList.get(node);
        for (Node source : targets) {
            if (!visitedNodes.contains(source)) {
                traverseDepthFirst(source, visitedNodes);
            }
        }
    }

    public void traverseDepthFirstIterative(String from) {
        Node fromNode = nodes.get(from);
        if (fromNode == null) {
            return;
        }
        Set<Node> visitedNodes = new HashSet<>();
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(fromNode);
        while (!nodeStack.isEmpty()) {
            Node current = nodeStack.pop();

            if (visitedNodes.contains(current)) {
                continue;
            }

            System.out.println(current);
            visitedNodes.add(current);
            List<Node> adjacentNodes = adjacencyList.get(current);
            for (Node adjacentNode : adjacentNodes) {
                if (!visitedNodes.contains(adjacentNode)) {
                    nodeStack.push(adjacentNode);
                }
            }
        }
    }

    public void traverseBreadthFirst(String from) {
        Node fromNode = nodes.get(from);
        if (fromNode == null) {
            return;
        }
        Set<Node> visitedNodes = new HashSet<>();
        Queue<Node> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(fromNode);
        while (!nodeQueue.isEmpty()) {
            Node current = nodeQueue.remove();
            if (visitedNodes.contains(current)) {
                continue;
            }
            System.out.println(current);
            visitedNodes.add(current);
            List<Node> adjacentNodes = adjacencyList.get(current);
            for (Node adjacentNode : adjacentNodes) {
                if (!visitedNodes.contains(adjacentNode)) {
                    nodeQueue.add(adjacentNode);
                }
            }
        }
    }

    public List<String> topologicalSort() {
        Stack<Node> nodeStack = new Stack<>();
        Set<Node> visitedNodes = new HashSet<>();
        for (Node node : nodes.values()) {
            topologicalSort(node, nodeStack, visitedNodes);
        }

        List<String> sorted = new ArrayList<>();
        while (!nodeStack.isEmpty()) {
            sorted.add(nodeStack.pop().label);
        }
        return sorted;
    }

    private void topologicalSort(Node node,
                                 Stack<Node> nodeStack,
                                 Set<Node> visitedNodes) {
        if (visitedNodes.contains(node)) {
            return;
        }
        visitedNodes.add(node);
        for (Node adjacentNode : adjacencyList.get(node)) {
            topologicalSort(adjacentNode, nodeStack, visitedNodes);
        }
        nodeStack.push(node);
    }

    public boolean hasCycle() {
        Set<Node> all = new HashSet<>();
        all.addAll(nodes.values());

        Set<Node> visiting = new HashSet<>();
        Set<Node> visited = new HashSet<>();

        while (!all.isEmpty()) {
            Node current = all.iterator().next();
            if (hasCycle(current, all, visiting, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycle(Node node,
                             Set<Node> all,
                             Set<Node> visiting,
                             Set<Node> visited) {
        all.remove(node);
        visiting.add(node);
        for (Node adjacentNode : adjacencyList.get(node)) {
            if (visited.contains(adjacentNode)) {
                continue;
            }
            if (visiting.contains(adjacentNode)) {
                return true;
            }
            if (hasCycle(adjacentNode, all, visiting, visited)) {
                return true;
            }
        }
        visiting.remove(node);
        visited.add(node);
        return false;
    }

    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }
}
