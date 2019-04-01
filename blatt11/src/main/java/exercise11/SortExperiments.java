package exercise11;

import exercise11.utils.Stopwatch;

import java.util.Random;

public class SortExperiments {

  private static Random rn = new Random();

  /**
   * Generates N random strings of size W, consisting of the alphabetic characters a-z,A-Z
   *
   * @param N the number of strings to be generated
   * @param W the lengths of the strings
   */
  public static String[] randomFixedLengthWords(int N, int W) {

    String[] strings = new String[N];
    for (int i = 0; i < strings.length; i++) {
      String s = "";
      for (int j = 0; j < W; j++) {
        int[] cases = {65, 97};
        int r = rn.nextInt(26);
        char ascii = (char) (cases[rn.nextInt(2)] + r);
        s += ascii;
      }
      strings[i] = s;
    }

    return strings;
  }


  /**
   * Generates N random strings of size W with a common prefix of size P
   */
  public static String[] randomItemsWithCommonPrefix(int N, int P, int W) {
    String[] strings = new String[N];
    String prefix = randomFixedLengthWords(1, P)[0];
    strings = randomFixedLengthWords(N, W - P);

    for (int i = 0; i < N; i++) {
      strings[i] = prefix + strings[i];
    }

    return strings;
  }

  public static void main(String[] args) {

    System.out.println("random Strings");
    for (int i = 1; i <= 10000; i = i * 10) {

      String[] so = randomFixedLengthWords(1000, i);

      Stopwatch watch = new Stopwatch();
      LSDSort.sort(so.clone());
      System.out.println("LSD without prefix");
      System.out.println(watch.elapsedTime());

      watch = new Stopwatch();
      StringQuicksort.sort(so.clone());
      System.out.println("Quick without prefix");
      System.out.println(watch.elapsedTime());

    }
    System.out.println("growing prefix");
    for (int i = 0; i < 5; i++) {
      System.out.println();
    }

    for (int i = 1; i <= 1000; i = i*10) {
      String[] sm = randomItemsWithCommonPrefix(1000, i, 6000);


      Stopwatch watch = new Stopwatch();
      LSDSort.sort(sm.clone());
      System.out.println("LSD with prefix");
      System.out.println(watch.elapsedTime());

      watch = new Stopwatch();
      StringQuicksort.sort(sm.clone());
      System.out.println("Quick with prefix");
      System.out.println(watch.elapsedTime());

    }
  }

}
