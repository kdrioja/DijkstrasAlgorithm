import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {
    private int name;
    private List<Node> path;
    private int pathWeight;
    private Map<Node, Integer> adjacentNodes;

    public Node(int name) {
        this.name = name;
        this.path = new LinkedList<>();
        this.pathWeight = 0;
        this.adjacentNodes = new HashMap<>();
    }
    public void addAdjacentNode(Node newNode, int weight) {
        this.adjacentNodes.put(newNode, weight);
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public List<Node> getPath() {
        return path;
    }

    public void setPath(List<Node> path) {
        this.path = path;
    }

    public int getPathWeight() {
        return pathWeight;
    }

    public void setPathWeight(int pathWeight) {
        this.pathWeight = pathWeight;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }
}
