public class Main {

  /**
   * The method runs insertion sort for an example instance.
   **/
  public static void main(String[] args) {
    int[] array = new int[]{7, 5, 3, 5, 2, 9};
    InsertionSort.sort(array);
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i]);
      System.out.print(" ");
    }
    System.out.println();


    Integer[] a = new Integer[6];
    a[0] = new Integer(7);
    a[1] = new Integer(5);
    a[2] = new Integer(3);
    a[3] = new Integer(5);
    a[4] = new Integer(2);
    a[5] = new Integer(9);
    InsertionSort.sort(a);
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i].toString());
      System.out.print(" ");
    }

  }
}
