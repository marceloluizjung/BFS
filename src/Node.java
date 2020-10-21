public class Node {

    /**
     * Nome
     */
    private String name;

    /**
     * Cor
     */
    private Color color;

    public Node() {}

    public Node(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
