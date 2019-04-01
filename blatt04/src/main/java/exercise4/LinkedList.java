package exercise4;


public class LinkedList<T> {

  private class Node<T> {

    private Node<T> next;
    private T item;

    private Node(T item, Node<T> next) {
      this.item = item;
      this.next = next;
    }
  }

  private Node<T> first = null;
  private Node<T> last = null;
  private int numberOfElements = 0;

  public LinkedList() {

    // in case you need code for initialization, add it here
  }

  /**
   * Appends element e at the end. The operation must be O(1)
   */
  public void append(T e) {
    if (first == null) {
      first = new Node<>(e, null);
      last = first;
      numberOfElements++;
    } else {
      last.next = new Node<>(e, null);
      last = last.next;
      numberOfElements++;
    }
  }

  /**
   * Adds element e to the front of the list.
   */
  public void addFirst(T e) {
    if (first == null) {
      this.append(e);
    } else {
      first = new Node<>(e, first);
      numberOfElements++;
    }
  }

  /**
   * Removes the first element of the list
   */
  public T removeFirst() {
    if (first == null) {
      return null;
    }
    T temp = first.item;
    first = first.next;
    numberOfElements--;
    return temp;

  }

  /**
   * Inserts element at the given position. Throws IndexOutOfBoundException if pos is outside
   * range.
   */
  public void insert(int pos, T element) {
    if (pos > numberOfElements) {
      throw new IndexOutOfBoundsException();
    } else {
      Node runner = first;
      for (int i = 0; i < pos - 1; i++) {
        runner = runner.next;
      }
      Node toInsert = new Node(element, runner.next);
      runner.next = toInsert;
    }

  }

  /**
   * return first element in the list
   */
  public T getFirst() {
    return this.first.item;
  }

  /**
   * returns last element in the list
   */
  public T getLast() {
    return this.last.item;
  }

  /**
   * Returns the number of elements in the list. The operation must be O(1)
   */
  public int size() {
    return this.numberOfElements;
  }

  /**
   * prints all list elements - separated by commas E.g. an output of a two element list containing
   * the number 0 1 would be (0,1)
   */
  public String toString() {
    Node<T> current = first;
    StringBuffer sb = new StringBuffer();
    sb.append("(");
    while (current != null) {
      sb.append(current.item);
      if (current.next != null) {
        sb.append(",");
      }
      current = current.next;
    }
    sb.append(")");
    return sb.toString();
  }
}
