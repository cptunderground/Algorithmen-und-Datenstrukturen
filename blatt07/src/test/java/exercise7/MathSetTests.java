package exercise7;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class MathSetTests extends TestCase {

  private MathSet<Integer> createEmptyTestset() {
    Integer[] universe = new Integer[10];
    for (int i = 0; i < 10; ++i) {
      universe[i] = i;
    }
    MathSet<Integer> set = new MathSet<>(universe);
    return set;
  }


  private MathSet<Integer> createTwoElementSet() {
    Integer[] universe = new Integer[10];
    for (int i = 0; i < 10; ++i) {
      universe[i] = i;
    }
    MathSet<Integer> set = new MathSet<>(universe);
    set.add(0);
    set.add(1);
    return set;
  }


  @Test
  public void testEmptySetHasSize0() {
    MathSet<Integer> emptyTestset = createEmptyTestset();
    Assert.assertEquals(0, emptyTestset.size());

  }


  @Test
  public void testAddElementToEmptyTestset() {
    MathSet<Integer> testSet = createEmptyTestset();

    Assert.assertEquals(0, testSet.size());
    testSet.add(1);

    Assert.assertEquals(1, testSet.size());
    Assert.assertTrue(testSet.contains(1));

    try {
      testSet.add(1000);

    } catch (IllegalArgumentException expectedException) {
    }
  }

  @Test
  public void testAddAlreadyExistingElement() {

    MathSet<Integer> testSet = createTwoElementSet();

    Assert.assertEquals(2, testSet.size());
    testSet.add(1);
    Assert.assertEquals(2, testSet.size());
  }

  @Test
  public void testDelete() {
    MathSet<Integer> testSet = createTwoElementSet();
    Assert.assertEquals(2, testSet.size());
    testSet.delete(7); // element does not exist
    Assert.assertEquals(2, testSet.size());
    testSet.delete(0);
    Assert.assertEquals(1, testSet.size());
    Assert.assertFalse(testSet.contains(0));
  }


  @Test
  public void testComplementOfTwoElementSet() {
    MathSet<Integer> emptyTestset = createTwoElementSet();
    MathSet<Integer> complement = emptyTestset.complement();

    Assert.assertEquals(8, complement.size());
    for (int i = 3; i < 10; ++i) {
      Assert.assertTrue(complement.contains(i));
    }
    Assert.assertFalse(complement.contains(0));
    Assert.assertFalse(complement.contains(1));
  }


  @Test
  public void testComplementOfEmptyset() {
    MathSet<Integer> emptyTestset = createEmptyTestset();
    MathSet<Integer> complement = emptyTestset.complement();

    Assert.assertEquals(10, complement.size());
    for (int i = 0; i < 10; ++i) {
      Assert.assertTrue(complement.contains(i));
    }

  }

  @Test
  public void testUnion() {
    MathSet<Integer> emptySet = createEmptyTestset();
    MathSet<Integer> testSet = createTwoElementSet();
    testSet.union(emptySet);
    Assert.assertEquals(2, testSet.size());
    testSet.union(testSet.complement());
    Assert.assertEquals(10, testSet.size());

    for (int i = 0; i < 10; ++i) {
      Assert.assertTrue(testSet.contains(i));
    }

  }


  @Test
  public void testIntersection() {
    MathSet<Integer> emptySet = createEmptyTestset();
    MathSet<Integer> testSet = createTwoElementSet();
    MathSet<Integer> testSetWithOneElement = new MathSet(testSet.getUniverse());
    testSetWithOneElement.add(1);

    testSet.intersection(testSet);
    Assert.assertEquals(2, testSet.size());

    testSet.intersection(testSetWithOneElement);
    Assert.assertEquals(1, testSet.size());
    Assert.assertTrue(testSet.contains(1));
    Assert.assertFalse(testSet.contains(2));

    testSet.intersection(testSet.complement());
    Assert.assertEquals(0, testSet.size());
  }

}