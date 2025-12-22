package LinkedList;

/*
============================================================================
 TITLE:
 Singly Linked List – Complete Implementation in Java
============================================================================

*/

import java.util.Scanner;

public class linkedlist {

    /*=============================================================
      NODE CLASS
      =============================================================*/
    // Each node of the linked list
    public static class Node {
        int data;       // stores value of node
        Node next;      // reference to next node

        // Constructor to initialize node
        Node(int data) {
            this.data = data;
            this.next = null; // initially next is null
        }
    }

    /*=============================================================
      SINGLY LINKED LIST CLASS
      =============================================================*/
    public static class sLinkedlist {

        // head points to first node
        // tail points to last node
        public static Node head = null;
        public static Node tail = null;

        /*---------------------------------------------------------
          METHOD: createList
        ---------------------------------------------------------*/
        // ============================================================================

/* 
 PURPOSE:
 --------
 Creates a singly linked list with `n` nodes by taking user input
 and inserting each element at the end of the list.

 ============================================================================
 PARAMETERS:
 -----------
 n → number of nodes to be created in the linked list

 ============================================================================
 LOGIC / APPROACH:
 -----------------
 1. Use a loop that runs `n` times.
 2. In each iteration:
    • Take input from the user.
    • Insert the value at the end of the linked list.
 3. Insertion at the end keeps the order of elements same as input.

 ============================================================================
 TIME COMPLEXITY:
 ----------------
 O(n)
 (Each insertion at end is O(1), repeated n times)

 ============================================================================
 SPACE COMPLEXITY:
-----------------
 O(1) extra space
 (Only variables are used; nodes are part of the list)

 ============================================================================
 */

void createList(int n) {

    // Scanner object to take input from the user
    Scanner sc = new Scanner(System.in);

    // Loop runs n times to create n nodes
    for (int i = 0; i < n; i++) {

        // Ask user to enter data for each node
        System.out.print("Enter data: ");

        // Read integer value
        int data = sc.nextInt();

        // Insert the value at the end of the linked list
        // This preserves the input order
        insertAtEnd(data);
    }
}


        /*---------------------------------------------------------
          METHOD: insertAtEnd
        ---------------------------------------------------------*/
        /* 
 PURPOSE:
 --------
 Inserts a new node with the given data at the **end** of the singly linked list.

 ============================================================================
 PARAMETERS:
 -----------
 data → integer value to be inserted into the linked list

 ============================================================================
 LOGIC / APPROACH:
 -----------------
 1. Create a new node with the given data.
 2. Check if the linked list is empty:
    • If YES → make both head and tail point to the new node.
    • If NO  → link the current tail to the new node and update tail.
 3. Using the tail pointer ensures insertion happens in constant time.

 ============================================================================
 TIME COMPLEXITY:
 ----------------
 O(1)
 (Insertion at end using tail pointer)

 ============================================================================
 SPACE COMPLEXITY:
 -----------------
 O(1) extra space
 (Only one new node is created)

 ============================================================================
 SPECIAL NOTES FOR LOGIC:
 ------------------------
 • Tail pointer is maintained to avoid traversing the entire list.
 • Without tail, insertion at end would take O(n).
 • This method preserves the existing order of elements.

 ============================================================================
 */

void insertAtEnd(int data) {

    // Create a new node with the given data
    Node newNode = new Node(data);

    // If the list is empty
    if (head == null) {
        // Both head and tail point to the new node
        head = tail = newNode;
    } else {
        // Link current tail node to the new node
        tail.next = newNode;

        // Update tail to point to the new node
        tail = newNode;
    }
}


        /*---------------------------------------------------------
          METHOD: insertAtBeg
        ---------------------------------------------------------*/
        /* 
 PURPOSE:
 --------
 Inserts a new node with the given data at the **beginning** of the singly
 linked list.

 ============================================================================
 PARAMETERS:
 -----------
 data → integer value to be inserted at the start of the list

 ============================================================================
 LOGIC / APPROACH:
 -----------------
 1. Create a new node with the given data.
 2. Point the new node’s `next` to the current head.
 3. Update `head` to the new node.
 4. If the list was empty earlier, also update `tail`.

 ============================================================================
 TIME COMPLEXITY:
 ----------------
 O(1)
 (Insertion at beginning always takes constant time)

 ============================================================================
 SPACE COMPLEXITY:
 -----------------
 O(1) extra space
 (Only one new node is created)

 ============================================================================
 SPECIAL NOTES FOR LOGIC:
 ------------------------
 • Inserting at beginning does NOT require traversal.
 • Updating `tail` is important when the list was initially empty.
 • This operation changes the head of the list.

 ============================================================================
 */

void insertAtBeg(int data) {

    // Create a new node with the given data
    Node newNode = new Node(data);

    // Link new node to the current head
    newNode.next = head;

    // Update head to point to the new node
    head = newNode;

    // If the list was empty earlier,
    // tail should also point to the new node
    if (tail == null) {
        tail = head;
    }
}


        /*---------------------------------------------------------
          METHOD: insertAtPos
        ---------------------------------------------------------*/
        /* 
 PURPOSE:
 --------
 Inserts a new node with the given data at a **specific position (index)**  
 in the singly linked list.

 ============================================================================
 PARAMETERS:
 -----------
 data → integer value to be inserted  
 pos  → index at which the new node should be inserted (0-based)

 ============================================================================
 LOGIC / APPROACH:
 -----------------
 1. Validate the position:
    • If pos < 0 or pos > number of nodes → invalid.
 2. If pos == 0:
    • Insert at the beginning using insertAtBeg().
 3. Otherwise:
    • Traverse the list until the node just before the desired position.
    • Create a new node.
    • Adjust links to insert the new node in between.

 ============================================================================
 EXAMPLE:
 --------
 Linked List: 10 → 20 → 30 → X  
 insertAtPos(15, 1)

 Steps:
 • Traverse to node at index 0 (value 10)
 • Insert 15 after 10

 Result:
 10 → 15 → 20 → 30 → X

 ============================================================================
 DRY RUN:
 --------
 data = 40, pos = 2  
 List = 10 → 20 → 30

 temp initially = head (10)
 Loop runs once → temp = 20

 newNode = 40
 newNode.next = temp.next (30)
 temp.next = newNode

 Final list:
 10 → 20 → 40 → 30

 ============================================================================
 TIME COMPLEXITY:
 ----------------
 O(n)
 (Traversal required to reach the given position)

 ============================================================================
 SPACE COMPLEXITY:
 -----------------
 O(1) extra space
 (Only one new node is created)

 ============================================================================
 SPECIAL NOTES FOR LOGIC:
 ------------------------
 • Position is **0-based indexing**.
 • insertAtBeg() is reused for clean design.
 • No traversal needed when pos == 0.
 • This method preserves the order of remaining nodes.

 ============================================================================
 */

void insertAtPos(int data, int pos) {

    // Check for invalid position
    if (pos < 0 || pos > countNode()) {
        System.out.println("Invalid position");
        return;
    }

    // Case 1: Insert at the beginning
    if (pos == 0) {
        insertAtBeg(data);
        return;
    }

    // Traverse to the node just before the required position
    Node temp = head;
    for (int i = 1; i < pos; i++) {
        temp = temp.next;
    }

    // Create a new node
    Node newNode = new Node(data);

    // Insert the new node in between
    newNode.next = temp.next;
    temp.next = newNode;
}


        /*---------------------------------------------------------
          METHOD: deletAtPos
        ---------------------------------------------------------*/
        /* 
 PURPOSE:
 --------
 Deletes a node at a **specific position (index)** from the singly
 linked list.

 ============================================================================
 PARAMETERS:
 -----------
 pos → index of the node to be deleted (0-based indexing)

 ============================================================================
 LOGIC / APPROACH:
 -----------------
 1. If the list is empty:
    • Nothing to delete → return.
 2. If pos == 0:
    • Delete the first node by moving head to head.next.
 3. Otherwise:
    • Traverse the list to reach the node just before `pos`.
    • Change its `next` pointer to skip the node to be deleted.

 ============================================================================
 EXAMPLE:
 --------
 Linked List: 10 → 20 → 30 → 40 → X  
 deleteAtPos(2)

 Steps:
 • Traverse to index 1 (node 20)
 • Skip node at index 2 (node 30)

 Result:
 10 → 20 → 40 → X

 ============================================================================
 DRY RUN:
 --------
 pos = 1  
 List = 5 → 15 → 25

 temp starts at head (5)
 Loop runs once → temp = 5

 temp.next = temp.next.next
 → temp.next = 25

 Final list:
 5 → 25

 ============================================================================
 TIME COMPLEXITY:
 ----------------
 O(n)
 (Traversal is required to reach the position)

 ============================================================================
 SPACE COMPLEXITY:
 -----------------
 O(1) extra space
 (No additional data structures used)

 ============================================================================
 SPECIAL NOTES FOR LOGIC:
 ------------------------
 • Uses **0-based indexing**.
 • Deleting at position 0 is a special case.
 • Pointer manipulation is used instead of shifting elements.
 • Assumes `pos` is valid (can add bounds checking if needed).

 ============================================================================
 */

void deletAtPos(int pos) {

    // If the list is empty, nothing to delete
    if (head == null) return;

    // Case 1: Delete the first node
    if (pos == 0) {
        head = head.next;
        return;
    }

    // Traverse to the node just before the target position
    Node temp = head;
    for (int i = 1; i < pos; i++) {
        temp = temp.next;
    }

    // Bypass (skip) the node at position `pos`
    temp.next = temp.next.next;
}


        /*---------------------------------------------------------
          METHOD: display
        ---------------------------------------------------------*/
        /* 
 PURPOSE:
 --------
 Displays (prints) all elements of the singly linked list in sequence,
 starting from the head node up to the last node.

 ============================================================================
 PARAMETERS:
 -----------
 None

 ============================================================================
 LOGIC / APPROACH:
 -----------------
 1. Start traversal from the head node.
 2. Move through the list using the `next` pointer.
 3. Print each node’s data followed by an arrow (`->`).
 4. After reaching the end (null), print `X` to indicate list termination.

 ============================================================================
 EXAMPLE:
 --------
 Linked List:
 10 → 20 → 30 → X

 Output:
 10->20->30->X

 ============================================================================
 DRY RUN:
 --------
 temp = head (10)

 Iteration 1:
 • Print 10->
 • temp = 20

 Iteration 2:
 • Print 20->
 • temp = 30

 Iteration 3:
 • Print 30->
 • temp = null

 Exit loop → print X

 ============================================================================
 TIME COMPLEXITY:
 ----------------
 O(n)
 (Every node is visited exactly once)

 ============================================================================
 SPACE COMPLEXITY:
 -----------------
 O(1)
 (Only a temporary pointer is used)

 ============================================================================
 SPECIAL NOTES FOR LOGIC:
 ------------------------
 • Uses a temporary pointer to avoid modifying `head`.
 • The `X` symbol clearly marks the end of the linked list.
 • Works for empty list as well (prints just `X` if head is null).

 ============================================================================
 */

void display() {

    // Temporary pointer to start traversal from head
    Node temp = head;

    // Traverse entire list until null is reached
    while (temp != null) {
        System.out.print(temp.data + "->");
        temp = temp.next;  // move to next node
    }

    // Print end marker to indicate end of list
    System.out.println("X");
}


        /*---------------------------------------------------------
          METHOD: countNode
        ---------------------------------------------------------*/
        /* 
 PURPOSE:
 --------
 Counts the total number of nodes present in the singly linked list.

 ============================================================================
 PARAMETERS:
 -----------
 None

 ============================================================================
 LOGIC / APPROACH:
 -----------------
 1. Initialize a counter to 0.
 2. Start traversal from the head node.
 3. For each node visited:
    • Increment the counter by 1.
    • Move to the next node using the `next` reference.
 4. Stop when the pointer reaches `null`.
 5. Return the final count.

 ============================================================================
 EXAMPLE:
 --------
 Linked List:
 10 → 20 → 30 → X

 Output:
 countNode() = 3

 ============================================================================
 DRY RUN:
 --------
 temp = head (10), count = 0

 Iteration 1:
 • temp != null → count = 1
 • temp = 20

 Iteration 2:
 • temp != null → count = 2
 • temp = 30

 Iteration 3:
 • temp != null → count = 3
 • temp = null

 Loop ends → return 3

 ============================================================================
 TIME COMPLEXITY:
 ----------------
 O(n)
 (Each node is visited exactly once)

 ============================================================================
 SPACE COMPLEXITY:
 -----------------
 O(1)
 (Uses only constant extra space)

 ============================================================================
 SPECIAL NOTES FOR LOGIC:
 ------------------------
 • Uses a temporary pointer so the `head` reference remains unchanged.
 • Works correctly for:
     - Empty list → returns 0
     - Single node list → returns 1
 • This method is frequently used by other operations
   (e.g., insertAtPos, deleteAtPos, bounds checking).

 ============================================================================
 */

int countNode() {

    int count = 0;        // counter to store number of nodes
    Node temp = head;     // temporary pointer starting from head

    // Traverse the linked list
    while (temp != null) {
        count++;          // increment count for each node
        temp = temp.next; // move to next node
    }

    return count;         // return total number of nodes
}


        /*---------------------------------------------------------
          METHOD: itrSearch
        ---------------------------------------------------------*/
        /* 
 PURPOSE:
 --------
 Searches for a given key in the singly linked list using
 an iterative (linear search) approach and returns its index.

 ============================================================================
 PARAMETERS:
 -----------
 key → the value to be searched in the linked list

 ============================================================================
 RETURN VALUE:
 -------------
 • Index (0-based) of the node if key is found
 • -1 if the key is not present in the list

 ============================================================================
 LOGIC / APPROACH:
 -----------------
 1. Start traversal from the head node.
 2. Maintain an `index` counter starting from 0.
 3. For each node:
    • Compare node's data with the given key.
    • If match is found → return current index.
    • Otherwise, move to the next node and increment index.
 4. If traversal ends and key is not found → return -1.

 ============================================================================
 EXAMPLE:
 --------
 Linked List:
 10 → 20 → 30 → 40 → X

 Search key = 30

 Output:
 itrSearch(30) = 2

 ============================================================================
 DRY RUN:
 --------
 key = 30

 temp = head (10), index = 0
 • 10 != 30 → move ahead

 temp = 20, index = 1
 • 20 != 30 → move ahead

 temp = 30, index = 2
 • 30 == 30 → return 2

 ============================================================================
 TIME COMPLEXITY:
 ----------------
 O(n)
 (In worst case, entire list is traversed)

 ============================================================================
 SPACE COMPLEXITY:
 -----------------
 O(1)
 (No extra space used)

 ============================================================================
 SPECIAL NOTES FOR LOGIC:
 ------------------------
 • This is a simple linear search since linked lists do not support
   random access like arrays.
 • Stops immediately once the key is found (early termination).
 • Safe for:
     - Empty list → directly returns -1
     - Single node list
 • Indexing is 0-based.

 ============================================================================
 */

public static int itrSearch(int key) {

    Node temp = head;  // temporary pointer starting from head
    int index = 0;     // keeps track of node position

    // Traverse the linked list linearly
    while (temp != null) {

        // If key matches current node's data
        if (temp.data == key)
            return index; // key found at this index

        temp = temp.next; // move to next node
        index++;          // increment index
    }

    // Key not found in the list
    return -1;
}


        /*---------------------------------------------------------
          METHOD: recursiveSearch
        ---------------------------------------------------------*/
        /* 
 PURPOSE:
 --------
 Searches for a given key in the singly linked list using
 a recursive approach and returns its index.

 ============================================================================
 PARAMETERS:
 -----------
 key → the value to be searched in the linked list

 ============================================================================
 RETURN VALUE:
 -------------
 • Index (0-based) of the node if key is found
 • -1 if the key is not present in the list

 ============================================================================
 LOGIC / APPROACH:
 -----------------
 1. Start recursion from the head node.
 2. At each recursive call:
    • If current node is NULL → key not found → return -1.
    • If current node’s data equals the key → return 0.
 3. Otherwise, recursively search in the remaining list.
 4. While returning back:
    • If key was found deeper, add 1 to index.
    • If not found, propagate -1 upwards.

 ============================================================================
 EXAMPLE:
 --------
 Linked List:
 10 → 20 → 30 → 40 → X

 Search key = 30

 Output:
 recursiveSearch(30) = 2

 ============================================================================
 DRY RUN:
 --------
 helper(10, 30)
 → helper(20, 30)
   → helper(30, 30)
     → return 0   (key found)

 Backtracking:
 helper(20) returns 0 + 1 = 1
 helper(10) returns 1 + 1 = 2

 Final Answer = 2

 ============================================================================
 TIME COMPLEXITY:
 ----------------
 O(n)
 (Each node is visited once)

 ============================================================================
 SPACE COMPLEXITY:
 -----------------
 O(n)
 (Recursive call stack in worst case)

 ============================================================================
 SPECIAL NOTES FOR LOGIC:
 ------------------------
 • Recursion naturally handles traversal without loops.
 • Index adjustment (`idx + 1`) is done during backtracking.
 • Base case prevents infinite recursion.
 • Returns -1 consistently if key is absent.

 ============================================================================
 */

public static int recursiveSearch(int key) {

    // Start recursive search from the head of the list
    return helper(head, key);
}

// Helper function for recursive search
private static int helper(Node head, int key) {

    // Base case: reached end of list
    if (head == null)
        return -1;

    // If key matches current node
    if (head.data == key)
        return 0;  // index of current node

    // Recursive call on next node
    int idx = helper(head.next, key);

    // If key not found in remaining list
    if (idx == -1)
        return -1;

    // Otherwise, increment index while returning
    return idx + 1;
}


        /*---------------------------------------------------------
          METHOD: reverse
        ---------------------------------------------------------*/
        /* 
 PURPOSE:
 --------
 Reverses the singly linked list in-place using an iterative approach.

 ============================================================================
 PARAMETERS:
 -----------
 None
 (Operates directly on the linked list using the head pointer)

 ============================================================================
 LOGIC / APPROACH:
 -----------------
 1. Use three pointers:
    • prev → keeps track of the previous node
    • curr → points to the current node being processed
    • next → temporarily stores the next node
 2. Traverse the list node by node.
 3. For each node:
    • Save the next node.
    • Reverse the current node’s `next` pointer.
    • Move `prev` and `curr` one step forward.
 4. After traversal, `prev` will point to the new head.
 5. Update `head` to `prev`.

 ============================================================================
 EXAMPLE:
 --------
 Original List:
 10 → 20 → 30 → 40 → X

 After reverse():
 40 → 30 → 20 → 10 → X

 ============================================================================
 DRY RUN:
 --------
 Initial:
 prev = null
 curr = 10

 Iteration 1:
 next = 20
 curr.next = null
 prev = 10
 curr = 20

 Iteration 2:
 next = 30
 curr.next = 10
 prev = 20
 curr = 30

 Iteration 3:
 next = 40
 curr.next = 20
 prev = 30
 curr = 40

 Iteration 4:
 next = null
 curr.next = 30
 prev = 40
 curr = null (loop ends)

 Final:
 head = prev = 40

 ============================================================================
 KEY POINTS:
 ------------
 ✔ Uses constant extra space
 ✔ No recursion used
 ✔ Efficient pointer manipulation
 ✔ Works for empty and single-node lists

 ============================================================================
 TIME COMPLEXITY:
 ----------------
 O(n)
 (Each node is visited exactly once)

 ============================================================================
 SPACE COMPLEXITY:
 -----------------
 O(1)
 (In-place reversal, no extra data structures)

 ============================================================================
 SPECIAL NOTES FOR LOGIC:
 ------------------------
 • `next` pointer is crucial to avoid losing the remaining list.
 • Order of operations matters:
      - Save next
      - Reverse link
      - Move pointers forward
 • After loop, `prev` becomes the new head.

 ============================================================================
 */

public void reverse() {

    Node prev = null;     // Will store previous node
    Node curr = head;     // Start from head

    // Traverse the entire linked list
    while (curr != null) {

        // Store next node before breaking the link
        Node next = curr.next;

        // Reverse the link
        curr.next = prev;

        // Move prev and curr one step forward
        prev = curr;
        curr = next;
    }

    // Update head to new first node
    head = prev;
}


        /*---------------------------------------------------------
          METHOD: isPalindrome
        ---------------------------------------------------------*/
        /* 
 ============================================================================
  METHOD: isPalindrome()
 ============================================================================
 PURPOSE:
 --------
 Checks whether the singly linked list is a palindrome.

 A linked list is called a palindrome if the sequence of values
 is the same when read from left to right and right to left.

 ============================================================================
 PARAMETERS:
 -----------
 None
 (Operates on the linked list starting from `head`)

 ============================================================================
 LOGIC / APPROACH:
 -----------------
 The method follows a **three-step approach**:

 1️ Find the middle of the linked list  
    • Uses the slow–fast pointer technique.
    • Slow pointer moves 1 step, fast pointer moves 2 steps.
    • When fast reaches the end, slow is at the middle.

 2️ Reverse the second half of the linked list  
    • Reverse nodes starting from the middle node.
    • This allows backward comparison using forward traversal.

 3️ Compare both halves  
    • Compare nodes from the start (left half) and reversed second half.
    • If any mismatch occurs → not a palindrome.

 ============================================================================
 EXAMPLE:
 --------
 Linked List:
 1 → 2 → 3 → 2 → 1

 Middle Node:
 3

 Second Half (before reverse):
 3 → 2 → 1

 Second Half (after reverse):
 1 → 2 → 3

 Comparison:
 Left:  1 → 2 → 3
 Right: 1 → 2 → 3  ✔

 Result:
 true

 ============================================================================
 DRY RUN:
 --------
 Input: 1 → 2 → 2 → 1

 Step 1: mid = 2 (second node)
 Step 2: reverse from mid → 1 → 2
 Step 3: compare
   left = 1, right = 1 → match
   left = 2, right = 2 → match

 Output: true

 ============================================================================
 TIME COMPLEXITY:
 ----------------
 O(n)
 • Finding middle → O(n)
 • Reversing second half → O(n)
 • Comparing halves → O(n)

 ============================================================================
 SPACE COMPLEXITY:
 -----------------
 O(1)
 • In-place reversal
 • No extra data structures used

 ============================================================================
 SPECIAL NOTES FOR LOGIC:
 ------------------------
 • Only the second half of the list is reversed to save space.
 • Comparison runs until `right` becomes null.
 • The list structure can be restored by reversing the second half again
   if required.

 ============================================================================
 */

public boolean isPalindrome() {

    // Step 1: Find the middle node of the linked list
    Node mid = findMid(head);

    // Step 2: Reverse the second half of the list starting from mid
    Node secondHalf = reverseList(mid);

    // Step 3: Initialize pointers for comparison
    Node left = head;          // start of first half
    Node right = secondHalf;   // start of reversed second half

    // Compare nodes from both halves
    while (right != null) {

        // If data mismatch, list is not palindrome
        if (left.data != right.data)
            return false;

        // Move both pointers forward
        left = left.next;
        right = right.next;
    }

    // All nodes matched → palindrome
    return true;
}


/* 
 ============================================================================
  METHOD: reverseList(Node node)
 ============================================================================
 PURPOSE:
 --------
 Reverses a singly linked list starting from the given node
 and returns the new head of the reversed list.

 ============================================================================
 PARAMETERS:
 -----------
 node → starting node of the list to be reversed

 ============================================================================
 LOGIC / APPROACH:
 -----------------
 • Use three pointers:
    - prev → previous node
    - node → current node
    - next → next node
 • Reverse the direction of `next` pointer for each node.
 • Move pointers forward until the end is reached.

 ============================================================================
 EXAMPLE:
 --------
 Input:
 2 → 3 → 4 → null

 Output:
 4 → 3 → 2 → null

 ============================================================================
 TIME COMPLEXITY:
 ----------------
 O(n)
 (Each node is visited once)

 ============================================================================
 SPACE COMPLEXITY:
 -----------------
 O(1)
 (In-place reversal)

 ============================================================================
 SPECIAL NOTES FOR LOGIC:
 ------------------------
 • This method is iterative (no recursion).
 • Works for reversing full or partial linked lists.
 • Used internally by `isPalindrome()`.

 ============================================================================
 */

private Node reverseList(Node node) {

    Node prev = null;  // Will become new head after reversal

    // Traverse and reverse links
    while (node != null) {

        Node next = node.next; // store next node
        node.next = prev;      // reverse current node's pointer
        prev = node;           // move prev forward
        node = next;           // move node forward
    }

    // prev is the new head of reversed list
    return prev;
}


        /*---------------------------------------------------------
          METHOD: isCycle (Floyd’s Algorithm)
        ---------------------------------------------------------*/
        /*
 ============================================================================
  METHOD: isCycle()
 ============================================================================
 PURPOSE:
 --------
 Detects whether a cycle (loop) exists in a singly linked list.

 A cycle exists if a node’s `next` pointer points to any previous node
 instead of `null`.

 ============================================================================
 PARAMETERS:
 -----------
 None
 (Operates on the linked list starting from `head`)

 ============================================================================
 LOGIC / APPROACH:
 -----------------
 This method uses **Floyd’s Cycle Detection Algorithm**
 (also called the Slow–Fast Pointer technique).

 1️⃣ Initialize two pointers:
     • slow → moves one step at a time
     • fast → moves two steps at a time

 2️⃣ Traverse the list while:
     • fast != null
     • fast.next != null

 3️⃣ At each step:
     • Move slow by one node
     • Move fast by two nodes

 4️⃣ If a cycle exists:
     • fast will eventually meet slow
     • When slow == fast → cycle detected

 5️⃣ If fast reaches null:
     • No cycle exists in the list

 ============================================================================
 EXAMPLE:
 --------
 Case 1: List with cycle
 1 → 2 → 3 → 4 → 5
           ↑       |
           └───────┘

 slow and fast will eventually meet → cycle exists

 Case 2: List without cycle
 1 → 2 → 3 → 4 → null

 fast reaches null → no cycle

 ============================================================================
 DRY RUN:
 --------
 List: 1 → 2 → 3 → 4 → 2 (cycle)

 Step 1:
   slow = 1, fast = 1

 Step 2:
   slow = 2, fast = 3

 Step 3:
   slow = 3, fast = 2

 Step 4:
   slow = 4, fast = 4  → slow == fast ✔

 Result:
   Cycle detected → return true

 ============================================================================
 TIME COMPLEXITY:
 ----------------
 O(n)
 • Each pointer traverses the list at most once

 ============================================================================
 SPACE COMPLEXITY:
 -----------------
 O(1)
 • No extra data structures used

 ============================================================================
 SPECIAL NOTES FOR LOGIC:
 ------------------------
 • This algorithm works without modifying the list.
 • It is more efficient than using HashSet (which needs O(n) space).
 • Comparing references (slow == fast) is key, not node values.

 ============================================================================
 */

public boolean isCycle() {

    // Initialize slow and fast pointers at head
    Node slow = head;
    Node fast = head;

    // Traverse list while fast pointer can move ahead
    while (fast != null && fast.next != null) {

        slow = slow.next;        // move slow by 1 step
        fast = fast.next.next;  // move fast by 2 steps

        // If slow and fast meet, cycle exists
        if (slow == fast)
            return true;
    }

    // Fast reached end → no cycle
    return false;
}
/* 
 ============================================================================
  METHOD: mergeSort()
 ============================================================================
 PURPOSE:
 --------
 Sorts a singly linked list using the **Merge Sort** algorithm.

 Merge Sort is preferred for linked lists because:
 • It does NOT require random access
 • It works efficiently with pointer manipulation
 • It guarantees O(n log n) time complexity

 ============================================================================
 PARAMETERS:
 -----------
 head → reference to the head node of the linked list (or sublist)

 ============================================================================
 RETURN:
 -------
 Node → head of the sorted linked list

 ============================================================================
 INTUITION:
 ----------
 • A linked list can be divided into two halves using slow–fast pointers.
 • Recursively sort both halves.
 • Merge the two sorted halves into one sorted list.
 • Repeating this process ensures the entire list is sorted.

 ============================================================================
 LOGIC / APPROACH:
 -----------------
 Step 1️⃣ Base Case:
   • If list is empty OR contains only one node
   • It is already sorted → return head

 Step 2️⃣ Find Middle:
   • Use `midNode()` (slow–fast pointer technique)
   • This splits the list roughly into two equal halves

 Step 3️⃣ Split the List:
   • Left half → starts from `head`
   • Right half → starts from `mid.next`
   • Set `mid.next = null` to break the list into two parts

 Step 4️⃣ Recursive Sort:
   • Recursively apply mergeSort on left half
   • Recursively apply mergeSort on right half

 Step 5️⃣ Merge:
   • Merge the two sorted halves using `merger()`
   • Return the merged sorted list

 ============================================================================
 EXAMPLE:
 --------
 Input List:
   4 → 2 → 1 → 3

 Step-wise splitting:
   [4 → 2]   [1 → 3]
   [4] [2]   [1] [3]

 After sorting & merging:
   1 → 2 → 3 → 4

 ============================================================================
 DRY RUN:
 --------
 List: 4 → 2 → 1 → 3

 mergeSort(4→2→1→3)
   mid = 2
   left = 4→2
   right = 1→3

 mergeSort(4→2) → 2→4
 mergeSort(1→3) → 1→3

 merge(2→4 , 1→3)
 → 1 → 2 → 3 → 4

 ============================================================================
 TIME COMPLEXITY:
 ----------------
 O(n log n)
 • log n levels of recursion
 • each merge operation takes O(n)

 ============================================================================
 SPACE COMPLEXITY:
 -----------------
 O(log n)
 • Due to recursive call stack
 • No extra data structures used

 ============================================================================
 SPECIAL NOTES FOR LOGIC:
 ------------------------
 • Merge Sort is STABLE for linked lists
 • Much better than QuickSort for linked lists
 • Works efficiently because pointer manipulation is cheap
 • Requires a separate `midNode()` and `merger()` method

 ============================================================================
 */

public static Node mergeSort(Node head) {

    // Base case: empty list or single node list is already sorted
    if (head == null || head.next == null)
        return head;

    // Step 1: Find middle node
    Node mid = midNode(head);

    // Step 2: Split the list into two halves
    Node right = mid.next;  // start of right half
    mid.next = null;        // break the list

    // Step 3: Recursively sort both halves
    Node leftSorted = mergeSort(head);
    Node rightSorted = mergeSort(right);

    // Step 4: Merge the sorted halves
    return merger(leftSorted, rightSorted);
}

    }

    /*=============================================================
      MAIN METHOD
      =============================================================*/
    /*
 ============================================================================
  MAIN METHOD
 ============================================================================
 PURPOSE:
 --------
 Acts as the **driver code** to test and demonstrate the functionality
 of the Singly Linked List implementation.

 This method:
 • Takes user input for linked list size
 • Creates the linked list
 • Displays the linked list
 • Provides placeholders (commented lines) to test other linked list operations

 ============================================================================
 LOGIC / FLOW:
 -------------
 1. Create an object of `sLinkedlist`.
 2. Take input from the user for number of nodes.
 3. Call `createList(n)` to build the linked list.
 4. Display the linked list using `display()`.
 5. (Optional / Commented)
    • Zigzag rearrangement
    • Deletion
    • Reverse
    • Palindrome check
    • Cycle detection
    • Searching
    • Merge sort
    etc.

 ============================================================================
 WHY THIS MAIN METHOD IS IMPORTANT:
 ---------------------------------
 • Separates **implementation logic** from **testing logic**
 • Makes it easy to test individual methods by uncommenting lines
 • Helps in debugging and learning linked list operations step-by-step

 ============================================================================
 SPECIAL NOTES:
 --------------
 • Scanner is used for dynamic user input.
 • Only essential operations are executed by default.
 • Advanced operations are kept commented to avoid clutter.
 • Uncomment one feature at a time while testing.

 ============================================================================
 */

public static void main(String[] args) {

    // Create object of singly linked list
    sLinkedlist ll = new sLinkedlist();

    // Scanner for user input
    Scanner sc = new Scanner(System.in);

    // Ask user for size of linked list
    System.out.print("Enter size of linked list: ");
    int n = sc.nextInt();

    // ------------------------------------------------------------
    // Create linked list with n nodes
    // ------------------------------------------------------------
    ll.createList(n);

    // ------------------------------------------------------------
    // Display the linked list
    // ------------------------------------------------------------
    ll.display();
    System.out.println();

    // ------------------------------------------------------------
    // OPTIONAL TEST CASES (Uncomment as needed)
    // ------------------------------------------------------------

    // Zigzag rearrangement of linked list
    // ll.zigzag();

    // Delete node at position 0
    // ll.deletAtPos(0);

    // Print tail and head values
    // System.out.println("Tail is: " + ll.tail.data);
    // System.out.println("Head is: " + ll.head.data);

    // Get element at index
    // System.out.println(ll.getElement(2));

    // Recursive display
    // displayRecursive(ll.head);

    // Reverse display
    // displayReverse(ll.head);

    // Count nodes
    // System.out.println(ll.countNode());

    // Iterative search
    // System.out.println(sLinkedlist.itrSearch(15));

    // Reverse the list
    // ll.reverse();

    // Check palindrome
    // System.out.println(ll.isPalindrome());

    // Cycle detection test
    // System.out.println(ll.isCycle());

    // Merge sort the linked list
    // ll.head = sLinkedlist.mergeSort(ll.head);
    // ll.display();
}

}
