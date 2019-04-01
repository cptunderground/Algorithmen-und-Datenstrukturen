package exercise11;

import org.junit.Assert;
import org.junit.Test;

public class LSDSortTests {

  private boolean isSortedInAscendingOrder(String[] a) {
    boolean sortedInAscendingOrder = true;
    if (a.length == 0) {
      return true;
    }

    for (int i = 0; i < a.length - 1; ++i) {
      sortedInAscendingOrder = sortedInAscendingOrder && (a[i].compareTo(a[i + 1]) <= 0);
    }
    return sortedInAscendingOrder;
  }

  @Test
  public void correctlySortsAnEmptyArray() {
    String[] emptyArray = new String[0];

    LSDSort.sort(emptyArray);
    Assert.assertEquals(0, emptyArray.length);
  }

  @Test
  public void correctlySortsARandomStringArrayOfFixedWithStrings() {
    String[] a = {"an", "ap", "is", "an", "an", "th", "ca", "cl", "tr"};

    LSDSort.sort(a);
    Assert.assertEquals(9, a.length);
    Assert.assertTrue(isSortedInAscendingOrder(a));

  }

  @Test
  public void correctlySortsARandomStringArrayOfVariableWithStrings() {
    String[] a = {"an", "ape", "is", "an", "animal", "that", "can", "climb", "trees"};

    LSDSort.sort(a);
    Assert.assertEquals(9, a.length);
    Assert.assertTrue(isSortedInAscendingOrder(a));

  }


}
