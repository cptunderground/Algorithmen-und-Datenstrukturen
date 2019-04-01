package exercise7;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class HashtableTests extends TestCase {

  public void basicSanityTest(HashST ht) {
    char[] teststring = {'S', 'E', 'A', 'R', 'C', 'H'};

    int pos = 0;
    for (char c : teststring) {
      ht.put(c, pos);
      pos += 1;
    }

    for (char c : teststring) {
      Assert.assertTrue(ht.contains(c));
    }

    Assert.assertEquals(6, ht.size());

    Assert.assertEquals(2, ht.get('A'));
    Assert.assertEquals(4, ht.get('C'));
    Assert.assertEquals(1, ht.get('E'));
    Assert.assertEquals(5, ht.get('H'));
    Assert.assertEquals(3, ht.get('R'));
  }

  @Test
  public void testBasicSanityLinearProbing() {
    basicSanityTest(new LinearProbingHashST(100));
  }

  @Test
  public void testBasicSanityDoubleHashing() {
    basicSanityTest(new DoubleHashingHashST(100));
  }

  @Test
  public void testMeanClusterSize() {

    LinearProbingHashST ht = new LinearProbingHashST(1000000);
    Random r = new Random();
    for (int i = 0; i < ht.getCapacity() / 2; ++i) {
      ht.put(r.nextInt(), i);
    }

    MeanAndVariance mv = ht.getMeanAndVarianceOfClusterLengths();
    System.out.println(mv);

    Assert.assertTrue(mv.getMean() > 2.4);
    Assert.assertTrue(mv.getMean() < 2.6);
    Assert.assertTrue(mv.getVariance() > 6.0);
    Assert.assertTrue(mv.getVariance() < 6.4);
  }
}
