public class QuickFind extends UnionFind {
  protected int[] id;

  /** QuickFind as in C3. * */
  public QuickFind(int n) {
    super(n); // components
    id = new int[n];

    for (int i = 0; i < n; i++) {
      noAccess++;
      id[i] = i;
    }
  }

  /** Get component of v. * */
  public int find(int v) {
    noAccess++;
    return id[v];
  }

  /** Add connection between v and w. * */
  public void union(int v, int w) {
    int idV = find(v);
    int idW = find(w);
    if (idV != idW) {
      for (int i = 0; i < id.length; i++) {
        noAccess++;
        if (id[i] == idV) {
          noAccess++;
          id[i] = idW;
          components--;
        }
      }
    }
  }
}
