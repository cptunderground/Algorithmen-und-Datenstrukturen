package exercise7;

import java.util.Hashtable;
import java.util.Set;


public class MathSet<K> {

  private K[] universe = null;
  private Hashtable<K, Integer> universeHashTable;

  /**
   * Create a new empty Set for a given universe
   *
   * @param universe All possible elements that can be represented by the set
   */
  MathSet(K[] universe) {
    this.universeHashTable = new Hashtable<>();
    this.universe = universe.clone();
  }

  K[] getUniverse() {
    return this.universe;
  }

  /**
   * Add the key to the set
   */
  void add(K key) {
    for (int i = 0; i < this.universe.length; i++) {
      if (this.universe[i] == key) {
        universeHashTable.put(key, 0);
      }
    }
  }

  /**
   * returns the set of elements, which are not contained in the universe
   */
  MathSet<K> complement() {
    MathSet<K> complement = new MathSet<>(this.universe);
    for (int i = 0; i < this.universe.length; i++) {
      if (!this.universeHashTable.containsKey(this.universe[i])) {
        complement.add(this.universe[i]);
      }
    }
    return complement;
  }


  /**
   * inserts all the elements in the set a, which are not yet part of the set
   */
  void union(MathSet<K> a) {
    this.universeHashTable.putAll(a.universeHashTable);
  }

  /**
   * Removes all the keys from the set, which are not contained in the set a.
   */
  void intersection(MathSet<K> a) {
    for (K key : this.universeHashTable.keySet()) {
      if (!a.contains(key)){
        this.universeHashTable.remove(key);
      }
    }
  }

  /**
   * Remove the key from the set
   */
  void delete(K key) {
    universeHashTable.remove(key);
  }

  /**
   * Returns true if the set contains the key
   */
  boolean contains(K key) {
    return universeHashTable.containsKey(key);
  }

  /**
   * Returns the number of elements in the set.
   */
  int size() {
    return universeHashTable.size();
  }
}
