package exercise7;

import cs.algs4.BST;
import cs.algs4.RedBlackBST;
import java.util.Random;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.util.ArrayList;

public class RedBlackBSTExperiment {

  public static Random rn = new Random();
  public static ArrayList<Double> N = new ArrayList<>();
  public static ArrayList<Double> dataBST = new ArrayList<>();
  public static ArrayList<Double> dataRB = new ArrayList<>();


  private static void plotData(
      ArrayList<Double> Ns,
      ArrayList<Double> comparisonDataBST,
      ArrayList<Double> comparisonDataRBST) {

    if (Ns.size() != comparisonDataBST.size()
        || comparisonDataBST.size() != comparisonDataRBST.size()) {
      throw new IllegalArgumentException("all arrays need to be of the same size");
    }

    // Create Chart
    XYChart chart = QuickChart
        .getChart("RBST/BST Comparison", "X", "Y", "BST", Ns, comparisonDataBST);

    chart.addSeries("RBST", Ns, comparisonDataRBST);

    // Show it
    new SwingWrapper(chart).displayChart();
  }

  private static void plotNumberOfComparisonsForPut() {

    BST<Integer, Integer> bst = new BST<>();
    RedBlackBST<Integer, Integer> rb = new RedBlackBST<>();

    for (int i = 0; i < 100000; i++) {

      bst.put(rn.nextInt(), rn.nextInt());
      rb.put(rn.nextInt(), rn.nextInt());

      N.add((double) i);
      dataBST.add(BST.counter);
      dataRB.add(RedBlackBST.counter);
      BST.counter = 0;
      RedBlackBST.counter = 0;

    }

    plotData(N, dataBST, dataRB);


  }

  public static void main(String[] args) {

    plotNumberOfComparisonsForPut();
  }
}
