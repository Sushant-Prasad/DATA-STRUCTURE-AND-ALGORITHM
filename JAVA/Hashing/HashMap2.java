package Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Title: Custom HashMap Implementation (Generic <K,V>)
 *
 * Features:
 * - put(key, value)      → Insert or update key-value pair
 * - get(key)             → Retrieve value for a given key
 * - containsKey(key)     → Check if a key exists
 * - remove(key)          → Delete a key-value pair
 * - keySet()             → Get list of all keys
 * - isEmpty()            → Check if map is empty
 *
 * Internal Implementation:
 * - Uses array of LinkedLists (separate chaining).
 * - Each LinkedList stores nodes with key-value pairs.
 * - Rehashing doubles the bucket size when load factor > 2.0.
 *
 * Time Complexity (Average): O(1) for put, get, remove
 * Time Complexity (Worst): O(n) if all keys hash to same bucket
 */
public class HashMap2 {
  static class HashMap<K, V> {

    // Node class represents key-value pair
    private class Node {
      K key;
      V value;

      Node(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int n; // total nodes (entries)
    private int N; // bucket size
    private LinkedList<Node> buckets[]; // array of LinkedLists

    // Constructor
    @SuppressWarnings("unchecked")
    public HashMap() {
      this.N = 4; // initial bucket size
      this.buckets = new LinkedList[N];
      for (int i = 0; i < N; i++) {
        this.buckets[i] = new LinkedList<>();
      }
    }

    // Rehashing: double the bucket size when load factor > 2
    @SuppressWarnings("unchecked")
    private void rehash() {
      LinkedList<Node> oldBuckets[] = buckets;
      buckets = new LinkedList[2 * N];
      N = 2 * N;
      for (int i = 0; i < N; i++) {
        buckets[i] = new LinkedList<>();
      }
      // Re-insert nodes into new bucket array
      for (int i = 0; i < oldBuckets.length; i++) {
        LinkedList<Node> ll = oldBuckets[i];
        for (Node node : ll) {
          put(node.key, node.value);
        }
      }
    }

    // Hash Function: maps key → bucket index
    private int hashFunction(K key) {
      return Math.abs(key.hashCode()) % N;
    }

    // Search for key in LinkedList; return index if found else -1
    private int searchInLL(K key, int bi) {
      LinkedList<Node> ll = buckets[bi];
      for (int i = 0; i < ll.size(); i++) {
        Node node = ll.get(i);
        if (node.key.equals(key)) {
          return i;
        }
      }
      return -1;
    }

    // Insert or update key-value pair
    public void put(K key, V value) {
      int bi = hashFunction(key);     // bucket index
      int di = searchInLL(key, bi);   // data index in LL

      if (di != -1) {
        // Key already exists → update value
        Node node = buckets[bi].get(di);
        node.value = value;
      } else {
        // New key → insert
        buckets[bi].add(new Node(key, value));
        n++;
      }

      // Check load factor
      double lambda = (double) n / N;
      if (lambda > 2.0) {
        rehash();
      }
    }

    // Check if key exists
    public boolean containsKey(K key) {
      int bi = hashFunction(key);
      int di = searchInLL(key, bi);
      return di != -1;
    }

    // Get value for a key
    public V get(K key) {
      int bi = hashFunction(key);
      int di = searchInLL(key, bi);
      if (di == -1) return null;
      Node node = buckets[bi].get(di);
      return node.value;
    }

    // Remove a key-value pair
    public V remove(K key) {
      int bi = hashFunction(key);
      int di = searchInLL(key, bi);
      if (di != -1) {
        Node node = buckets[bi].remove(di);
        n--;
        return node.value;
      }
      return null;
    }

    // Get list of all keys
    public ArrayList<K> keySet() {
      ArrayList<K> keys = new ArrayList<>();
      for (int i = 0; i < N; i++) {
        LinkedList<Node> ll = buckets[i];
        for (Node node : ll) {
          keys.add(node.key);
        }
      }
      return keys;
    }

    // Check if map is empty
    public boolean isEmpty() {
      return n == 0;
    }
  }

  // Driver code
  public static void main(String[] args) {
    HashMap<String, Integer> hm = new HashMap<>();

    // Insert key-value pairs
    hm.put("India", 150);
    hm.put("USA", 60);
    hm.put("UK", 50);
    hm.put("China", 140);
    hm.put("Japan", 40);

    // Get value
    System.out.println("Population of India: " + hm.get("India"));

    // Check containsKey
    System.out.println("Contains USA? " + hm.containsKey("USA"));
    System.out.println("Contains Russia? " + hm.containsKey("Russia"));

    // Remove a key
    System.out.println("Removed UK -> " + hm.remove("UK"));

    // Iterate keys
    System.out.println("\nIterating using keySet():");
    ArrayList<String> keys = hm.keySet();
    for (String k : keys) {
      System.out.println(k + " -> " + hm.get(k));
    }

    // Check isEmpty
    System.out.println("\nIs HashMap empty? " + hm.isEmpty());

    // Update value
    hm.put("India", 160);
    System.out.println("Updated Population of India: " + hm.get("India"));
  }
}
