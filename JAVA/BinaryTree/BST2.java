// 1.Convert a sorted array to a balanced Binary Search Tree (BST)
// 2.Convert BST to Balanced BST
//3.Find size of the largest BST in a Binary Tree
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
  // 3. Find size of the largest BST in a Binary Tree
public static class Info {
    boolean isValidBST; // whether the current subtree is a BST
    int size;           // size (number of nodes) in the current subtree
    int max;            // maximum value in the current subtree
    int min;            // minimum value in the current subtree

    Info(boolean isValidBST, int size, int max, int min) {
        this.isValidBST = isValidBST;
        this.size = size;
        this.max = max;
        this.min = min;
    }
}

// Global variable to store the size of the largest BST found so far
public static int maxBSTsize = 0;

public static Info largestBST(Node root) {
    // Base case: empty tree is a valid BST of size 0
    if (root == null) {
        return new Info(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Recursively get info about left and right subtrees
    Info leftInfo = largestBST(root.left);
    Info rightInfo = largestBST(root.right);

    // Compute size of current subtree
    int size = leftInfo.size + rightInfo.size + 1;

    // Compute min and max values within current subtree
    int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
    int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

    // Check if current subtree violates BST property:
    // - root must be greater than all nodes in left subtree
    // - root must be smaller than all nodes in right subtree
    if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
        // Not a valid BST, return Info with isValidBST = false
        return new Info(false, size, max, min);
    }

    // If both left and right subtrees are valid BSTs, then this subtree is also a valid BST
    if (leftInfo.isValidBST && rightInfo.isValidBST) {
        // Update global maxBSTsize with current subtree size
        maxBSTsize = Math.max(maxBSTsize, size);
        return new Info(true, size, max, min);
    }

    // Otherwise, this subtree is not a BST
    return new Info(false, size, max, min);
}
// 4. Merge two BSTs into a single balanced BST
public static Node mergeBSTs(Node root1, Node root2) { //Linear:-O(N+M)
    // Step 1: Get inorder traversal of both BSTs
    // Inorder traversal of BST always gives sorted sequence
    ArrayList<Integer> arr1 = new ArrayList<>();
    ArrayList<Integer> arr2 = new ArrayList<>();
    getInorder(root1, arr1); 
    getInorder(root2, arr2);

    // Step 2: Merge the two sorted arrays (like merge step in merge sort)
    int i = 0, j = 0;
    ArrayList<Integer> finalArr = new ArrayList<>();

    while (i < arr1.size() && j < arr2.size()) {
        if (arr1.get(i) < arr2.get(j)) {
            finalArr.add(arr1.get(i));
            i++;
        } else {
            finalArr.add(arr2.get(j));
            j++;
        }
    }

    // Add remaining elements from arr1
    while (i < arr1.size()) {
        finalArr.add(arr1.get(i));
        i++;
    }

    // Add remaining elements from arr2
    while (j < arr2.size()) {
        finalArr.add(arr2.get(j));
        j++;
    }

    // Step 3: Convert merged sorted array into a balanced BST
    Node root = createBST(finalArr, 0, finalArr.size() - 1);

    // Step 4: Return the root of the new balanced BST
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
    System.out.println();
//largest BST
    Node roo3 = new Node(50);
    roo3.left = new Node(30);
    roo3.left.left=new Node(5);
    roo3.left.right=new Node(20);
    roo3.right =new Node(60);
    roo3.right.left =new Node(45);
    roo3.right.right =new Node(70);
    roo3.right.right.left =new Node(65);
    roo3.right.right.right =new Node(80);
    Info info = largestBST(roo3);
    System.out.println("largest BST size "+ maxBSTsize);

    //mergeBSTs
    Node root4 = new Node(2); //BST1
         root4.left =new Node(1);
         root4.right=new Node(3);

         Node root5 = new Node(9); //BST2
         root5.left =new Node(4);
         root5.right=new Node(12);
         Node rootFinal = mergeBSTs(root4, root5);
         System.out.println("Merged BST root "+rootFinal.data);
         preorder(rootFinal);
  }
}
