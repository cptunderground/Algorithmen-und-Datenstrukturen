package exercise5;

/**
 * Implementation of a (Maximum ordered) priority queue, using a Linked Tree implementation.
 */
public class LinkedPriorityQueue<T extends Comparable<T>> {

  private T[] queue;
  private int counter = 0;

  public LinkedPriorityQueue() {
    queue = (T[]) new Comparable[100];
  }

  private boolean less(int i, int j) {
    return queue[i].compareTo(queue[j]) < 0;
  }

  /**
   * Swaps an element.
   */
  private void swap(int i, int j) {
    T t = queue[i];
    queue[i] = queue[j];
    queue[j] = t;
  }

  /**
   * Moves an element upwards to its corresponding place.
   */
  private void swim(int k) {
    while (k > 1 && less(k / 2, k)) {
      swap((k / 2), k);
      k = k / 2;
    }
  }

  /**
   * Moves an element downwards to its corresponding place.
   */
  private void sink(int k) {
    while (2 * k <= counter) {
      int i = 2 * k;
      if (i < counter && less(i, i + 1)) {
        i++;
      }
      if (!less(k, i)) {
        break;
      }
      swap(k, i);
      k = i;
    }
  }

  /**
   * Insert an element into the priority queue
   */
  public void insert(T data) {
    queue[++counter] = data;
    swim(counter);
  }

  /**
   * Returns the maximum element
   */
  public T max() {
    return queue[1];
  }

  /**
   * Removes and returns the maximum element
   */
  public T delMax() {
    final T max = queue[1];
    swap(1, counter--);
    queue[counter + 1] = null;
    sink(1);
    return max;
  }

  /**
   * Returns the number of elements in the priority queue
   */
  public int size() {
    return counter;
  }

  /**
   * Returns true if the queue is empty, false otherwise
   */
  public boolean isEmpty() {
    return counter == 0;
  }
}
