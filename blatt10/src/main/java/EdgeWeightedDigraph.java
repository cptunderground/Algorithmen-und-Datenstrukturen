import java.util.ArrayList;
import java.util.LinkedList;

public class EdgeWeightedDigraph {

  private final int nodes;
  private int edges;
  private ArrayList<LinkedList<DirectedEdge>> adjacent;

  /**
   * Creates a weighted digraph without any edges.
   */
  public EdgeWeightedDigraph(int numberNodes) {
    nodes = numberNodes;
    edges = 0;
    adjacent = new ArrayList<LinkedList<DirectedEdge>>();
    for (int i = 0; i < numberNodes; i++) {
      adjacent.add(new LinkedList<DirectedEdge>());
    }
  }

  public void addEdge(DirectedEdge edge) {
    adjacent.get(edge.from()).add(edge);
    edges++;
  }

  public int noEdges() {
    return edges;
  }

  public int noNodes() {
    return nodes;
  }

  public Iterable<DirectedEdge> adj(int node) {
    return adjacent.get(node);
  }
}
