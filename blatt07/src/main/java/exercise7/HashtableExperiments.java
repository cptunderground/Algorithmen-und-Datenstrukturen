package exercise7;

import java.util.Random;

public class HashtableExperiments {

  public static void main(String[] args) {
    for (int j = 1; j < 6; j++) {
      LinearProbingHashST LHT = new LinearProbingHashST((int)Math.pow(10,j));
      Random r = new Random();
      for (int i = 0; i < LHT.getCapacity() / 2; ++i) {
        LHT.put(r.nextInt(), i);
      }

      MeanAndVariance mv = LHT.getMeanAndVarianceOfClusterLengths();
      System.out.println(mv);

      DoubleHashingHashST DHT = new DoubleHashingHashST((int)Math.pow(10,j));
      for (int i = 0; i < DHT.getCapacity() / 2; ++i) {
        DHT.put(r.nextInt(), i);
      }

      mv = DHT.getMeanAndVarianceOfClusterLengths();
      System.out.println(mv);
    }
  }
}
