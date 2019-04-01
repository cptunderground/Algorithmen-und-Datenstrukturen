package exercise4;

public class Queue<T> {

  private LinkedList<T> data = new LinkedList<T>();

  /**
   * returns the number of elements in the queue.
   */
  public int size() {
    return data.size();
  }

  /**
   * returns true if the queue is empty, false otherwise
   */
  public boolean isEmpty() {
    if (data.size() == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Adds a new element to the queue
   */
  public void enqueue(T item) {
    data.append(item);
  }

  /**
   * removes and returns the element at the head of the queue
   */
  public T dequeue() {
    return data.removeFirst();
  }

  /**
   * returns, but does not remove, the head of the list
   */
  public T peek() {
    return data.getFirst();
  }
}
