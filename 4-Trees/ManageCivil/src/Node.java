import java.util.ArrayList;
import java.util.List;

public class Node {
    private String name;
    private String code;
    private Node parent;
    private List<Node> children;

    public Node(String name, String code, Node parent) {
        this.name = name;
        this.code = code;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Node getParent() {
        return parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void addChild(Node child) {
        children.add(child);
    }
}