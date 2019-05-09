public class Edge {
    private int nodeA;
    private int nodeB;
    private int weight;

    public Edge(int a, int b, int w) {
        this.nodeA = a;
        this.nodeB = b;
        this.weight = w;
    }

    public boolean containsNode(int node) {
        return nodeA == node || nodeB == node;
    }

    public int getNodeA() {
        return nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return "(" + nodeA + ", " + nodeB + ", " + weight + ")";
    }
}