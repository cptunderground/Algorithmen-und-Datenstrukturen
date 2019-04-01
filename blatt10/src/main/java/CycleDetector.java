import java.util.LinkedList;

/**
 * Searches for a cycle in an EdgeWeightedDigraph.
 */
class CycleDetector {

  private boolean[] marked;
  private boolean[] onStack;
  private DirectedEdge[] edgeTo;
  private LinkedList<DirectedEdge> cycle;

  public CycleDetector(EdgeWeightedDigraph graph) {
    marked = new boolean[graph.noNodes()];
    onStack = new boolean[graph.noNodes()];
    edgeTo = new DirectedEdge[graph.noNodes()];
    cycle = null;

    for (int node = 0; node < graph.noNodes(); node++) {
      if (!marked[node]) {
        dfs(graph, node);
      }
    }

  }

  private void dfs(EdgeWeightedDigraph graph, int node) {
    onStack[node] = true;
    marked[node] = true;
    for (DirectedEdge edge : graph.adj(node)) {
      if (cycle != null) {
        return;
      }
      int to = edge.to();
      if (!marked[to]) {
        edgeTo[to] = edge;
        dfs(graph, to);
      } else if (onStack[to]) {
        cycle = new LinkedList<>();
        edgeTo[to] = edge;
        DirectedEdge prev = edge;
        while (prev.from() != to) {
          cycle.addFirst(prev);
          prev = edgeTo[prev.from()];
        }
        cycle.addFirst(prev);
        return;
      }
    }
    onStack[node] = false;
  }

  public LinkedList<DirectedEdge> getCycle() {
    return cycle;
  }
}
