package exercise5;

import java.util.List;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;


public class BinaryTreeTests extends TestCase {

  BinaryTree<String> oneElementTree = new BinaryTree<String>("root");
  BinaryTree<String> threeElementPerfectTree = buildThreeElementPerfectTree();
  BinaryTree<String> fiveElementListLikeTree = buildFiveElementListLikeTree();
  BinaryTree<String> fourElementTree = buildFourElementTree();

  private BinaryTree<String> buildFourElementTree() {
    BinaryTree<String> root = new BinaryTree<>("root");
    root.attachLeft(new BinaryTree<>("left"));
    root.attachRight(new BinaryTree<>("right"));
    root.getLeft().attachLeft(new BinaryTree<>("leftleft"));
    return root;
  }

  private BinaryTree<String> buildThreeElementPerfectTree() {
    BinaryTree<String> root = new BinaryTree<>("root");
    root.attachLeft(new BinaryTree<>("left"));
    root.attachRight(new BinaryTree<>("right"));
    return root;
  }

  private BinaryTree<String> buildFiveElementListLikeTree() {
    BinaryTree<String> root = new BinaryTree<>("root");
    BinaryTree<String> currentRoot = root;
    for (int i = 0; i < 4; ++i) {
      currentRoot.attachLeft(new BinaryTree<>("left" + i));
      currentRoot = currentRoot.getLeft();
    }
    return root;
  }

  @Test
  public void testIsLeaf() {
    Assert.assertTrue(oneElementTree.isLeaf());
    Assert.assertTrue(
        !threeElementPerfectTree.isLeaf()
            && threeElementPerfectTree.getLeft().isLeaf()
            && threeElementPerfectTree.getRight().isLeaf());
  }

  @Test
  public void testContains() {
    Assert.assertTrue(oneElementTree.contains("root"));
    Assert.assertTrue(
        threeElementPerfectTree.contains("root")
            && threeElementPerfectTree.contains("left")
            && threeElementPerfectTree.contains("right")
            && !threeElementPerfectTree.contains("cannotbefound"));
  }

  @Test
  public void testHeight() {
    Assert.assertEquals(0, oneElementTree.height());
    Assert.assertEquals(1, threeElementPerfectTree.height());
    Assert.assertEquals(4, fiveElementListLikeTree.height());
    Assert.assertEquals(2, fourElementTree.height());
  }

  @Test
  public void testSize() {
    Assert.assertEquals(1, oneElementTree.size());
    Assert.assertEquals(3, threeElementPerfectTree.size());
    Assert.assertEquals(5, fiveElementListLikeTree.size());
    Assert.assertEquals(4, fourElementTree.size());
  }

  @Test
  public void testFullTree() {

    Assert.assertTrue(oneElementTree.isFull());
    Assert.assertTrue(threeElementPerfectTree.isFull());
    Assert.assertFalse(fiveElementListLikeTree.isFull());
    Assert.assertFalse(fourElementTree.isFull());
  }

  @Test
  public void testIsPerfect() {
    Assert.assertTrue(oneElementTree.isPerfect());
    Assert.assertTrue(threeElementPerfectTree.isPerfect());
    Assert.assertFalse(fiveElementListLikeTree.isPerfect());
    Assert.assertFalse(fourElementTree.isPerfect());
  }

  @Test
  public void testInorderTraversal() {
    // not a real test. Check console output to see if it is right
    System.out.println("One Element Tree");
    oneElementTree.traverseInorder();
    System.out.println("Three element Tree");
    threeElementPerfectTree.traverseInorder();
    System.out.println("Four element Tree");
    fourElementTree.traverseInorder();
  }

  @Test
  public void testPrettyPrint() {
    // not a real test. Check console output to see if it is right
    System.out.println("One Element Tree");
    oneElementTree.prettyPrint();
    System.out.println("Three element Tree");
    threeElementPerfectTree.prettyPrint();
    System.out.println("Four element Tree");
    fourElementTree.prettyPrint();
  }
}
