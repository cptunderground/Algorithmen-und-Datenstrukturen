package exercise7;

public interface HashST<Key, Value> {
  Value get(Key key);

  void put(Key key, Value val);

  int size();

  boolean isEmpty();

  boolean contains(Key key);

  Iterable<Key> keys();

  int getCapacity();
}
