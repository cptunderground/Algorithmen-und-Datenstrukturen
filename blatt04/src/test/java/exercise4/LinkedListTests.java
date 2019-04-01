package exercise4;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTests {

  @Test
  public void testEmptyListHasSize1() {
    LinkedList<String> ll = new LinkedList<String>();
    Assert.assertEquals(0, ll.size());
  }

  @Test
  public void testAppendToEmptyList() {
    LinkedList<String> ll = new LinkedList<String>();

    ll.append("e0");
    Assert.assertEquals(1, ll.size());
    Assert.assertEquals(ll.getFirst(), ll.getLast());
    Assert.assertEquals("e0", ll.getLast());
  }

  @Test
  public void testAppendOfThreeElements() {
    LinkedList<String> ll = new LinkedList<String>();

    ll.append("e0");
    ll.append("e1");
    ll.append("e2");
    Assert.assertEquals(3, ll.size());
    Assert.assertNotEquals(ll.getFirst(), ll.getLast());
    Assert.assertEquals("e0", ll.getFirst());
    Assert.assertEquals("e2", ll.getLast());
  }

  @Test
  public void testAddFirst() {
    LinkedList<String> ll = new LinkedList<String>();
    ll.append("second");
    ll.addFirst("first");
    Assert.assertEquals(2, ll.size());
    Assert.assertEquals("first", ll.getFirst());
    Assert.assertEquals("second", ll.getLast());
    Assert.assertEquals("(first,second)", ll.toString());
  }

  @Test
  public void testRemoveFromThreeElementList() {
    LinkedList<String> ll = new LinkedList<String>();

    ll.append("e0");
    ll.append("e1");
    ll.append("e2");
    String removedElement = ll.removeFirst();

    Assert.assertEquals(2, ll.size());
    Assert.assertEquals("e0", removedElement);
    Assert.assertEquals("e1", ll.getFirst());
    Assert.assertEquals("e2", ll.getLast());
  }

  @Test
  public void testRemoveFromTwoElementList() {
    LinkedList<String> ll = new LinkedList<String>();

    ll.append("e0");
    ll.append("e1");
    String removedElement = ll.removeFirst();

    Assert.assertEquals(1, ll.size());
    Assert.assertEquals("e0", removedElement);
    Assert.assertEquals(ll.getFirst(), ll.getLast());
  }

  @Test
  public void testToStringIncludesAllElements() {
    LinkedList<String> ll = new LinkedList<String>();

    ll.append("e0");
    ll.append("e1");
    Assert.assertEquals("(e0,e1)", ll.toString());
  }

  @Test
  public void testInsert() {
    LinkedList<String> ll = new LinkedList<String>();

    ll.append("a");
    ll.append("b");
    ll.append("d");
    ll.insert(2, "c");

    Assert.assertEquals("(a,b,c,d)", ll.toString());
  }
}
