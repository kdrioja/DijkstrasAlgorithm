/**
 * Kenia Rioja-Naranjo
 * CSC 401 Project 2
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nodes = generateNodes();
        printNodes(nodes);
        ArrayList<Edge> edges = generateEdges(nodes.length);
        printEdges(edges);

        calculatePaths(nodes.length, edges);
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
            Graph graph = generateGraph(n, edges);

            Node destinationNode = graph.shortestPath(start, destination);

            if (destinationNode.getPathWeight() < Integer.MAX_VALUE)
            {
                System.out.print("Shortest path: ");
                for (int i = 0; i < destinationNode.getPath().size(); i++) {
                    System.out.print(destinationNode.getPath().get(i).getName() + " - ");
                }
                System.out.println(destination + ", with path weight " + destinationNode.getPathWeight());
            }
            else
            {
                System.out.println("Shortest path: destination node is not reachable");
            }

            Node widestDestinationNode = graph.widestPath(start, destination);
            if (widestDestinationNode.getPathWeight() > Integer.MIN_VALUE)
            {
                System.out.print("Widest path: ");
                for (int i = 0; i < widestDestinationNode.getPath().size(); i++) {
                    System.out.print(widestDestinationNode.getPath().get(i).getName() + " - ");
                }
                System.out.println(destination + ", with path weight " + widestDestinationNode.getPathWeight());
            }
            else
            {
                System.out.println("Widest path: destination node is not reachable");
            }

        }
    }


    public static Graph generateGraph(int n, ArrayList<Edge> edges) {
        Graph graph = new Graph();

        for (int i = 1; i <= n; i++) {
            graph.addNode(new Node(i));
        }

        for (int i = 0; i < edges.size(); i++) {
            Edge currentEdge = edges.get(i);
            Node nodeA = graph.getNodeWithName(currentEdge.getNodeA());
            Node nodeB = graph.getNodeWithName(currentEdge.getNodeB());
            nodeA.addAdjacentNode(nodeB, currentEdge.getWeight());
            nodeB.addAdjacentNode(nodeA, currentEdge.getWeight());
        }

        return graph;
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

        System.out.println(edges.get(edges.size() - 1) + "}\n");
    }
}