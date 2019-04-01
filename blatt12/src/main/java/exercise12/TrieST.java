package exercise12;


import exercise12.utils.NotImplementedException;
import java.util.LinkedList;

class TrieST<Value> {

  public TrieST() {

  }

  protected Node root = new Node();
  protected static final int R = 256; // radix

  protected static class Node {

    protected Object value;
    protected Node[] next = new Node[256];
    protected int size;
  }

  public Value get(String key) {

    return ((Value) get(this.root, key, 0).value);
  }

  private Node get(Node node, String key, int digit) {
    /*
    if (node == null) {
      return null;
    }

    if (digit == key.length()) {
      return node;
    }

    char nextChar = key.charAt(digit);
    return get(node.next[nextChar], key, digit + 1);
    */

    while(digit != key.length()){
      if (node == null){
        return null;
      }
      char nextChar = key.charAt(digit);
      node = node.next[nextChar];
      digit++;
    }
    return node;

  }

  public void put(String key, Value value) {
    root = put(this.root, key, value, 0);
  }

  private Node put(Node node, String key, Value value, int digit) {

    if (node == null) {
      node = new Node();
    }

    if (digit == key.length()) {
      node.value = value;
      return node;
    }

    char nextChar = key.charAt(digit);
    node.next[nextChar] = put(node.next[nextChar], key, value, digit + 1);
    return node;
    /*
    if (node == null){
      node = new Node();
    }
    LinkedList<Node> list = new LinkedList<>();
    char nextChar;

    nextChar = key.charAt(digit);
    node = node.next[nextChar];
    if (node == null){
      node = new Node();
    }
    digit++;

    list.add(node);
    while (digit != key.length()){
      nextChar = key.charAt(digit);
      node = node.next[nextChar];
      if (node == null){
        node = new Node();
      }
      digit++;
    }
    node.value = value;

    return list.getFirst();*/
  }

  /**
   * Gibt den kleinsten Schlüssel mit dem angegebenen Präfix zurück. Falls kein Schlüssel mit diesem
   * Präfix gefunden wird, wird null zurückgegeben.
   */
  public String findMinimalKeyWithPrefix(String prefix) {
    char[] chars = prefix.toCharArray();
    return null;
  }

}