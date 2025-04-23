//Unique Number II
/* Given an array arr[] containing 2*n + 2 positive numbers, out of which 2*n numbers exist in pairs whereas only two number occur exactly once and are distinct. Find the other two numbers. Return the answer in increasing order.

Link:- https://www.geeksforgeeks.org/problems/finding-the-numbers0215/1
*/
package Hashing;
import java.util.Arrays;
import java.util.HashSet;

public class Hash1 {
  class Solution {
    public int[] singleNum(int[] arr) {
        // Code here
        // Create a HashSet to store elements that appear only once
        HashSet <Integer> map=new HashSet<>();
        for(int i:arr){
            if(map.contains(i))
                map.remove(i);// already seen -> remove it
            else
                map.add(i);// first time -> add it
        }
        int[] array=new int[2];
        int i=0;
        // Now the set contains exactly two elements that appeared only once
        // Transfer elements from the set to an array
        for(int val:map){
            array[i]=val;
            i++;
        }
        Arrays.sort(array);
        return array;
    }
}
  
}
