import java.util.*;

public class Graph {
    private int V;   // No. of vertices
    private LinkedHashSet<String> verticesList = new LinkedHashSet<>();

    // prints BFS traversal from a given source s
    public static void BFS(String s, String[] graph) {
        // Mark all the vertices as not visited(By default
        // set as false)
        HashMap<String, Boolean> visited = new HashMap();

        // Fila BFS
        LinkedList<String> queue = new LinkedList<String>();

        // Marca o nó como visitado
        visited.put(s, true);
        queue.add(s);

        while (queue.size() != 0) {
            // Remove o vétice da lista
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it

            //Catando os vértices adjacentes (é aqui que aplica a ação de escolher o próximo vértice a ser processado)
            List<String> adjByS = new ArrayList<>();
            for (int count = 0; count < graph.length; count++) {
                String[] vertices = graph[count].split(" ");
                if (vertices[0].equals(s)) {
                    adjByS.add(vertices[1]);
                } else if (vertices[1].equals(s)) {
                    adjByS.add(vertices[0]);
                }
            }

            Iterator<String> i = adjByS.listIterator();
            while (i.hasNext()) {
                String n = i.next();
                if (visited.get(n) == null) {
                    visited.put(n, true);
                    queue.add(n);
                }
            }
        }
    }
}