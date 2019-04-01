import org.junit.Assert;
import org.junit.Test;

public class SortTests {

  @Test
  public void radixSortShouldCorrectlySortEmptyIntArray() {
    int[] emptyArray = new int[0];
    int[] resultingArray = new int[0];
    RadixSort.sort(emptyArray, 10);
    Assert.assertArrayEquals(emptyArray, resultingArray);
  }

  @Test
  public void radixSortShouldCorrectlySortArrayWithSmallNumbersAndBase10() {
    int[] arrayToSort = new int[]{1, 4, 2, 5, 4};
    int[] resultingArray = new int[]{1, 2, 4, 4, 5};
    RadixSort.sort(arrayToSort, 10);
    Assert.assertArrayEquals(arrayToSort, resultingArray);
  }

  @Test
  public void radixSortShouldCorrectlySortArrayWithBigNumbersAndBase10() {
    int[] arrayToSort = new int[]{100, 423, 223, 513, 429};
    int[] resultingArray = new int[]{100, 223, 423, 429, 513};
    RadixSort.sort(arrayToSort, 10);
    Assert.assertArrayEquals(arrayToSort, resultingArray);
  }

  @Test
  public void radixSortShouldCorrectlySortArrayWithSmallNumbersAndBaseN() {
    int[] n = new int[]{2, 3, 4, 5};
    int[] arrayToSort = new int[]{1, 4, 2, 5, 4};
    int[] resultingArray = new int[]{1, 2, 4, 4, 5};

    for (int i : n) {
      RadixSort.sort(arrayToSort, i);
      Assert.assertArrayEquals(arrayToSort, resultingArray);
    }
  }

  @Test
  public void radixSortShouldCorrectlySortArrayWithBigNumbersAndBaseN() {
    int[] n = new int[]{1, 2, 3, 4, 5};
    int[] arrayToSort = new int[]{100, 423, 223, 513, 429};
    int[] resultingArray = new int[]{100, 223, 423, 429, 513};
    for (int i = 2; i < 10; i++) {
      RadixSort.sort(arrayToSort, i);
      Assert.assertArrayEquals(arrayToSort, resultingArray);
    }
  }

  /* add more test cases here */
}
