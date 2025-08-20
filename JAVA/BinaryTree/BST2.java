// 1.Convert a sorted array to a balanced Binary Search Tree (BST)
// 2.Convert BST to Balanced BST
package BinaryTree;

import java.util.ArrayList;

public class BST2 {

  // Binary Tree Node definition
  static class Node {
    int data; // Value of the node
    Node left; // Left child
    Node right; // Right child

    // Constructor to initialize node with data
    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  // 1.Convert a sorted array to a balanced Binary Search Tree (BST)
  public static Node createBST(ArrayList<Integer> arr, int s, int e) {
    // Base case: if start index exceeds end,return null
    if (s > e) {
      return null;
    }

    // Find the middle element to maintain balance
    int mid = (s + e) / 2;
    Node root = new Node(arr.get(mid)); // Create root node
    // Recursively build left and right subtrees
    root.left = createBST(arr, s, mid - 1);
    root.right = createBST(arr, mid + 1, e);

    return root;
  }

  // Helper function to get the inorder sequence of a BST
  // The inorder sequence of a BST is always sorted
  public static void getInorder(Node root, ArrayList<Integer> inorder) {
    if (root == null)
      return; // Base case: if node is null, return

    // Traverse the left subtree
    getInorder(root.left, inorder);

    // Visit the root node
    inorder.add(root.data);

    // Traverse the right subtree
    getInorder(root.right, inorder);
  }

  // 2.Convert unbalanced BST to Balanced BST
  public static Node balancedBST(Node root) {
    // Step 1: Store the inorder sequence of the given BST
    ArrayList<Integer> inorderSeq = new ArrayList<>();
    getInorder(root, inorderSeq);

    // Step 2: Build a balanced BST from the sorted inorder sequence
    // The middle element of the sequence becomes the root, ensuring balance
    root = createBST(inorderSeq, 0, inorderSeq.size() - 1);

    // Step 3: Return the new balanced BST root
    return root;
  }

  // Preorder traversal (Root → Left → Right)
  public static void preorder(Node root) {
    if (root == null)
      return; // Base case

    System.out.print(root.data + " "); // Visit root
    preorder(root.left); // Recur on left subtree
    preorder(root.right); // Recur on right subtree
  }

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<>(); // Sorted array input
    arr.add(3);
    arr.add(5);
    arr.add(6);
    arr.add(8);
    arr.add(10);
    arr.add(11);
    arr.add(12);

    // Create a balanced BST from the sorted array
    Node root = createBST(arr, 0, arr.size() - 1);

    // Print preorder traversal of the BST
    preorder(root);
    System.out.println();
    Node root2 = balancedBST(root);
    preorder(root2);
  }
}
