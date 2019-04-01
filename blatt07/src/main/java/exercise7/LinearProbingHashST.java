package exercise7;

import cs.algs4.Queue;
import java.util.LinkedList;

/**
 * This class is based on the code of LinearProbingHashST, by Robert Sedgewick & Kevin Wayne,
 * provided at https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/LinearProbingHashST.java.html
 * It thus can be freely distributed and modified under the terms of the GNU Public License (GPL 3)
 */
public class LinearProbingHashST<Key, Value> implements HashST<Key, Value> {

  private static final int INIT_CAPACITY = 17;

  private int n; // number of key-value pairs in the symbol table
  private int m; // size of linear probing table
  private Key[] keys; // the keys
  private Value[] vals; // the values

  public LinearProbingHashST() {
    this(INIT_CAPACITY);
  }

  public LinearProbingHashST(int capacity) {
    m = capacity;
    n = 0;
    keys = (Key[]) new Object[capacity];
    vals = (Value[]) new Object[capacity];
  }

  public int getCapacity() {
    return this.m;
  }

  public void put(Key key, Value val) {
    if (key == null) {
      throw new IllegalArgumentException("first argument to put() is null");
    }

    // double table size if 50% full
    if (n >= m / 2) {
      resize(2 * m);
    }

    int i;
    for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
      if (keys[i].equals(key)) {
        vals[i] = val;
        return;
      }
    }
    keys[i] = key;
    vals[i] = val;
    n++;
  }

  public Value get(Key key) {
    if (key == null) {
      throw new IllegalArgumentException("argument to get() is null");
    }
    for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
      if (keys[i].equals(key)) {
        return vals[i];
      }
    }
    return null;
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

  public MeanAndVariance getMeanAndVarianceOfClusterLengths() {

    LinkedList<Double> linkedList = new LinkedList<>();
    double size = 0;
    double mean = 0;
    for ( int i = 0 ; i < m; i ++){
      if (keys[i] != null){
        size++;
      }
      else {
        if(size != 0) {
          linkedList.add(size);
          size = 0;
        }
      }
    }

    for( double num : linkedList){
      mean = num + mean;
    }

    mean = mean/linkedList.size();

    double var = 0;
    for( double b : linkedList){
      var += (b-mean) * (b-mean);
    }

    var = var/(linkedList.size()-1);

    MeanAndVariance result = new MeanAndVariance(mean,var);
    return result;}

  private void resize(int capacity) {

    LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<>(capacity);
    for (int i = 0; i < m; i++) {
      if (keys[i] != null) {
        temp.put(keys[i], vals[i]);
      }
    }
    keys = temp.keys;
    vals = temp.vals;
    m = temp.m;
  }

  // hash function for keys - returns value between 0 and M-1
  private int hash(Key key) {
    return (key.hashCode() & 0x7fffffff) % m;
  }
}
