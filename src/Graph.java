import java.util.*;

/**
 * @author Marcelo Luiz Jung
 * @author Rafael Froeschlin Filho
 */
public class Graph {
    private HashMap<String, List<String>> adjacencyList = new HashMap<>();
    private HashMap<String, Integer> vertexDistance = null;

    public Graph(String[] graph) {
        for (String s : graph) {
            String[] vertices = s.split(" ");
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

    /**
     * @param vertex Vertex to calculate the list
     * @param graph Graph
     * @return Returns the list of adjacency
     */
    private List<String> getAdjacencyByVertex(String vertex, String[] graph) {
        List<String> adjByS = new ArrayList<>();
        for (String s : graph) {
            String[] vertices = s.split(" ");
            if (vertices[0].equals(vertex)) {
                adjByS.add(vertices[1]);
            } else if (vertices[1].equals(vertex)) {
                adjByS.add(vertices[0]);
            }
        }
        Collections.sort(adjByS);
        return adjByS;
    }

    /**
     * @param s Initial node
     * @return Returns a Map with the distances from a node
     */
    public HashMap<String, Integer> bfs(String s) {
        this.vertexDistance = new HashMap<>();
        HashMap<String, Boolean> visited = new HashMap<>();
        LinkedList<String> queue = new LinkedList<>();
        visited.put(s, true);
        queue.add(s);
        int distance = 0;
        vertexDistance.put(s, distance);
        while (queue.size() != 0) {
            s = queue.poll();
            for (String n : this.adjacencyList.get(s)) {
                if (visited.get(n) == null) {
                    vertexDistance.put(n, vertexDistance.get(s) + 1);
                    visited.put(n, true);
                    queue.add(n);
                }
            }
        }
        return this.vertexDistance;
    }
}