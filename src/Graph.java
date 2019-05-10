import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Graph {
    private Set<Node> nodes;

    public Graph() {
        this.nodes = new HashSet();
    }


    public void addNode(Node node) {
        this.nodes.add(node);
    }


    public Node shortestPath(int source, int destination) {
        Node sourceNode = null, destinationNode = null;
        Iterator<Node> iterator = this.nodes.iterator();
        Set<Node> visitedNodes = new HashSet<>();
        Set<Node> seenNodes = new HashSet<>();

        while (iterator.hasNext()) {
            Node current = iterator.next();

            if (current.getName() == source)
                sourceNode = current;
            if (current.getName() == destination)
                destinationNode = current;
        }

        sourceNode.setPathWeight(0);
        seenNodes.add(sourceNode);

        while (!seenNodes.isEmpty()) {
            Node currentNode = getSmallestWeight(seenNodes);
            seenNodes.remove(currentNode);

            for (Map.Entry<Node, Integer> adjacentNode : currentNode.getAdjacentNodes().entrySet()) {
                Node currentAdjacentNode = adjacentNode.getKey();
                int edgeWeight = adjacentNode.getValue();

                if (!visitedNodes.contains(currentAdjacentNode)) {
                    setSmallestPath(sourceNode, currentAdjacentNode, edgeWeight);
                    seenNodes.add(currentAdjacentNode);
                }
            }
            visitedNodes.add(currentNode);
        }
        return destinationNode;
    }


    public void setSmallestPath(Node sourceNode, Node currentNode, int edgeWeight) {
        if (currentNode.getPathWeight() > edgeWeight + sourceNode.getPathWeight()) {
            currentNode.setPathWeight(edgeWeight + sourceNode.getPathWeight());
            currentNode.setPath(sourceNode.getPath());
            currentNode.getPath().add(sourceNode);
        }
    }


    public Node getSmallestWeight(Set<Node> setofNodes) {
        int smallestWeight = Integer.MAX_VALUE;
        Node smallestWeightNode = null;

        for (Node node : setofNodes) {
            if (node.getPathWeight() < smallestWeight) {
                smallestWeight = node.getPathWeight();
                smallestWeightNode = node;
            }
        }

        return smallestWeightNode;
    }
}
