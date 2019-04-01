public class RankedQuickUnionWithPathCompression extends UnionFind {

  protected int[] parent;
  private int[] rank;

  /**
   * RankedQuickUnionWithPathCompression from slide set C3. *
   */
  public RankedQuickUnionWithPathCompression(int n) {
    super(n);
    parent = new int[n];
    rank = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
      rank[i] = 0;
      noAccess += 2;
    }
  }

  /**
   * Get component of v. *
   */
  public int find(int v) {
    noAccess++;
    if (parent[v] == v) {
      return v;
    } else {
      noAccess++;
      int root = find(parent[v]);
      noAccess++;
      parent[v] = root;
      return root;
    }
  }

  /**
   * Add connection between v and w.
   */
  public void union(int v, int w) {
    int rootV = find(v);
    int rootW = find(w);
    if (rootV == rootW) {
      return;
    }
    noAccess += 2;
    if (rank[rootW] < rank[rootV]) {
      noAccess++;
      parent[rootW] = rootV;
    } else {
      noAccess++;
      parent[rootV] = rootW;
      noAccess += 2;
      if (rank[rootV] == rank[rootW]) {
        noAccess++;
        rank[rootW]++;
      }
    }
    components--;
  }
}
