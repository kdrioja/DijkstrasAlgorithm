public class Edge {
    private int nodeA;
    private int nodeB;
    private int weight;

    public Edge(int a, int b, int w) {
        this.nodeA = a;
        this.nodeB = b;
        this.weight = w;
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
