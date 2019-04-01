import java.util.LinkedList;

public class BellmanFord {

  private double[] distance;
  private DirectedEdge[] edgeTo;
  private boolean[] inQueue;
  private LinkedList<Integer> queue;
  private LinkedList<DirectedEdge> cycle;
  int callsToRelax;

  /**
   * Bellman-Ford algorithm.
   * <p>
   * <p> If the graph contains a negative cycle, it finds one. Otherwise it computes the shortest
   * paths from startNode to all (reachable) nodes. </p>
   */
  public BellmanFord(EdgeWeightedDigraph graph, int startNode) {
    distance = new double[graph.noNodes()];
    edgeTo = new DirectedEdge[graph.noNodes()];
    inQueue = new boolean[graph.noNodes()];
    queue = new LinkedList<Integer>();
    callsToRelax = 0;


    distance[startNode] = 0;
    for (int n = 0; n < graph.noNodes(); n++) {
      if (n != startNode) {
        distance[n] = Double.POSITIVE_INFINITY;
      }
    }
    queue.addLast(startNode);
    inQueue[startNode] = true;
    while (!hasNegativeCycle() && !queue.isEmpty()) {
      int node = queue.removeFirst();
      inQueue[node] = false;
      relax(graph, node);
    }

  }

  private void relax(EdgeWeightedDigraph graph, int node) {
    for (DirectedEdge edge : graph.adj(node)) {
      int w = edge.to();
      if (distance[node] + edge.weight() < distance[w]) {
        edgeTo[w] = edge;
        distance[w] = distance[node] + edge.weight();
        if (!inQueue[w]) {
          queue.addLast(w);
          inQueue[w] = true;
        }
      }
    }
    callsToRelax++;
    if (callsToRelax % graph.noNodes() == 0) {
      findNegativeCycle();
    }
  }

  private void findNegativeCycle() {
    int noNodes = distance.length;
    EdgeWeightedDigraph graph = new EdgeWeightedDigraph(noNodes);
    for (DirectedEdge edge : edgeTo) {
      if (edge != null) {
        graph.addEdge(edge);
      }
    }
    CycleDetector cd = new CycleDetector(graph);
    cycle = cd.getCycle();
  }

  public boolean hasNegativeCycle() {
    return cycle != null;
  }

  public Iterable<DirectedEdge> negativeCycle() {
    return cycle;
  }

  /**
   * Returns shortest path to node or null if there is no path.
   */
  public Iterable<DirectedEdge> shortestPathTo(int node) {
    if (distance[node] == Double.POSITIVE_INFINITY) {
      return null;
    }

    if (edgeTo[node] == null) {
      return new LinkedList<>();
    }

    LinkedList<DirectedEdge> path = new LinkedList<>();
    path.addFirst(edgeTo[node]);
    DirectedEdge edge;
    while ((edge = edgeTo[path.peekFirst().from()]) != null) {
      path.addFirst(edge);
    }

    return path;
  }
}
