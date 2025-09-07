package Hashing;

import java.util.HashMap;

/**
 * Title: Valid Anagram Checker using HashMap
 *
 * Problem:
 * - Given two strings s and t, determine if t is an anagram of s.
 * - An anagram means both strings contain the same characters
 *   with the same frequency, order doesn’t matter.
 *
 * Approach:
 * 1. If lengths differ → return false immediately.
 * 2. Use a HashMap<Character, Integer> to count character frequencies in s.
 * 3. Traverse t:
 *    - If a character doesn’t exist in the map → return false.
 *    - Otherwise, decrement its frequency.
 *    - If frequency becomes 0, remove the character from the map.
 * 4. At the end, if the map is empty → both strings are anagrams.
 *
 * Example:
 * Input:  s = "race", t = "care"
 * Output: true
 *
 * ----------------------------
 * Time Complexity:
 * ----------------------------
 * - Building frequency map for s → O(n)
 * - Traversing t and updating map → O(n)
 * - Removing entries when count == 0 → O(1) per operation
 * Overall: O(n), where n = length of s (or t).
 *
 * ----------------------------
 * Space Complexity:
 * ----------------------------
 * - HashMap stores character counts.
 * - In worst case, map size = unique characters in s.
 * - If only lowercase English letters → O(26) ≈ O(1).
 * - For general Unicode characters → O(k), where k = number of unique chars.
 */
public class HashMap4 {

  /**
   * Check if two strings are valid anagrams.
   *
   * @param s input string
   * @param t input string
   * @return true if t is an anagram of s, false otherwise
   */
  public static boolean isValidAnagram(String s, String t) {
    // Step 1: If lengths differ → not an anagram
    if (s.length() != t.length()) {
      return false;
    }

    // Step 2: Build frequency map for string s
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }

    // Step 3: Traverse string t and update map
    for (int i = 0; i < t.length(); i++) {
      char ch = t.charAt(i);

      if (!map.containsKey(ch)) {
        return false; // character not found
      }

      // Decrement frequency
      map.put(ch, map.get(ch) - 1);

      // If count becomes 0 → remove the key
      if (map.get(ch) == 0) {
        map.remove(ch);
      }
    }

    // Step 4: If map is empty → anagram
    return map.isEmpty();
  }

  public static void main(String[] args) {
    String s = "race";
    String t = "care";

    if (isValidAnagram(s, t)) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }
  }
}
