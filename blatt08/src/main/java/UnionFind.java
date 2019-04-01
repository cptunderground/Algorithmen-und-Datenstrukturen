public abstract class UnionFind {

  protected int components;
  protected int noAccess; // for counting array access operations in 8.2d

  public UnionFind(int n) {
    components = n;
  }

  public int count() {
    return components;
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  /** Get component of v. * */
  public abstract int find(int v);

  /** Add connection between v and w. * */
  public abstract void union(int v, int w);

  public int getNumberOfArrayAccesses() {
    return noAccess;
  }
}
