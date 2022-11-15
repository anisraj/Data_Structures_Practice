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

    public boolean hasCycle() {
        Set<Node> visitedNodes = new HashSet<>();
        for (Node node : nodes.values()) {
            if (!visitedNodes.contains(node)) {
                if (hasCycle(visitedNodes, node, null)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycle(Set<Node> visited, Node nodeToVisit, Node previousNode) {
        visited.add(nodeToVisit);
        for (Edge edge : nodeToVisit.getEdges()) {
            if (edge.to == previousNode) {
                continue;
            }
            if (visited.contains(edge.to)) {
                return true;
            }
            if (hasCycle(visited, edge.to, nodeToVisit)) {
                return true;
            }
        }
        return false;
    }

    public WeightedGraph getMinimumSpanningTree() {
        WeightedGraph tree = new WeightedGraph();
        PriorityQueue<Edge> edges = new PriorityQueue<>(
                Comparator.comparingInt(e -> e.weight)
        );

        Node startNode = nodes.values().iterator().next();
        tree.addNode(startNode.label);
        edges.addAll(startNode.getEdges());

        while (tree.nodes.size() < nodes.size()) {
            Edge minEdge = edges.remove();
            if (tree.nodes.containsKey(minEdge.to.label)) {
                continue;
            }
            tree.addNode(minEdge.to.label);
            tree.addEdge(minEdge.from.label, minEdge.to.label, minEdge.weight);
            for (Edge edge : minEdge.to.getEdges()) {
                if (!tree.nodes.containsKey(edge.to.label)) {
                    edges.add(edge);
                }
            }
        }
        return tree;
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
