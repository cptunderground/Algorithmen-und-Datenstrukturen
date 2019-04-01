import java.lang.Math;
import java.util.Scanner;

public class Arbitrage {

  /**
   * Checks currency exchange rates for arbitrage opportunities.
   *
   * <p> If there is an arbitrage opportunity it prints an example trade starting with 100000
   * currency units to standard output. Otherwise it reports that there is no such opportunity.
   * </p>
   *
   * @param currencyNames the names of the currencies
   * @param exchangeRates contains at position [i][j] the exchange rate from currency i to currency
   * j
   */
  public static void computeArbitrage(String[] currencyNames, double[][] exchangeRates) {
    // TODO implement (consider JavaDoc from above)

  }

  /**
   * Reads currency exchange rates from standard input and calls computeArbitrage.
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int noCurrencies = in.nextInt();
    String[] currencyNames = new String[noCurrencies];
    double[][] exchangeRates = new double[noCurrencies][];

    for (int i = 0; i < noCurrencies; i++) {
      currencyNames[i] = in.next();
      exchangeRates[i] = new double[noCurrencies];
      for (int j = 0; j < noCurrencies; j++) {
        exchangeRates[i][j] = in.nextDouble();
      }
    }
    computeArbitrage(currencyNames, exchangeRates);
  }
}
