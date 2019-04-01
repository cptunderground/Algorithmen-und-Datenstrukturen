package exercise7;

// Hilfsklasse um Mean und Varianz zu speichern.
public class MeanAndVariance {

  private double mean;
  private double variance;

  public MeanAndVariance(double mean, double variance) {
    this.mean = mean;
    this.variance = variance;
  }

  public String toString() {
    return "(" + this.mean + ", " + this.variance + ")";
  }

  double getVariance() {
    return this.variance;
  }

  double getMean() {
    return this.mean;
  }
}
