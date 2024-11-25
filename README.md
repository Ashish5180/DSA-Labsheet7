Disaster Response Management System


Prerequisites

    Java: Version 8 or higher.
    IDE: Any Java IDE (e.g., IntelliJ IDEA, Eclipse).
    Libraries: Standard Java libraries (no external libraries required).

How to Clone and Run
Clone the Repository

To clone the repository to your local machine, run the following command:

git clone https://github.com/Ashish5180/DSA-Labsheet7.git

Compile and Run

    Navigate to the project directory:

cd disaster-response-management-system

    Compile the Java files:

javac *.java

    Run the program:

java Main

The system will start, and you can interact with the disaster response management system using the console.
Project Structure

    Main.java: The entry point of the application. It initializes the system and handles user interactions.
    AVLTree.java: Implements AVL Tree with methods for insertion, deletion, and traversal (in-order, pre-order, post-order).
    Graph.java: Implements the graph using adjacency lists and adjacency matrices with BFS, DFS, Dijkstra’s, and Prim’s/Kruskal’s algorithms.
    DisasterResponseSystem.java: Manages the disaster response system, visualizing affected areas, resources, and rescue operations.

Tree Implementation

    AVL Tree: Used to manage hierarchical data of affected regions.
        Operations: Insertion, Deletion, Balancing.
        Traversals: In-order, Pre-order, Post-order.

Graph Implementation

    Graph Representation: Represent disaster-affected regions and resource centers.
        BFS and DFS: Graph traversal algorithms.
        Shortest Path Algorithms: Dijkstra’s and Bellman-Ford.
        Minimum Spanning Tree: Prim’s and Kruskal’s.

Disaster Response Management System

    UI: User interface to visualize and manage affected areas, resource centers, and rescue operations (can be developed using Java Swing or JavaFX).
    Features:
        Add/remove affected areas.
        Visualize routes for resource delivery.
        Manage rescue operations.

Test Cases and Sample Outputs

    AVL Tree Insertion:
        Input: insert("Region1"), insert("Region2"), insert("Region3")
        Expected Output: ["Region1", "Region2", "Region3"]

    Graph BFS Traversal:
        Input: addEdge(A, B), addEdge(A, C), addEdge(B, D), BFS(A)
        Expected Output: ["A", "B", "C", "D"]

    Dijkstra's Algorithm:
        Input: addEdge(A, B, 1), addEdge(B, C, 2), addEdge(A, C, 4), shortestPath(A, C)
        Expected Output: ["A", "B", "C"]
