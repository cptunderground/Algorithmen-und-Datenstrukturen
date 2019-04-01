import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  /**
   * Test several unit-find implementations.
   **/
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    QuickFind qf = new QuickFind(n);
    QuickUnion qu = new QuickUnion(n);
    RankedQuickUnionWithPathCompression rqu = new RankedQuickUnionWithPathCompression(n);

    Pattern union = Pattern.compile("union ([0-9]+) ([0-9]+)");
    Pattern find = Pattern.compile("find (\\d+)");
    while (in.hasNext()) {
      String line = in.nextLine();
      Matcher unionMatcher = union.matcher(line);
      if (unionMatcher.matches()) {
        int v = Integer.parseInt(unionMatcher.group(1));
        int w = Integer.parseInt(unionMatcher.group(2));
        qf.union(v, w);
        qu.union(v, w);
        rqu.union(v, w);
      } else {
        Matcher findMatcher = find.matcher(line);
        if (findMatcher.matches()) {
          int v = Integer.parseInt(findMatcher.group(1));
          qf.find(v);
          qu.find(v);
          rqu.find(v);
        } else {
          System.out.println("skipped input");
          System.out.println(line);
        }
      }
    }

    System.out.print("Array access operations of QuickFind: ");
    System.out.println(qf.getNumberOfArrayAccesses());
    System.out.print("Array access operations of QuickUnion: ");
    System.out.println(qu.getNumberOfArrayAccesses());
    System.out.print("Array access operations of RankedQuickUnionWithPathCompression: ");
    System.out.println(rqu.getNumberOfArrayAccesses());
  }
}
