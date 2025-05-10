package BinaryTree;

public class BST2 {

  // Binary Tree Node definition
  static class Node {
    int data;      // Value of the node
    Node left;     // Left child
    Node right;    // Right child

    // Constructor to initialize node with data
    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  // Convert a sorted array to a balanced Binary Search Tree (BST)
  public static Node createBST(int arr[], int s, int e) {
    // Base case: if start index exceeds end, return null
    if (s > e) {
      return null;
    }

    // Find the middle element to maintain balance
    int mid = (s + e) / 2;
    Node root = new Node(arr[mid]); // Create root node

    // Recursively build left and right subtrees
    root.left = createBST(arr, s, mid - 1);
    root.right = createBST(arr, mid + 1, e);

    return root;
  }

  // Preorder traversal (Root → Left → Right)
  public static void preorder(Node root) {
    if (root == null) return; // Base case

    System.out.print(root.data + " "); // Visit root
    preorder(root.left);               // Recur on left subtree
    preorder(root.right);              // Recur on right subtree
  }

  public static void main(String[] args) {
    int arr[] = {3, 5, 6, 8, 10, 11, 12}; // Sorted array input

    // Create a balanced BST from the sorted array
    Node root = createBST(arr, 0, arr.length - 1);

    // Print preorder traversal of the BST
    preorder(root);
  }
}
