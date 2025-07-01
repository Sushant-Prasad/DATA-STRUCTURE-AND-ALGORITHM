// -------------------- Binary Tree Operations --------------------
// Operations implemented in this file:
// 1. Height of a Tree
// 2. Count of Nodes
// 3. Sum of all Nodes
// 4. Diameter of a Tree (O(N^2) and O(N))
// 5. Check if one Tree is a Subtree of another
// 6. Top View of a Binary Tree
// 7. Print Kth Level of Tree
// 8. Lowest Common Ancestor (Path-based and Optimized)
package BinaryTree;

import java.util.*;

public class BT2 {
  // Binary Tree Node definition
  static class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }

  // 1. Height of the Tree
  public static int height(Node root) {
    if (root == null) {
      return 0;
    }
    int leftHeight = height(root.left);
    int rightHeight = height(root.right);
    int height = Math.max(leftHeight, rightHeight) + 1;
    return height;
  }

  // 2. Count of Nodes in the Tree
  public static int countNode(Node root) {
    if (root == null) {
      return 0;
    }
    int leftCount = countNode(root.left);
    int rightCount = countNode(root.right);
    int totalCountNode = leftCount + rightCount + 1;
    return totalCountNode;
  }

  // 3. Sum of all Nodes in the Tree
  public static int sum(Node root) {
    if (root == null) {
      return 0;
    }
    int leftsum = sum(root.left);
    int rightsum = sum(root.right);
    int sum = (leftsum + rightsum + root.data);
    return sum;
  }

  // 4. Diameter of Tree - Naive O(N^2) approach
  public static int diameter(Node root) { // O(N^2)
    if (root == null) {
      return 0;
    }
    int leftdiam = diameter(root.left);
    int rightdiam = diameter(root.right);
    int leftHeight = height(root.right);
    int rightHeight = height(root.right);
    int selfDiam = leftHeight + rightHeight + 1;
    return Math.max(Math.max(leftdiam, rightdiam), selfDiam);
  }

  // Helper class for optimized diameter
  static class Info {
    int d; // diameter
    int h; // height

    Info(int d, int h) {
      this.d = d;
      this.h = h;
    }
  }

  // 4. Diameter of Tree - Optimized O(N) approach
  public static Info diameter2(Node root) { // O(N)
    if (root == null) {
      return new Info(0, 0);
    }
    Info leftInfo = diameter2(root.left);
    Info rightInfo = diameter2(root.right);
    int selfHeight = Math.max(leftInfo.h, rightInfo.h) + 1;
    int selfDiameter = Math.max(Math.max(leftInfo.d, rightInfo.d), leftInfo.h + rightInfo.h + 1);
    Info newInfo = new Info(selfDiameter, selfHeight);

    return newInfo;
  }

  // Helper class to Check if two trees are identical
  public static boolean isIdentical(Node node, Node subRoot) {
    if (node == null && subRoot == null) {
      return true;
      // chech Condn for non identical
    } else if (node == null || subRoot == null || node.data != subRoot.data) {
      return false;
    }
    if (!isIdentical(node.left, subRoot.left)) {
      return false;
    }
    if (!isIdentical(node.right, subRoot.right)) {
      return false;
    }
    return true;
  }

  // 5. Check if one Tree is a Subtree of another
  public static boolean isSubtree(Node root, Node subRoot) {
    // base case
    if (root == null) {
      return false;
    }
    if (root.data == subRoot.data) {

      if (isIdentical(root, subRoot)) {
        return true;
      }
    }
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }

  // ---------------------Subtree of another tree------------------
  // ---------------------6.Top view of a tree-----------------------
  public static class Info2 { // Helper class to store node and its horizontal distance for top view
    Node node;
    int hd;

    Info2(Node node, int hd) {
      this.node = node;
      this.hd = hd;
    }
  }

  // 6. Print the top view of the tree
  public static void topView(Node root) {
    int min = 0, max = 0;
    Queue<Info2> q = new LinkedList<>();
    HashMap<Integer, Node> map = new HashMap<>();
    q.add(new Info2(root, 0));
    q.add(null);// for next line
    while (!q.isEmpty()) {
      Info2 curr = q.remove();
      if (curr == null) {
        if (q.isEmpty()) {
          break;

        } else {
          q.add(null);
        }
      } else {
        if (!map.containsKey(curr.hd)) { // hd occuring first time
          map.put(curr.hd, curr.node);
        }
        if (curr.node.left != null) {
          q.add(new Info2(curr.node.left, curr.hd - 1));
          min = Math.min(min, curr.hd - 1);
        }
        if (curr.node.right != null) {
          q.add(new Info2(curr.node.right, curr.hd + 1));
          max = Math.max(max, curr.hd + 1);
        }

      }

    }
    for (int i = min; i <= max; i++) {
      System.out.print(map.get(i).data + " ");
    }

  }

  // ------------------7.Kth Level of a tree-----------------------------
  public static void KthLevel(Node root, int level, int k) {
    // base case
    if (root == null)
      return;
    if (level == k) {
      System.out.print(root.data + " ");
      return;
    }
    KthLevel(root.left, level + 1, k);
    KthLevel(root.right, level + 1, k);

  }

  // ------------------------8.Lowest Common Ancestor-----------------------
  // 8. Get path from root to a given node (used for LCA)
  public static boolean getPath(Node root, int node, ArrayList<Node> path) {
    // base case
    if (root == null) {
      return false;
    }

    path.add(root); // root will always be a common ancestor
    if (root.data == node) {
      return true;
    }
    // check for left and right subtree
    if (getPath(root.left, node, path) || getPath(root.right, node, path)) {
      return true;
    }
    path.remove(path.size() - 1); // node is not a part of path
    return false;
  }

  // Lowest Common Ancestor - Path Based
  public static int lca(Node root, int a, int b) {// TC:-O(N) & SC:-O(N)
    ArrayList<Node> pathA = new ArrayList<>();
    ArrayList<Node> pathB = new ArrayList<>();
    getPath(root, a, pathA);
    getPath(root, b, pathB);
    int i;
    for (i = 0; i < pathA.size() && i < pathB.size(); i++) {
      if (pathA.get(i) != pathB.get(i)) {
        break;
      }
    }
    // last common node=>0-1 index
    return pathA.get(i - 1).data;
  }

  // 8. Lowest Common Ancestor - Optimized Approach
  public static Node lca2(Node root, int a, int b) {// TC:-O(N) & SC:-O(1)
    // base case
    if (root == null || root.data == a || root.data == b) {
      return root;
    }
    Node leftLca = lca2(root.left, a, b);
    Node rightLca = lca2(root.right, a, b);
    // if one subtree return null then another subtree has both nodes
    if (leftLca == null) {
      return rightLca;
    }
    if (rightLca == null) {
      return leftLca;

    }
    // if both sub tree returns node(not null) then common amncestor would be root
    return root;
  }
// --------------------9.Minimum Distance bwteen Two Nodes-----------------------

  // Helper function :- distance between lca to node n
  public static int lcaDist(Node root, int n){
    //base case
    if(root == null){
      return -1;
    }
    if(root.data==n){
      return 0;
    }
    int leftLcaDist = lcaDist(root.left, n);
    int rightLcaDist = lcaDist(root.right, n);
    if(leftLcaDist == -1 && rightLcaDist == -1){
       return -1;
    }else if(leftLcaDist == -1){
       return rightLcaDist+1;
    }else{
      return leftLcaDist+1;
    }

   }

  // 9.Minimum Distance bwtwwen Two Nodes
  public static int minDist(Node root, int a, int b) {
    Node lca = lca2(root, a, b);
    int dist1 = lcaDist(lca, a);
    int dist2 = lcaDist(lca, b);
    return dist1 + dist2;
  }

  
// 10. Kth Ancestor of a Node in Binary Tree
public static int KthAncestor(Node root, int n, int k) {
  // Base case: if the node is null, return -1 (node not found)
  if (root == null) return -1;

  // If current node is the target node, return 0 (distance from itself)
  if (root.data == n) return 0;

  // Recursively check left and right subtrees
  int leftDist = KthAncestor(root.left, n, k);
  int rightDist = KthAncestor(root.right, n, k);

  // If node is not found in both subtrees
  if (leftDist == -1 && rightDist == -1) return -1;

  // Take max distance from left or right (only one of them will be non -1)
  int maxDist = Math.max(leftDist, rightDist);

  // If current node is the kth ancestor (distance + 1 = k)
  if (maxDist + 1 == k) {
    System.out.println("Kth Ancestor is: " + root.data);  // optional output
  }

  // Return distance from current node to target node
  return maxDist + 1;
}
  // 11. Transform to Sum Tree: change each node’s value to the sum of its original left and right subtrees;
  public static int transformToSumTree(Node root) {
    // Base case: an empty node contributes 0
    if (root == null) return 0;

    // Recursively convert left and right subtrees first
    int leftSum = transformToSumTree(root.left);
    int rightSum = transformToSumTree(root.right);

    // Keep original value before overwriting
    int oldVal = root.data;

    // Node’s new value is sum of values in its left and right subtrees
    root.data = leftSum + rightSum;

    // Return the sum of the subtree rooted at this node (new node value + its original value)
    return root.data + oldVal;
  }
  public static void preorder(Node root) {
    if (root == null) return; // Base case

    System.out.print(root.data + " "); // Visit root
    preorder(root.left);              // Recur on left
    preorder(root.right);             // Recur on right
}




  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    System.out.println(height(root));
    System.out.println(countNode(root));
    System.out.println(sum(root));
    System.out.println(diameter(root));
    System.out.println(diameter2(root).d);
    Node subRoot = new Node(2);
    subRoot.left = new Node(4);
    subRoot.right = new Node(5);
    System.out.println(isSubtree(root, subRoot));
    topView(root);
    System.out.println();
    KthLevel(root, 1, 2);
    System.out.println();
    System.out.println(lca(root, 5, 4));
    System.out.println(lca2(root, 7, 4).data);
   
    System.out.println("Min Dist : "+minDist(root,4 , 6));
    System.out.println(KthAncestor(root, 5, 2));
    transformToSumTree(root);
    preorder(root);

  }

}
