public class Main {

  /** The method runs radix sort sort for an example instance. **/
  public static void main(String[] args) {
    int[] array = new int[] {763, 983, 96, 286, 462};
    RadixSort.sort(array);
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i]);
      System.out.print(" ");
    }
    System.out.println();
  }
}
