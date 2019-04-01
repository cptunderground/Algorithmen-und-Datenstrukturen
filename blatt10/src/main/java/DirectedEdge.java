public class DirectedEdge {

  private final int source;
  private final int target;
  private final double edgeWeight;


  /**
   * Creates an directed weighted edge.
   **/
  public DirectedEdge(int from, int to, double weight) {
    source = from;
    target = to;
    edgeWeight = weight;
  }

  public int from() {
    return source;
  }

  public int to() {
    return target;
  }

  public double weight() {
    return edgeWeight;
  }
}

