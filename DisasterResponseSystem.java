import java.util.*;

// AVL Tree Implementation
class AVLTreeNode {
    String region;
    int height;
    AVLTreeNode left, right;

    public AVLTreeNode(String region) {
        this.region = region;
        height = 1;
    }
}

class AVLTree {
    private AVLTreeNode root;

    // Insert a node into the AVL Tree
    public void insert(String region) {
        root = insertNode(root, region);
    }

    private AVLTreeNode insertNode(AVLTreeNode node, String region) {
        if (node == null) return new AVLTreeNode(region);

        if (region.compareTo(node.region) < 0)
            node.left = insertNode(node.left, region);
        else if (region.compareTo(node.region) > 0)
            node.right = insertNode(node.right, region);
        else return node;

        // Update height and balance tree
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        // Left heavy
        if (balance > 1 && region.compareTo(node.left.region) < 0)
            return rotateRight(node);
        // Right heavy
        if (balance < -1 && region.compareTo(node.right.region) > 0)
            return rotateLeft(node);
        // Left-Right case
        if (balance > 1 && region.compareTo(node.left.region) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        // Right-Left case
        if (balance < -1 && region.compareTo(node.right.region) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private int height(AVLTreeNode node) {
        return (node == null) ? 0 : node.height;
    }

    private int getBalance(AVLTreeNode node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    private AVLTreeNode rotateRight(AVLTreeNode y) {
        AVLTreeNode x = y.left;
        AVLTreeNode T = x.right;

        x.right = y;
        y.left = T;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private AVLTreeNode rotateLeft(AVLTreeNode x) {
        AVLTreeNode y = x.right;
        AVLTreeNode T = y.left;

        y.left = x;
        x.right = T;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public void inOrderTraversal() {
        System.out.print("In-order Traversal: ");
        inOrder(root);
        System.out.println();
    }

    private void inOrder(AVLTreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.region + " ");
            inOrder(node.right);
        }
    }
}

// Graph Implementation
class Graph {
    private Map<String, List<Edge>> adjList = new HashMap<>();

    static class Edge {
        String target;
        int weight;

        Edge(String target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public void addEdge(String src, String dest, int weight) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.putIfAbsent(dest, new ArrayList<>());
        adjList.get(src).add(new Edge(dest, weight));
        adjList.get(dest).add(new Edge(src, weight)); // Undirected graph
    }

    public void bfs(String start) {
        System.out.print("BFS Traversal: ");
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            if (!visited.contains(node)) {
                visited.add(node);
                System.out.print(node + " ");
                for (Edge edge : adjList.get(node)) {
                    if (!visited.contains(edge.target)) {
                        queue.add(edge.target);
                    }
                }
            }
        }
        System.out.println();
    }

    public void dijkstra(String start) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        adjList.keySet().forEach(node -> distances.put(node, Integer.MAX_VALUE));
        distances.put(start, 0);
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            for (Edge neighbor : adjList.get(current.target)) {
                int newDist = distances.get(current.target) + neighbor.weight;
                if (newDist < distances.get(neighbor.target)) {
                    distances.put(neighbor.target, newDist);
                    pq.add(new Edge(neighbor.target, newDist));
                }
            }
        }

        System.out.println("Shortest Path Distances: " + distances);
    }
}

public class DisasterResponseSystem {
    public static void main(String[] args) {
        // AVL Tree Operations
        AVLTree tree = new AVLTree();
        tree.insert("Region3");
        tree.insert("Region1");
        tree.insert("Region2");
        tree.inOrderTraversal();

        // Graph Operations
        Graph graph = new Graph();
        graph.addEdge("A", "B", 1);
        graph.addEdge("B", "C", 2);
        graph.addEdge("A", "C", 4);
        graph.bfs("A");
        graph.dijkstra("A");
    }
}
