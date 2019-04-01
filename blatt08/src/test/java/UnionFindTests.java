import org.junit.Assert;
import org.junit.Test;

public class UnionFindTests  {
  
  @Test
  public void quickFindShouldCorrectlyCountComponents() {
    UnionFind uf = new QuickFind(6);
    uf.union(0, 1);
    uf.union(4, 3);
    uf.union(2, 1);
    uf.union(2, 2);
    Assert.assertEquals(uf.count(), 3);
  }
  
  @Test
  public void quickFindShouldCorrectlyReportConnected() {
    UnionFind uf = new QuickFind(6);
    uf.union(0, 1);
    uf.union(4, 3);
    uf.union(2, 1);
    uf.union(2, 2);
    Assert.assertEquals(uf.connected(2, 0), true);
    Assert.assertEquals(uf.connected(0, 2), true);
    Assert.assertEquals(uf.connected(2, 2), true);
    Assert.assertEquals(uf.connected(3, 4), true);
    Assert.assertEquals(uf.connected(3, 5), false);
    Assert.assertEquals(uf.connected(5, 1), false);
  }

  @Test
  public void quickUnionShouldCorrectlyCountComponents() {
    UnionFind uf = new QuickUnion(6);
    uf.union(0, 1);
    uf.union(4, 3);
    uf.union(2, 1);
    uf.union(2, 2);
    Assert.assertEquals(uf.count(), 3);
  }
  
  @Test
  public void quickUnionShouldCorrectlyReportConnected() {
    UnionFind uf = new QuickUnion(6);
    uf.union(0, 1);
    uf.union(4, 3);
    uf.union(2, 1);
    Assert.assertEquals(uf.connected(2, 0), true);
    Assert.assertEquals(uf.connected(0, 2), true);
    Assert.assertEquals(uf.connected(2, 2), true);
    Assert.assertEquals(uf.connected(3, 4), true);
    Assert.assertEquals(uf.connected(3, 5), false);
    Assert.assertEquals(uf.connected(5, 1), false);
  }

  @Test
  public void rankedQuickUnionShouldCorrectlyCountComponents() {
    UnionFind uf = new RankedQuickUnionWithPathCompression(6);
    uf.union(0, 1);
    uf.union(4, 3);
    uf.union(2, 1);
    Assert.assertEquals(uf.count(), 3);
  }
  
  @Test
  public void rankedQuickUnionShouldCorrectlyReportConnected() {
    UnionFind uf = new RankedQuickUnionWithPathCompression(6);
    uf.union(0, 1);
    uf.union(4, 3);
    uf.union(2, 1);
    Assert.assertEquals(uf.connected(2, 0), true);
    Assert.assertEquals(uf.connected(0, 2), true);
    Assert.assertEquals(uf.connected(2, 2), true);
    Assert.assertEquals(uf.connected(3, 4), true);
    Assert.assertEquals(uf.connected(3, 5), false);
    Assert.assertEquals(uf.connected(5, 1), false);
  }
}
