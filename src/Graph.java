import java.util.*;

public class Graph {
    private HashMap<String, List<String>> adjacencyList = new HashMap<>();
    private HashMap<String, Integer> vertexDistance = new HashMap<>();
    private int distance = 0;

    public Graph(String[] graph) {
        for (int count = 0; count < graph.length; count++) {
            String[] vertices = graph[count].split(" ");
            if (adjacencyList.get(vertices[0]) == null) {
                List<String> adjacencyByVertex = this.getAdjacencyByVertex(vertices[0], graph);
                this.adjacencyList.put(vertices[0], adjacencyByVertex);
            }
            if (adjacencyList.get(vertices[1]) == null) {
                List<String> adjacencyByVertex = this.getAdjacencyByVertex(vertices[1], graph);
                this.adjacencyList.put(vertices[1], adjacencyByVertex);
            }

        }
    }

    private List<String> getAdjacencyByVertex(String vertex, String[] graph) {
        List<String> adjByS = new ArrayList<>();
        for (int count = 0; count < graph.length; count++) {
            String[] vertices = graph[count].split(" ");
            if (vertices[0].equals(vertex)) {
                adjByS.add(vertices[1]);
            } else if (vertices[1].equals(vertex)) {
                adjByS.add(vertices[0]);
            }
        }
        Collections.sort(adjByS);
        return adjByS;
    }

    // prints BFS traversal from a given source s
    public void bfs(String s, String[] graph) {
        // Mark all the vertices as not visited(By default
        // set as false)
        HashMap<String, Boolean> visited = new HashMap();

        // Fila BFS
        LinkedList<String> queue = new LinkedList<String>();

        // Marca o nó como visitado
        visited.put(s, true);
        queue.add(s);
        vertexDistance.put(s,distance);
        while (queue.size() != 0) {
            // Remove o vétice da lista
            s = queue.poll();

            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it

            Iterator<String> i = this.adjacencyList.get(s).listIterator();
            distance++;
            //Nesta lista que aplica o critério
            while (i.hasNext()) {
                String n = i.next();
                if (visited.get(n) == null) {
                    vertexDistance.put(n,distance);
                    visited.put(n, true);
                    queue.add(n);
                }
            }
        }
    }
}