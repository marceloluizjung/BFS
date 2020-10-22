// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.

// This class represents a directed graph using adjacency list
// representation
//https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
class Main {
    // Driver method to
    public static void main(String args[]) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        g.BFS(2);
    }
}
// This code is contributed by Aakash Hasija