package exercise11;

public class LSDSort {

  public static int findLongest(String[] a) {
    int longest = 0;
    for (int i = 0; i < a.length; i++) {
      if (a[i].length() > longest) {
        longest = a[i].length();
      }
    }
    return longest;
  }

  public static char findChar(int i, int d, String[] a) {
    if (d < 0 || d >= a[i].length()) {
      return 0;
    }
    return a[i].charAt(d);
  }

  /**
   * Sortiert ein Array von Strings. Achtung! Die aktuelle Implementation, erwartet, dass alle
   * Strings dieselbe L\"ange haben. Die Implementation basiert auf Listing 5.3, Algorithmen,
   * Sedgewick & Wayne
   */
  public static void sort(String[] a) {

    // checking that all strings have the same lengths

    int N = a.length;
    int R = 256;

    if (N == 0) {
      return;
    }

    int W = findLongest(a);

    String[] aux = new String[N];
    for (int d = W - 1; d >= 0; d--) {

      // Durch schlüsselindiziertes Zählen nach dem d-ten Zeichen sortieren.
      int[] count = new int[R + 1];      // Häufigkeiten berechnen.
      for (int i = 0; i < N; i++) {
        count[findChar(i, d, a) + 1]++;
      }

      for (int r = 0; r < R; r++) { // Häufigkeiten in Indizes umwandeln.
        count[r + 1] += count[r];
      }

      for (int i = 0; i < N; i++) {     // Verteilen.
        aux[count[findChar(i, d, a)]++] = a[i];
      }

      for (int i = 0; i < N; i++) {    // Zurückkopieren.
        a[i] = aux[i];
      }
    }
  }
}
