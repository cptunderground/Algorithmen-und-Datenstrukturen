import java.util.ArrayList;

public class RadixSort {

  /**
   * Weiterleitung wenn keine Basis gegeben wird.
   *
   * @param array input array
   */
  public static void sort(int[] array) {
    sort(array, 10);
  }

  /**
   * Radixsort algorithm for int arrays.
   **/
  public static void sort(int[] array, int base) {
    if (array.length <= 1) {
      return;
    }
    int iter = 0;
    int max = getMax(array);
    if (max < 10) {
      base = 2;
    }
    ArrayList<Integer>[] buckets = new ArrayList[base];
    while ((base ^ iter) <= max) {
      for (int i = 0; i < buckets.length; i++) {
        buckets[i] = new ArrayList<Integer>();
      }

      for (int elem : array) {
        int digit = (int) ((elem / Math.pow(base, iter)) % base);
        buckets[digit].add(elem);
      }
      int pos = 0;
      for (ArrayList<Integer> bucket : buckets) {
        for (int elem : bucket) {
          array[pos] = elem;
          pos++;
        }
      }
      iter++;


    }


    // Implement Radixsort here (using buckets array from above)


  }

  /**
   * Findet maximal Wert des Arrays.
   *
   * @param array input array
   * @return max value
   */
  public static int getMax(int[] array) {
    int max = array[0];
    for (int i = 0; i < array.length; i++) {
      if (array[i] > max) {
        max = array[i];
      }
    }
    return max;
  }


  /**
   * Print buckets as used by Radixsort (for debugging purposes).
   **/
  public static void printBuckets(ArrayList<Integer>[] buckets) {
    for (int i = 0; i < buckets.length; i++) {
      System.out.print(i + ": ");
      for (Integer entry : buckets[i]) {
        System.out.print(entry + " ");
      }
      System.out.println();
    }
  }
}
