// 1.Method to build binary tree from pre-order traversal input array
// 2.Preorder traversal (Root → Left → Right)
// 3.Inorder traversal (Left → Root → Right)
 // 4.Postorder traversal (Left → Right → Root)
 // 5.Level order traversal (Breadth First Search)
package BinaryTree;

// Importing required classes (List, Queue, etc.)
import java.util.*;

// Main class
public class BT1 {

    // Inner static class to represent a node in the binary tree
    static class Node {
        int data;       // Value stored in the node
        Node left;      // Reference to left child
        Node right;     // Reference to right child

        // Constructor to initialize a node with given data
        Node(int data) {
            this.data = data;
            this.left = null;  // Initially no left child
            this.right = null; // Initially no right child
        }
    }

    // Static class containing methods to build and traverse the tree
    static class Tree {
        static int idx = -1; // Keeps track of the current index while building the tree

        // 1.Method to build binary tree from pre-order traversal input array
        public static Node buildTree(int[] nodes) {
            idx++; // Move to next index

            // If current node is -1, return null (represents a leaf node)
            if (nodes[idx] == -1) {
                return null;
            }

            // Step 1: Create a new node with current value
            Node newNode = new Node(nodes[idx]);

            // Step 2: Recursively build the left subtree
            newNode.left = buildTree(nodes);

            // Step 3: Recursively build the right subtree
            newNode.right = buildTree(nodes);

            // Step 4: Return the constructed subtree rooted at newNode
            return newNode;
        }

        // 2.Preorder traversal (Root → Left → Right)
        public static void preorder(Node root) {
            if (root == null) return; // Base case

            System.out.print(root.data + " "); // Visit root
            preorder(root.left);              // Recur on left
            preorder(root.right);             // Recur on right
        }

        // 3.Inorder traversal (Left → Root → Right)
        public static void inorder(Node root) {
            if (root == null) return; // Base case

            inorder(root.left);              // Recur on left
            System.out.print(root.data + " "); // Visit root
            inorder(root.right);             // Recur on right
        }

        // 4.Postorder traversal (Left → Right → Root)
        public static void postorder(Node root) {
            if (root == null) return; // Base case

            postorder(root.left);     // Recur on left
            postorder(root.right);    // Recur on right
            System.out.print(root.data + " "); // Visit root
        }

        // 5.Level order traversal (Breadth First Search)
        public static void levelorder(Node root) {
            if (root == null) return; // If tree is empty, exit

            Queue<Node> q = new LinkedList<>(); // Queue to help BFS
            q.add(root);                        // Add root to queue
            q.add(null);                        // Null is used to indicate level change

            // Loop until the queue is empty
            while (!q.isEmpty()) {
                Node currNode = q.remove(); // Remove the front node

                if (currNode == null) {
                    // End of one level, move to next line
                    System.out.println();

                    // If queue is not empty, add another null marker for printing next line 
                    if (!q.isEmpty()) {
                        q.add(null);
                    }
                } else {
                    // Print current node’s value
                    System.out.print(currNode.data + " ");

                    // Add left child if exists
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }

                    // Add right child if exists
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }
    }

    // Main method to test building and traversing the tree
    public static void main(String[] args) {
        // Tree is built using this array:
        // Preorder: 1 2 4 -1 -1 5 -1 -1 3 -1 6 -1 -1
        // -1 means "no node" (null)
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        Tree t = new Tree();               // Create Tree object
        Node root = t.buildTree(nodes);   // Build the tree

        // Display all types of traversals
        System.out.println("Preorder Traversal:");
        t.preorder(root);                 // Root → Left → Right

        System.out.println("\nInorder Traversal:");
        t.inorder(root);                  // Left → Root → Right

        System.out.println("\nPostorder Traversal:");
        t.postorder(root);                // Left → Right → Root

        System.out.println("\nLevel Order Traversal:");
        t.levelorder(root);               // Level-by-level print
    }
}
