package exercise7;

import cs.algs4.Queue;
import java.util.LinkedList;

public class DoubleHashingHashST<Key, Value> implements HashST<Key, Value> {

  private static final int INIT_CAPACITY = 17;

  private int n; // number of key-value pairs in the symbol table
  private int m; // size of linear probing table
  private Key[] keys; // the keys
  private Value[] vals; // the values

  public DoubleHashingHashST() {
    this(INIT_CAPACITY);
  }

  public DoubleHashingHashST(int capacity) {
    m = getPrime(capacity);
    n = 0;
    keys = (Key[]) new Object[m];
    vals = (Value[]) new Object[m];
  }

  public int getCapacity() {
    return this.m;
  }

  // hash function for keys - returns value between 0 and M-1
  private int hash(Key key) {
    return (key.hashCode() & 0x7fffffff) % m;
  }

  private int hash2(Key key) {
    return (hash(key) % (m-2)) + 1;
  }


  @Override
  public Value get(Key key) {
    int index = hash(key);
    if (keys[index] != null && !keys[index].equals(key)) {
      int index2 = hash2(key);
      int i = 1;
      while (true) {
        int newIndex = (index + i * index2) % m;
        if (keys[newIndex].equals(key)) {
          Value val = vals[newIndex];
//          vals[newIndex] = null;
//          keys[newIndex] = null;
//          n--;
          return val;
        }
        if (keys[newIndex] == null) {
          return null;
        }
        i++;
      }
    } else {
      return vals[index];
    }
  }

  @Override
  public void put(Key key, Value val) {
    int index = hash(key);
    if (keys[index] != null) {

      if (n == m) {
        resize(m * 2);
      }

      int index2 = hash2(key);
      int i = 1;
      while (true) {
        int newIndex = (index + i * index2) % m;
        if (keys[newIndex] == null) {
          keys[newIndex] = key;
          vals[newIndex] = val;
          n++;
          break;
        }
        i++;
      }
    } else {
      keys[index] = key;
      vals[index] = val;
      n++;
    }
  }

  /**
   * Returns the number of key-value pairs in this symbol table.
   *
   * @return the number of key-value pairs in this symbol table
   */
  public int size() {
    return n;
  }

  /**
   * Returns true if this symbol table is empty.
   *
   * @return {@code true} if this symbol table is empty; {@code false} otherwise
   */
  public boolean isEmpty() {
    return size() == 0;
  }

  /**
   * Returns true if this symbol table contains the specified key.
   *
   * @param key the key
   * @return {@code true} if this symbol table contains {@code key}; {@code false} otherwise
   * @throws IllegalArgumentException if {@code key} is {@code null}
   */
  public boolean contains(Key key) {
    if (key == null) {
      throw new IllegalArgumentException("argument to contains() is null");
    }
    return this.get(key) != null;
  }

  private void resize(int capacity) {
    DoubleHashingHashST<Key, Value> temp = new DoubleHashingHashST<>(capacity);
    for (int i = 0; i < m; i++) {
      if (keys[i] != null) {
        temp.put(keys[i], vals[i]);
      }
    }
    keys = temp.keys;
    vals = temp.vals;
    m = temp.m;
    n = temp.n;
  }

  public MeanAndVariance getMeanAndVarianceOfClusterLengths() {

    LinkedList<Double> linkedList = new LinkedList<>();
    double size = 0;
    double mean = 0;
    for (int i = 0; i < m; i++) {
      if (keys[i] != null) {
        size++;
      } else {
        if (size != 0) {
          linkedList.add(size);
          size = 0;
        }
      }
    }

    for (double num : linkedList) {
      mean = num + mean;
    }

    mean = mean / linkedList.size();

    double var = 0;
    for (double b : linkedList) {
      var += (b - mean) * (b - mean);
    }

    var = var / (linkedList.size() - 1);

    MeanAndVariance result = new MeanAndVariance(mean, var);
    return result;
  }

  /**
   * Returns all keys in this symbol table as an {@code Iterable}. To iterate over all of the keys
   * in the symbol table named {@code st}, use the foreach notation: {@code for (Key key :
   * st.keys())}.
   *
   * @return all keys in this symbol table
   */
  public Iterable<Key> keys() {
    Queue<Key> queue = new Queue<Key>();
    for (int i = 0; i < m; i++) {
      if (keys[i] != null) {
        queue.enqueue(keys[i]);
      }
    }
    return queue;
  }

  /**
   * Returns a primenumber lower than capacity.
   */
  public int getPrime(int capacity) {
    for (int i = capacity - 1; i >= 1; i--) {
      int fact = 0;
      for (int j = 2; j <= (int) Math.sqrt(i); j++) {
        if (i % j == 0) {
          fact++;
        }
      }
      if (fact == 0) {
        return i;
      }
    }
    /* Return a prime number */
    return 3;
  }

}
