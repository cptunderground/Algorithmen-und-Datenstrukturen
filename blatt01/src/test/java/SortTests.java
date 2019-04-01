import org.junit.Assert;
import org.junit.Test;

public class SortTests  {
  
  @Test
  public void insertionSortShouldCorrectlySortEmptyIntArray() {
    int[] emptyArray = new int[0];
    int[] resultingArray = new int[0];
    InsertionSort.sort(emptyArray);
    Assert.assertArrayEquals(emptyArray, resultingArray);
  }

  @Test
  public void insertionSortShouldCorrectlySortNonemptyIntArray() {
    int[] arrayToSort = new int[] {1, 4, 2, 5, 4};
    int[] resultingArray = new int[] {1, 2, 4, 4, 5};
    InsertionSort.sort(arrayToSort);
    Assert.assertArrayEquals(arrayToSort, resultingArray);
  }

  @Test
  public void insertionSortShouldCorrectlySortEmptyIntegerArray() {
    Integer[] emptyArray = new Integer[0];
    Integer[] resultingArray = new Integer[0];
    InsertionSort.sort(emptyArray);
    Assert.assertArrayEquals(emptyArray, resultingArray);
  }

  @Test
  public void insertionSortShouldCorrectlySortNonemptyIntegerArray() {
    Integer[] arrayToSort = new Integer[] {1, 4, 2, 5, 4};
    Integer[] resultingArray = new Integer[] {1, 2, 4, 4, 5};
    InsertionSort.sort(arrayToSort);
    Assert.assertArrayEquals(arrayToSort, resultingArray);
  }

  @Test
  public void mergeSortShouldCorrectlySortEmptyIntArray() {
    int[] emptyArray = new int[0];
    int[] resultingArray = new int[0];
    MergeSort.sort(emptyArray);
    Assert.assertArrayEquals(emptyArray, resultingArray);
  }

  @Test
  public void mergeSortShouldCorrectlySortNonemptyIntArray() {
    int[] arrayToSort = new int[] {1, 4, 2, 5, 4};
    int[] resultingArray = new int[] {1, 2, 4, 4, 5};
    MergeSort.sort(arrayToSort);
    Assert.assertArrayEquals(arrayToSort, resultingArray);
  }

}
