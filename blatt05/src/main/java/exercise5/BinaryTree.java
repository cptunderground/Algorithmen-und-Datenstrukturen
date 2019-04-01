package exercise5;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Implementation of a Binary Tree class. Note, that in this implementation, the empty tree is
 * represented by the null value.
 */
public class BinaryTree<T> {

  private T item = null;
  private BinaryTree<T> left = null;
  private BinaryTree<T> right = null;

  /**
   * creates a tree, consisting of the root only
   */
  public BinaryTree(T item) {
    this.item = item;
  }

  /**
   * returns the left subtree
   */
  public BinaryTree<T> getLeft() {
    return this.left;
  }

  /**
   * returns the right subtree
   */
  public BinaryTree<T> getRight() {
    return this.right;
  }

  /**
   * attaches a new Binary tree as the left subtree of this tree
   */
  void attachLeft(BinaryTree<T> leftSubtree) {
    this.left = leftSubtree;
  }

  /**
   * attaches a new Binary tree as the right subtree of this tree
   */
  void attachRight(BinaryTree<T> rightsubtree) {
    this.right = rightsubtree;
  }

  /**
   * Returns true if this tree is a leaf node, false otherwise
   */
  public boolean isLeaf() {
    if (this.left == null && this.right == null) {
      return true;
    }
    return false;
  }

  /**
   * Returns the height of the tree
   */
  public int height() {
    if (this.left != null && this.right != null) {
      return 1 + Math.max(this.left.height(), this.right.height());
    }
    if (this.left == null && this.right == null) {
      return 0;
    }
    if (this.left != null) {
      return 1 + this.left.height();
    }
    if (this.right != null) {
      return 1 + this.right.height();
    }
    return 0;
  }

  /**
   * Return the number of nodes in the tree
   */

  public int size() {
    if (this.left != null && this.right != null) {
      return this.left.size() + this.right.size() + 1;
    }
    if (this.left == null && this.right == null) {
      return 1;
    }
    if (this.left != null) {
      return 1 + this.left.size();
    }
    if (this.right != null) {
      return 1 + this.right.size();
    }
    return 1;
  }

  /**
   * Returns true if the tree contains the element "Item", false otherwise
   */
  public boolean contains(T item) {
    if (item.equals(this.item)) {
      return true;
    }
    if (this.left != null && this.left.contains(item)) {
      return true;
    }
    if (this.right != null && this.right.contains(item)) {
      return true;
    }
    return false;
  }

  /**
   * Returns true if this tree is a perfect binary tree
   */

  public boolean isPerfect() {
    if (Math.pow(2, this.height() + 1) - 1 == this.size()) {
      return true;
    }
    return false;
  }

  /**
   * Returns true if this tree is a full binary tree
   */
  public boolean isFull() {
    if (this.left == null && this.right == null) {
      return true;
    }
    if (this.left != null && this.right != null) {
      return this.left.isFull() && this.right.isFull();
    }
    return false;
  }

  /**
   * traverses the list and prints out all the elements
   */
  public void traverseInorder() {
    BinaryTree treeElement = this;
    Stack<BinaryTree<T>> stack = new Stack<>();

    while (treeElement != null) {
      stack.push(treeElement);
      treeElement = treeElement.getLeft();
    }
    while (stack.size() > 0) {
      treeElement = stack.pop();
      System.out.println(treeElement.item.toString());
      if (treeElement.getRight() != null) {
        treeElement = treeElement.getRight();
        while (treeElement != null) {
          stack.push(treeElement);
          treeElement = treeElement.getLeft();
        }
      }
    }
  }

  /**
   * Prints a tree, such that the individual levels of the tree are printed on one line each.
   */
  public void prettyPrint() {
    prettyPrintHelp();
    System.out.println("");
  }

  private void prettyPrintHelp() {
    if (this == null) {
      System.out.println("null");
      return;
    }

    // Pick a pretty indent.
    System.out.print(this.item + " ");
    if (this.right != null) {
      System.out.println("");
      this.right.prettyPrintHelp();
      if (this.left == null) {
        System.out.println("");
      }
    }

    if (this.left != null) {
      if (this.right == null) {
        System.out.println("");
      }
      this.left.prettyPrintHelp();
    }
  }
}
