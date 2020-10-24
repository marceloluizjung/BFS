import java.util.*;

/**
 * @author Marcelo Luiz Jung
 * @author Rafael Froeschlin Filho
 */
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

    /**
     * @param vertex
     * @param graph
     * @return
     */
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

    /**
     * @param s
     * @param graph
     * @return
     */
    public HashMap<String, Integer> bfs(String s, String[] graph) {
        HashMap<String, Boolean> visited = new HashMap();
        LinkedList<String> queue = new LinkedList<String>();
        visited.put(s, true);
        queue.add(s);
        vertexDistance.put(s, distance);
        while (queue.size() != 0) {
            s = queue.poll();
            Iterator<String> i = this.adjacencyList.get(s).listIterator();
            while (i.hasNext()) {
                String n = i.next();
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