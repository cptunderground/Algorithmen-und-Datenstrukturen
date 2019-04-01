public class QuickUnion extends UnionFind {

  protected int[] parent;

  /**
   * QuickUnion as in slide set C3. *
   */
  public QuickUnion(int n) {
    super(n);
    parent = new int[n];
    for (int i = 0; i < n; i++) {
      noAccess++;
      parent[i] = i;
    }
  }

  /**
   * Get component of v. *
   */
  public int find(int v) {
    while (parent[v] != v) {
      noAccess++;
      v = parent[v];
      noAccess++;
    }
    noAccess++;
    return v; // return root
  }

  /**
   * Add connection between v and w. *
   */
  public void union(int v, int w) {
    int rootV = find(v);
    int rootW = find(w);
    if (rootV != rootW) {
      noAccess++;
      parent[rootV] = rootW;
      components--;
    }
  }
}
