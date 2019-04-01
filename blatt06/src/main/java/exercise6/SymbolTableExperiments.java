package exercise6;

import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.BinarySearchST;
import edu.princeton.cs.algs4.SequentialSearchST;
import exercise6.utils.Stopwatch;

import java.util.Random;

public class SymbolTableExperiments {

  static double sequentialSearchVsBinarySearchST(int N) {
    SequentialSearchST<Double, String> SSST = new SequentialSearchST<>();
    BinarySearchST<Double, String> BSST = new BinarySearchST<>();
    for (int i = 0; i < N; i++) {
      Double key = Math.random();
      SSST.put(key, "");
      BSST.put(key, "");
    }

    // Implementation goes here

    long rn = new Random().nextLong();
    Random random = new Random(rn);
    int searches = 100000;

    Stopwatch stopwatch = new Stopwatch();

    for (int i = 0; i < searches; i++) {
      SSST.contains(random.nextDouble());
    }
    double sequentialTime = stopwatch.elapsedTime();

    random = new Random(rn);
    stopwatch = new Stopwatch();

    for (int i = 0; i < searches; i++) {
      BSST.contains(random.nextDouble());
    }
    double binaryTime = stopwatch.elapsedTime();

    System.out.println(sequentialTime);
    System.out.println(binaryTime);

    return sequentialTime / binaryTime;

  }

  static double binarySearchVsBST(int N) {

    int numRepeats = (int) (10000 / Math.log(N));

    BinarySearchST<Double, Double> binarySearchST = new BinarySearchST<>();
    BST<Double, Double> binarySearchTree = new BST<>();
    long seed = new Random().nextLong();
    Random random = new Random(seed);

    Stopwatch stopwatch = new Stopwatch();

    for (int x = 0; x <= numRepeats; x++) {
      for (int i = 0; i < N; i++) {
        binarySearchST.put(random.nextDouble(), 2.0);
      }
    }

    double binarySearchTime = stopwatch.elapsedTime();
    random = new Random(seed);

    stopwatch = new Stopwatch();
    for (int x = 0; x <= numRepeats; x++) {
      for (int i = 0; i < N; i++) {
        binarySearchTree.put(random.nextDouble(), 2.0);
      }
    }
    double binaryTreeTime = stopwatch.elapsedTime();
    System.out.println(N);
    System.out.println(binarySearchTime);
    System.out.println(binaryTreeTime);

    return binarySearchTime / binaryTreeTime;
  }

  public static void main(String[] args) {

    System.out.println("Running Symbol Table Experiments");

    // run your tests
    double ratio;
    int N = 2;
    do {
      N *= 2;
      //ratio = binarySearchVsBST(N);
      ratio = sequentialSearchVsBinarySearchST(N);
    } while (ratio < 10);
    System.out.println("N: " + N);
    System.out.println("Ratio: " + ratio);

    //binarySearchVsBST(1);
  }
}