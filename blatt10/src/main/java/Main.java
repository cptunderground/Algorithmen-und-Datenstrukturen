import java.lang.Math;
import java.util.Scanner;

public class Main {

  /**
   * Reads a weighted directed graph from standard input and runs the Bellman-Ford algorithm with
   * start node 0.
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int v = in.nextInt();
    int e = in.nextInt();

    EdgeWeightedDigraph graph = new EdgeWeightedDigraph(v);
    for (int i = 0; i < e; i++) {
      int from = in.nextInt();
      int to = in.nextInt();
      double weight = in.nextDouble();
      graph.addEdge(new DirectedEdge(from, to, weight));
    }

    BellmanFord bf = new BellmanFord(graph, 0);
    boolean negativeCycle = bf.hasNegativeCycle();
    if (negativeCycle) {
      System.out.println("Found negative cycle:");
      for (DirectedEdge edge : bf.negativeCycle()) {
        System.out.format("%d -> %d", edge.from(), edge.to());
      }
    } else {
      System.out.println("No negative cycle!");
      System.out.format("Shortest path to node %d is\n", v - 1);
      for (DirectedEdge edge : bf.shortestPathTo(v - 1)) {
        System.out.format("%d -> %d\n", edge.from(), edge.to());
      }
    }
  }
}
