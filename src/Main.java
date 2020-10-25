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
        //Entrada até o queijo
        HashMap<String, Integer> bfsResultEnToQj = graph1.bfs("Entrada");
        //Queijo até a saída
        HashMap<String, Integer> bfsResultQjToSd = graph1.bfs("*");
        System.out.println(bfsResultEnToQj.get("*") + bfsResultQjToSd.get("Saida"));
    }
}
