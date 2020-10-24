// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// This class represents a directed graph using adjacency list
// representation
//https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
class Main {



    // Driver method to
    public static void main(String args[]) {
        String[] graph = {
                "0 1",
                "0 2",
                "1 2",
                "2 0",
                "2 3",
                "3 3"
        };

        Graph graph1 = new Graph(graph);
        graph1.bfs("2", graph);
    }
}
// This code is contributed by Aakash Hasija