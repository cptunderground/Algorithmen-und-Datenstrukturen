package exercise4;

import org.junit.Assert;
import org.junit.Test;

public class QueueTests {

  @Test
  public void testEmptyQueueHasSizeZero() {
    Queue<String> q = new Queue();
    Assert.assertTrue(q.size() == 0);
    Assert.assertTrue(q.isEmpty());
  }

  @Test
  public void testDequeueReturnsFirstEnqueuedElement() {
    Queue<String> q = new Queue();
    q.enqueue("first");
    q.enqueue("second");
    Assert.assertEquals("first", q.dequeue());
  }

  @Test
  public void testEnqueueDequeueleadsToEmptyQueue() {
    Queue<String> q = new Queue();
    q.enqueue("first");
    q.dequeue();
    Assert.assertTrue(q.isEmpty());
  }

  @Test
  public void testPeekReturnHeadElement() {
    Queue<String> q = new Queue();
    q.enqueue("first");
    q.enqueue("second");
    Assert.assertEquals("first", q.peek());
  }
}
