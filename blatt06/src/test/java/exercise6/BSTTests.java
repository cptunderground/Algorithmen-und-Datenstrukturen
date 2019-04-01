package exercise6;

import edu.princeton.cs.algs4.BST;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class BSTTests extends TestCase {

  @Test
  public void testSomethingAboutRank() {
    BST<Integer, Integer> gaytree = new BST<>();
    gaytree.put(1, 1);
    Assert.assertEquals(0, gaytree.rank(1));
  }

  @Test
  public void testAnotherThingAboutRank() {
    BST<Integer, Integer> gaytree = new BST<>();
    gaytree.put(1, 1);
    gaytree.put(2, 2);
    gaytree.put(3, 3);
    Assert.assertEquals(0, gaytree.rank(1));
    Assert.assertEquals(1, gaytree.rank(2));
    Assert.assertEquals(2, gaytree.rank(3));
  }

  // more tests for rank go here

  @Test
  public void testSomethingAboutFloor() {
    BST<Integer, Integer> gaytree = new BST<>();
    gaytree.put(1, 1);
    gaytree.put(2, 2);
    gaytree.put(3, 3);
    Assert.assertEquals((Integer) 2, gaytree.floor(2));
    Assert.assertEquals((Integer) 3, gaytree.floor(123123));
  }

  @Test
  public void testAnotherThingAboutFloor() {
    BST<Integer, Integer> lantree = new BST<>();
    lantree.put(5, 5);
    Assert.assertEquals(null, lantree.floor(2)
    );
  }

  // more tests for floor go here

  @Test
  public void testSomethingAboutSelect() {
    BST<Integer, Integer> gaytree = new BST<>();
    gaytree.put(1, 1);
    gaytree.put(2, 2);
    gaytree.put(3, 3);
    Assert.assertEquals((Object) 3, gaytree.select(2));
    Assert.assertEquals((Object) 2, gaytree.select(1));
  }

  @Test
  public void testAnotherThingAboutSelect() {
    BST<Integer, Integer> gaytree = new BST<>();
    gaytree.put(1, 1);
    gaytree.put(2, 2);
    gaytree.put(5, 5);
    gaytree.put(7, 7);
    gaytree.put(3, 3);
    Assert.assertEquals((Object) 7, gaytree.select(4));
    Assert.assertEquals((Object) 5, gaytree.select(3));
    Assert.assertEquals(true, true);
  }

  // more tests for select go here

  @Test
  public void testSomethingAboutKeys() {
    BST<Integer, Integer> gaytree = new BST<>();
    gaytree.put(1, 1);
    gaytree.put(2, 2);
    gaytree.put(5, 5);
    gaytree.put(7, 7);
    gaytree.put(3, 3);
    String iter = "1 2 3 5 7 ";
    String gT = gaytree.keys().toString();
    Assert.assertEquals(iter, gT);
  }

  @Test
  public void testAnotherThingAboutKeys() {
    BST<Integer, Integer> gaytree = new BST<>();
    gaytree.put(1, 1);
    gaytree.put(2, 2);
    gaytree.put(5, 5);
    gaytree.put(7, 7);
    gaytree.put(3, 3);
    String iter = "3 5 7 ";
    String gT = gaytree.keys(3, 7).toString();
    Assert.assertEquals(iter, gT);
  }

  // more tests for keys go here

  //======================================
  // Testing the averagePath length
  //======================================
  /*
  @Test
  public void testAveragePathLengthForTreeWithOneNode() {
    BST<Integer, Integer> bst = new BST();
    bst.put(5, 5);
    System.out.println(bst.averagePathLength());
    Assert.assertTrue(Math.abs(0.0 - bst.averagePathLength()) < 1e-8);
  }

  @Test
  public void testAveragePathLengthForLinearTree() {
    BST<Integer, Integer> bst = new BST();
    for (int i = 0; i < 5; ++i) {
      bst.put(i, i);
    }
    System.out.println(bst.averagePathLength());
    double sumDepth = 0 + 1 + 2 + 3;
    double numInternal = 4.0;
    Assert.assertTrue(Math.abs(sumDepth / numInternal - bst.averagePathLength()) < 1e-8);
  }

  @Test
  public void testAveragePathLengthForPerfectTreeOfHeight2() {
    BST<Integer, Integer> bst = new BST();
    bst.put(8, 0);
    bst.put(1, 0);
    bst.put(0, 0);
    bst.put(7, 0);
    bst.put(16, 0);
    bst.put(15, 0);
    bst.put(22, 0);

    System.out.println(bst.averagePathLength());
    double numInternal = 3;
    double sumDepth = 0 + 1 + 1;
    Assert.assertTrue(Math.abs(sumDepth / numInternal - bst.averagePathLength()) < 1e-8);
  }

  @Test
  public void testAveragePathLengthForJustSomeTree() {
    BST<Integer, Integer> bst = new BST();
    bst.put(8, 0);
    bst.put(1, 0);
    bst.put(7, 0);
    bst.put(16, 0);

    double numInternal = 2;
    double sumDepth = 0 + 1;
    Assert.assertTrue(Math.abs(sumDepth / numInternal - bst.averagePathLength()) < 1e-8);
  }*/
}
