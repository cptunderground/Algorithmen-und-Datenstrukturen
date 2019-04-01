public class InsertionSort {

  /**
   * Insertionsort algorithm for int arrays, sorting the input array in place.
   *
   * @param array is the Array to be sorted
   */
  public static void sort(int[] array) {
    // Aufgabe 1 (a)
    int temp;
    for (int i = 1; i < array.length; i++) {
      temp = array[i];
      int j = i - 1;
      while (j >= 0 && array[j] > temp) {
        array[j + 1] = array[j];
        j--;
      }
      array[j + 1] = temp;
    }

  }

  /**
   * Insertionsort algorithm for generic T arrays, sorting the input array in place.
   *
   * @param array is the Array to be sorted
   */
  public static <T extends Comparable<T>> void sort(T[] array) {
    // Aufgabe 1 (d)
    T temp;
    for (int i = 1; i < array.length; i++) {
      temp = array[i];
      int j = i - 1;
      while (j >= 0 && array[j].compareTo(temp) > 0) {
        array[j + 1] = array[j];
        j--;
      }
      array[j + 1] = temp;
    }

  }

}
