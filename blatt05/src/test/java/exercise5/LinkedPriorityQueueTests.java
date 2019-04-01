package exercise5;

import java.util.Random;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;


public class LinkedPriorityQueueTests extends TestCase {

  @Test
  public void testReverselySortedSequence() {
    LinkedPriorityQueue<String> pq = new LinkedPriorityQueue<>();
    pq.insert("A");
    pq.insert("B");
    pq.insert("C");
    Assert.assertEquals("C", pq.max());
    Assert.assertEquals("C", pq.delMax());
    Assert.assertEquals("B", pq.max());
    Assert.assertEquals("B", pq.delMax());
    Assert.assertEquals("A", pq.max());
    Assert.assertEquals("A", pq.delMax());
  }

  @Test
  public void testRandomSequence() {

    Random rng = new Random(42);

    LinkedPriorityQueue<Integer> pq = new LinkedPriorityQueue<>();
    for (int i = 0; i < 10; ++i) {
      pq.insert(rng.nextInt());
    }

    Integer lastElement = Integer.MAX_VALUE;
    while (pq.isEmpty()) {
      lastElement = pq.delMax();
      Assert.assertTrue(lastElement >= pq.max());
    }
  }

  @Test
  public void testPqOfSizeOne() {
    LinkedPriorityQueue<Integer> pq = new LinkedPriorityQueue<>();
    pq.insert(42);
    Assert.assertEquals(new Integer(42), pq.max());
    Assert.assertEquals(new Integer(42), pq.delMax());
  }

  @Test
  public void testCorrectSize() {

    LinkedPriorityQueue<Integer> pq = new LinkedPriorityQueue<>();
    Assert.assertTrue(pq.isEmpty());
    pq.insert(5);
    Assert.assertEquals(1, pq.size());
  }
}
