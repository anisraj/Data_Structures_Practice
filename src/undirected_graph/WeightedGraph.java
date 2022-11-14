package undirected_graph;

import java.util.*;

public class WeightedGraph {

    private Map<String, Node> nodes;

    public WeightedGraph() {
        nodes = new HashMap<>();
    }

    public void addNode(String label) {
        nodes.putIfAbsent(label, new Node(label));
    }

    public void addEdge(String from, String to, int weight) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);
        if (fromNode == null || toNode == null) {
            throw new IllegalStateException();
        }
        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);
    }

    public void print() {
        for (Node node : nodes.values()) {
            List<Edge> edges = node.getEdges();
            if (!edges.isEmpty()) {
                System.out.println(node + " is connected to "+edges);
            }
        }
    }

    public Path getShortestPath(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if (fromNode == null || toNode == null) {
            throw new IllegalStateException();
        }

        Map<Node, Integer> distances = new HashMap<>();
        for (Node node : nodes.values()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.replace(fromNode, 0);

        PriorityQueue<NodeEntry> priorityQueue = new PriorityQueue<>(
                Comparator.comparingInt(ne -> ne.priority)
        );
        priorityQueue.add(new NodeEntry(fromNode, 0));

        Map<Node, Node> previousNode = new HashMap<>();

        Set<Node> visitedNodes = new HashSet<>();
        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.remove().node;
            visitedNodes.add(current);
            for (Edge edge : current.getEdges()) {
                if (visitedNodes.contains(edge.to)) {
                    continue;
                }
                int newDistance = distances.get(current) + edge.weight;
                if (newDistance < distances.get(edge.to)) {
                    distances.replace(edge.to, newDistance);
                    previousNode.put(edge.to, current);
                    priorityQueue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }
        return buildPath(toNode, previousNode);
    }

    private Path buildPath(Node toNode, Map<Node, Node> previousNodes) {
        Stack<Node> stack = new Stack<>();
        stack.push(toNode);
        Node previous = previousNodes.get(toNode);
        while (previous != null) {
            stack.push(previous);
            previous = previousNodes.get(previous);
        }

        Path path = new Path();
        while (!stack.empty()) {
            path.add(stack.pop().label);
        }
        return path;
    }

    private class Node {
        private String label;
        private List<Edge> edges;

        public Node(String label) {
            this.label = label;
            edges = new ArrayList<>();
        }

        public void addEdge(Node to, int weight) {
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges() {
            return edges;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private class Edge {
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + " -> " + to + " & weight = "+weight;
        }
    }

    private class NodeEntry {
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }
}
