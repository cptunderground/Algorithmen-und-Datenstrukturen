public class MergeSort {

  /**
   * Mergesort algorithm for int arrays.
   **/
  public static void sort(int[] array) {
    // Aufgabe 2 (c)
    int[] tmp = new int[array.length];
    sort(array, tmp, 0, array.length - 1);
  }


  /**
   * Sortiert das array zwischen Positionen lo und (einschliesslich) hi.
   **/
  private static void sort(int[] array, int[] tmp, int low, int high) {
    // Aufgabe 2 (c)
    if (high - low <= 0) {
      return;
    }
    int mid = (high - low) / 2 + low;
    sort(array, tmp, low, mid);
    sort(array, tmp, mid + 1, high);
    merge(array, tmp, low, mid, high);

  }

  /**
   * Die Methode kombiniert zwei bereits sortierte, benachbarte Teilbereiche des
   * Eingabearrays zu einer sortierten Folge.
   * Es wird angenommen, dass array[lo] bis array[mid] und array[mid + 1] bis
   * array[hi] bereits korrekt sortiert sind. Die sortierte Folge befindet sich
   * am Ende in array[lo] bis array[hi].
   **/
  private static void merge(int[] array, int[] tmp, int lo, int mid, int hi) {
    // Aufgabe 2 (b)
    int i = lo;
    int j = mid + 1;

    for (int k = lo; k < hi + 1 ; k++) {
      if (j > hi || (i <= mid && array[i] <= array[j])){
        tmp[k] = array[i];
        i++;
      } else {
        tmp[k] = array[j];
        j++;
      }
    }

    for (int k = lo; k < hi + 1; k++) {
      array[k] = tmp[k];
    }

    /*
    int left = lo;
    int index = left;
    int right = mid + 1;
    while (left <= mid && right <= hi) {
      if (array[left] <= array[right]) {
        tmp[index] = array[left];
        left++;
      } else {
        tmp[index] = array[right];
        right++;
      }
      index++;
    }

    if (mid - left + 1 == 0) {
      for (int i = 0; i < hi - right + 1; i++) {
        tmp[index + i] = array[right + i];
      }
    } else if (hi - right + 1 == 0) {
      for (int i = 0; i < mid - left + 1; i++) {
        tmp[index + i] = array[left + i];
      }
    }

    for (int i = lo; i < hi + 1; i++) {
      array[i] = tmp[i];
    }*/
  }

}
