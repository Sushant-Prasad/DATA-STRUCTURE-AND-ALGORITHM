 // 1.Function to insert a value into the BST
 // 2.Binary Search in a Binary Search Tree (BST)
 // 3.Find the inorder successor (smallest value in the right subtree)
 // 4.Delete a node from a Binary Search Tree (BST)
 // 5.Print all nodes in the BST that lie within the range [k1, k2]
 // 6.Print a single root-to-leaf path
 // 7.Print all root-to-leaf paths in a binary tree
 // 8.Validate if a binary tree is a Binary Search Tree (BST)
 // 9.Create a mirror of a Binary Search Tree (BST)

package BinaryTree;

import java.util.ArrayList;

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

  //1.Function to insert a value into the BST
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

    return root; //Return the unchanged root pointer
  }
  // 2.Binary Search in a Binary Search Tree (BST)
public static boolean search(Node root, int key) { // TC:-O(H)
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
// 3.Find the inorder successor (smallest value in the right subtree)
public static Node findInorderSuccesor(Node root) {
  while (root.left != null) {
      root = root.left;
  }
  return root;
}

// 4.Delete a node from a Binary Search Tree (BST)
public static Node delete(Node root, int val) {
  // Traverse to the right subtree if the value to be deleted is greater
  if (root.data < val) {
      root.right = delete(root.right, val);
  }
  // Traverse to the left subtree if the value to be deleted is smaller
  else if (root.data > val) {
      root.left = delete(root.left, val);
  }
  // Node to be deleted is found
  else {
      // Case 1: Node is a leaf node
      if (root.left == null && root.right == null) {
          return null;
      }

      // Case 2: Node has only one child
      if (root.left == null) {
          return root.right;
      } else if (root.right == null) {
          return root.left;
      }

      // Case 3: Node has two children
      // Find inorder successor from the right subtree
      Node IS = findInorderSuccesor(root.right);

      // Replace current node's data with inorder successor's data
      root.data = IS.data;

      // Delete the inorder successor
      root.right = delete(root.right, IS.data);
  }

  return root;
}
// 5.Print all nodes in the BST that lie within the range [k1, k2]
public static void printInRange(Node root, int k1, int k2) {
  // Base case: if the node is null, do nothing
  if (root == null) return;

  // If root's data is within the range, first explore the left subtree,
  // then print the root, and finally explore the right subtree
  if (root.data >= k1 && root.data <= k2) {
      printInRange(root.left, k1, k2);
      System.out.print(root.data + " ");
      printInRange(root.right, k1, k2);
  }
  // If root's data is less than k1, skip the left subtree
  else if (root.data < k1) {
      printInRange(root.right, k1, k2);
  }
  // If root's data is greater than k2, skip the right subtree
  else {
      printInRange(root.left, k1, k2);
  }
}
// 6.Print a single root-to-leaf path
public static void printPath(ArrayList<Integer> path) {
    for (int i : path) {
        System.out.print(i + "->");
    }
    System.out.println("Null"); // Indicate the end of the path
}

// 7.Print all root-to-leaf paths in a binary tree
public static void printRoot2leaf(Node root, ArrayList<Integer> path) {
    // Base case: if the current node is null, return
    if (root == null) {
        return;
    }

    // Add the current node's data to the path
    path.add(root.data);

    // If the current node is a leaf, print the path
    if (root.left == null && root.right == null) {
        printPath(path);
    }

    // Recurse on the left and right subtrees
    printRoot2leaf(root.left, path);
    printRoot2leaf(root.right, path);

    // Backtrack: remove the current node from path before returning
    path.remove(path.size() - 1);
}
// 8.Validate if a binary tree is a Binary Search Tree (BST)
public static boolean isValidBST(Node root, Node min, Node max) {
  // An empty tree is a valid BST
  if (root == null) return true;

  // If current node violates the min constraint
  if (min != null && root.data <= min.data) return false;

  // If current node violates the max constraint
  if (max != null && root.data >= max.data) return false;

  // Recursively validate left and right subtrees
  // Left subtree: max value should be less than current node
  // Right subtree: min value should be greater than current node
  return isValidBST(root.left, min, root) &&
         isValidBST(root.right, root, max);
}

// 9.Create a mirror of a Binary Search Tree (BST)
public static Node createMirror(Node root) {
  // Base case: if the tree is empty, return null
  if (root == null) return null;

  // Recursively create mirror of left and right subtrees
  Node leftMirror = createMirror(root.left);
  Node rightMirror = createMirror(root.right);

  // Swap the left and right subtrees to create the mirror
  root.left = rightMirror;
  root.right = leftMirror;

  // Return the current node after mirroring
  return root;
}


// Preorder traversal (Root → Left → Right)
public static void preorder(Node root) {
  if (root == null) return; // Base case

  System.out.print(root.data + " "); // Visit root
  preorder(root.left);              // Recur on left
  preorder(root.right);             // Recur on right
}
  // Inorder traversal (Left → Root → Right)
  public static void inorder(Node root) {
    if (root == null) return; // Base case: if root is null, do nothing

    inorder(root.left);    // Visit left subtree
    System.out.print(root.data + " "); // Visit root node
    inorder(root.right);               // Visit right subtree
  }

  public static void main(String[] args) {
    //int arr[] = {5, 1, 3, 4, 2, 7}; 
    int arr[] = {8,5,3,1,4,6,10,11,14};
    Node root = null; // Initialize root of BST

    // Insert each element into the BST
    for (int i : arr) {
      root = insert(root, i);
    }

   // perform inorder traversal
    System.out.println("Inorder Traversal of BST:");
    inorder(root); // Output: 1 2 3 4 5 7
    System.out.println();
   // System.out.println(search(root, 7));
   // delete(root, 5);
    //inorder(root);
    printInRange(root, 5, 12);
    System.out.println();
    printRoot2leaf(root,new ArrayList<>());
    System.out.println();
    System.out.println( isValidBST(root, null, null));
    createMirror(root);
    preorder(root);
   
  }

}
