package exercise6;

import edu.princeton.cs.algs4.BST;

import edu.princeton.cs.algs4.BinarySearchST;
import java.util.Arrays;
import java.util.Random;

public class BSTExperiments {

  static void binarySearch() {
    BST bst = new BST();
    bst.put(49, "");
    bst.put(26, "");
    bst.put(74, "");
    bst.put(15, "");
    bst.put(10, "");
    bst.put(20, "");
    bst.put(60, "");
    bst.put(80, "");

    String strk = "";

    for (Object key : bst.keys()) {
      strk += key.toString() + " ";
    }
    System.out.println("BST: " + strk);

    BinarySearchST binarySearchST = new BinarySearchST();
    binarySearchST.put(49, "");
    binarySearchST.put(26, "");
    binarySearchST.put(74, "");
    binarySearchST.put(15, "");
    binarySearchST.put(10, "");
    binarySearchST.put(20, "");
    binarySearchST.put(60, "");
    binarySearchST.put(80, "");

    strk = "";

    for (Object key : binarySearchST.keys()) {
      strk += key.toString() + " ";
    }
    System.out.println("binarySearchST: " + strk);


  }

  static void testDelete() {
    Random rn = new Random();
    BST<Integer, Integer> lan = new BST<>();
    for (int i = 0; i < rn.nextInt(100); i++) {
      int a = rn.nextInt(1000);
      lan.put(a, a);
    }

  }

  public static void main(String[] args) {

    System.out.println("Running BST Experiments");

    BSTExperiments.binarySearch();
    BSTExperiments.testDelete();
  }
}
