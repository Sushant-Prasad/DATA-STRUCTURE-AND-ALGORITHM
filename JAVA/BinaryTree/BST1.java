package BinaryTree;

public class BST1 {
  
  // Binary Tree Node definition
  static class Node {
    int data;    // Value of the node
    Node left;   // Left child
    Node right;   // Right child

    // Constructor to initialize node with data
    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  // Function to insert a value into the BST
  public static Node insert(Node root, int val) {
    if (root == null) {
      // If tree is empty, create new node and return it
      return new Node(val);
    }

    if (root.data < val) {
      // If value is greater than root, insert in right subtree
      root.right = insert(root.right, val);
    } else {
      // If value is smaller than or equal to root; insert in left subtree
      root.left = insert(root.left, val);
    }

    return root; // Return the unchanged root pointer
  }

  // Inorder traversal (Left → Root → Right)
  public static void inorder(Node root) {
    if (root == null) return; // Base case: if root is null, do nothing

    inorder(root.left);                // Visit left subtree
    System.out.print(root.data + " "); // Visit root node
    inorder(root.right);               // Visit right subtree
  }

  public static void main(String[] args) {
    int arr[] = {5, 1, 3, 4, 2, 7}; 
    Node root = null;               // Initialize root of BST

    // Insert each element into the BST
    for (int i : arr) {
      root = insert(root, i);
    }

    // Perform inorder traversal of the BST
    System.out.println("Inorder Traversal of BST:");
    inorder(root); // Expected Output: 1 2 3 4 5 7
  }

}
