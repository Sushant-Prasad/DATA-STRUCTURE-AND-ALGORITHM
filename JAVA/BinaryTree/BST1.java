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
      // If tree is empty;create new node and return it
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
  // Binary Search in a Binary Search Tree (BST)
public static boolean search(Node root, int key) {
  // Base case: if the current node is null, the key is not found
  if (root == null) return false;

  // If the current node's data matches the key, return true
  if (root.data == key) return true;

  // If the key is greater than the current node's data, search in the right subtree
  if (root.data < key) {
      return search(root.right, key);
  } else {
      // If the key is smaller than the current node's data, search in the left subtree
      return search(root.left, key);
  }
}


  // Inorder traversal (Left → Root → Right)
  public static void inorder(Node root) {
    if (root == null) return; // Base case: if root is null, do nothing

    inorder(root.left);    // Visit left subtree
    System.out.print(root.data + " "); // Visit root node
    inorder(root.right);               // Visit right subtree
  }

  public static void main(String[] args) {
    int arr[] = {5, 1, 3, 4, 2, 7}; 
    Node root = null; // Initialize root of BST

    // Insert each element into the BST
    for (int i : arr) {
      root = insert(root, i);
    }

   // perform inorder traversal
    System.out.println("Inorder Traversal of BST:");
    inorder(root); // Output: 1 2 3 4 5 7
    System.out.println();
    System.out.println(search(root, 7));
  }

}
