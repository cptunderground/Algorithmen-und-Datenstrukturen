package exercise4;

public class Stack<T> {

  private LinkedList<T> data = new LinkedList<T>();

  /**
   * Adds an element to the top of the stack
   */
  public void push(T item) {
    data.addFirst(item);
  }

  /**
   * Removes and returns the element at the top of the stack
   */
  public T pop() {
    return data.removeFirst();
  }

  /**
   * Removes but does not return the element at the top of the stack
   */
  public T top() {
    //T temp = data.removeLast();
    return data.getFirst();
  }

  /**
   * The number of elements in the stack
   */
  public int size() {
    return data.size();
  }

  /**
   * returns true if the stack is empty, false otherwise
   */
  public boolean isEmpty() {
    if (data.size() == 0) {
      return true;
    } else {
      return false;
    }
  }
}
