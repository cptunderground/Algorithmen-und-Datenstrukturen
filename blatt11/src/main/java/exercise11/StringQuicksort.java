package exercise11;

public class StringQuicksort {

  private static final int CUTOFF = 15;

  public static void sort(String[] a) {
    sort(a, 0, a.length - 1, 0);
  }

  public static void sort(String[] a, int lo, int hi, int d) {

    if (hi <= lo + CUTOFF) {
      insertion(a, lo, hi, d);
      return;
    }

    int lt = lo;
    int gt = hi;
    int v = findChar(a[lo], d);
    int i = lo + 1;
    while (i <= gt) {
      int t = findChar(a[i], d);
      if (t < v) {
        exch(a, lt++, i++);
      } else if (t > v) {
        exch(a, i, gt--);
      } else {
        i++;
      }
    }
    sort(a, lo, lt - 1, d);
    if (v >= 0) {
      sort(a, lt, gt, d + 1);
    }
    sort(a, gt + 1, hi, d);
  }

  private static int findChar(String s, int d) {
    assert d >= 0 && d <= s.length();
    if (d == s.length()) {
      return -1;
    }
    return s.charAt(d);
  }

  private static void exch(String[] a, int i, int j) {
    String temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  private static void insertion(String[] a, int lo, int hi, int d) {
    for (int i = lo; i <= hi; i++) {
      for (int j = i; j > lo && less(a[j], a[j - 1], d); j--) {
        exch(a, j, j - 1);
      }
    }
  }

  private static boolean less(String v, String w, int d) {
    assert v.substring(0, d).equals(w.substring(0, d));
    for (int i = d; i < Math.min(v.length(), w.length()); i++) {
      if (v.charAt(i) < w.charAt(i)) {
        return true;
      }
      if (v.charAt(i) > w.charAt(i)) {
        return false;
      }
    }
    return v.length() < w.length();
  }
}
