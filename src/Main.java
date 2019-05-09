import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] nodes = generateNodes();
        printNodes(nodes);
        ArrayList<Edge> edges = generateEdges(nodes.length);
        printEdges(edges);

        calculatePaths(nodes.length, edges);



        for (int i = 0; i < 100; i++) {
            //System.out.println(rand.nextDouble());
            //System.out.println(generateWeight(5));
        }
    }


    public static void calculatePaths(int n, ArrayList<Edge> edges) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter start node: ");
        int start = scanner.nextInt();

        while (start <= 0 || start > n) {
            System.out.println("Not a valid start node.");
            System.out.print("Enter start node: ");
            start = scanner.nextInt();
        }

        System.out.print("Enter destination node: ");
        int destination = scanner.nextInt();

        while (destination <= 0 || destination > n) {
            System.out.println("Not a valid destination node.");
            System.out.print("Enter destination node: ");
            destination = scanner.nextInt();
        }

        if (start == destination) {
            System.out.println("Shortest path: " + start + ", with path weight 0");
            System.out.println("Widest path: " + start + ", with path weight 0");
        }
        else {
            calculateShortestPath(n, edges, start, destination);
        }
    }


    public static void calculateShortestPath(int n, ArrayList<Edge> edges, int start, int destination) {

    }

    public static int[] generateNodes() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        while (n <= 0) {
            System.out.println("Integer entered was not positive.");
            System.out.print("Enter a positive integer: ");
            n = scanner.nextInt();
        }

        int[] result = new int[n];

        for (int i = 1; i <= n; i++) {
            result[i - 1] = i;
        }
        return result;
    }


    public static ArrayList<Edge> generateEdges(int n) {
        double probability = 0.50;
        Random rand = new Random();
        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (rand.nextDouble() <= probability) {
                    edges.add(new Edge(i, j, generateWeight(n)));
                }
            }
        }
        return edges;
    }


    public static int generateWeight(int n) {
        int min = 1, max = 5 * n;
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }


    public static void printNodes(int[] nodes) {
        System.out.print("Node list: {");

        for (int i = 0; i < nodes.length - 1; i++) {
            System.out.print(nodes[i] + ", ");
        }
        System.out.println(nodes[nodes.length - 1] + "}");
    }


    public static void printEdges(ArrayList<Edge> edges) {
        System.out.print("Edge list: {");

        for (int i = 0; i < edges.size() - 1; i++) {
            System.out.print(edges.get(i) + ", ");
        }

        System.out.println(edges.get(edges.size() - 1) + "}");
    }
}