import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Marcelo Luiz Jung
 * @author Rafael Froeschlin Filho
 */
class Main {

    public static void main(String args[]) {
        ArrayList<String> buf = new ArrayList<>();

        try {
            File file = new File("C:\\temp\\entrada.in");
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                buf.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[] graph = new String[buf.size()];
        graph = buf.toArray(graph);

        Graph graph1 = new Graph(graph);
        HashMap<String, Integer> bfsResult = graph1.bfs("*");
        if (bfsResult != null) System.out.println(bfsResult.get("Entrada") + bfsResult.get("Saida"));
    }
}
