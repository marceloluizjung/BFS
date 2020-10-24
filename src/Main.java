import java.util.HashMap;

/**
 * @author Marcelo Luiz Jung
 * @author Rafael Froeschlin Filho
 */
class Main {

    public static void main(String args[]) {
        String[] graph = {
                "Entrada A",
                "A F",
                "F C",
                "C B",
                "B D",
                "C D",
                "F J",
                "J H",
                "H G",
                "J G",
                "J *",
                "* I",
                "I L",
                "L M",
                "M K",
                "K Saida",
                "A K",
                "C E",
                "E I",
                "I M"
        };

        Graph graph1 = new Graph(graph);
        HashMap<String, Integer> bfsResult = graph1.bfs("*", graph);
        if (bfsResult != null) System.out.println(bfsResult.get("Entrada") + bfsResult.get("Saida"));
    }
}
