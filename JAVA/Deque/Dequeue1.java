/*
===========================================================
TITLE
===========================================================
Implement Stack and Queue Using Deque

===========================================================
PROBLEM STATEMENT
===========================================================
Implement a **Stack** and a **Queue** using the `Deque`
(Double Ended Queue) data structure.

You must support standard operations:
• Stack  → push, pop, peek, isEmpty
• Queue  → add, remove, peek, isEmpty

===========================================================
INTUITION
===========================================================
A Deque allows insertion and deletion from **both ends**:
• Front
• Rear

Using this:
• Stack (LIFO):
  - push  → add at rear
  - pop   → remove from rear

• Queue (FIFO):
  - add    → add at rear
  - remove → remove from front

===========================================================
APPROACH
===========================================================
1) Use Java's `Deque` interface with `LinkedList`
2) For Stack:
   - push() → addLast()
   - pop()  → removeLast()
   - peek() → getLast()
3) For Queue:
   - add()    → addLast()
   - remove() → removeFirst()
   - peek()   → getFirst()
4) Handle empty cases by returning -1

===========================================================
EXAMPLE
===========================================================
Stack:
Push → 1 2 3 4
Pop  → 4 3 2 1

Queue:
Add    → 5 10 12 13
Remove → 5 10 12 13

===========================================================
TIME COMPLEXITY
===========================================================
O(1)
• All Deque operations are constant time

===========================================================
SPACE COMPLEXITY
===========================================================
O(n)
• Deque stores n elements

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• Deque is more powerful than Stack/Queue
• LinkedList implements Deque interface
• No need to manage pointers manually
===========================================================
*/

package Deque;

import java.util.*;

public class Dequeue1 {

    // ---------------------------------------------------
    // STACK implementation using Deque (LIFO)
    // ---------------------------------------------------
    static class Stack {

        Deque<Integer> dqStack = new LinkedList<>();

        // Check if stack is empty
        public boolean isEmpty() {
            return dqStack.isEmpty();
        }

        // Push element onto stack
        public void push(int data) {
            dqStack.addLast(data); // add at rear
        }

        // Pop element from stack
        public int pop() {
            if (dqStack.isEmpty()) {
                return -1; // underflow condition
            }
            return dqStack.removeLast(); // remove from rear
        }

        // Peek top element of stack
        public int peek() {
            if (dqStack.isEmpty()) {
                return -1;
            }
            return dqStack.getLast(); // view rear element
        }
    }

    // ---------------------------------------------------
    // QUEUE implementation using Deque (FIFO)
    // ---------------------------------------------------
    static class Queue {

        Deque<Integer> dqQueue = new LinkedList<>();

        // Check if queue is empty
        public boolean isEmpty() {
            return dqQueue.isEmpty();
        }

        // Add element to queue
        public void add(int data) {
            dqQueue.addLast(data); // add at rear
        }

        // Remove element from queue
        public int remove() {
            if (dqQueue.isEmpty()) {
                return -1; // underflow condition
            }
            return dqQueue.removeFirst(); // remove from front
        }

        // Peek front element of queue
        public int peek() {
            if (dqQueue.isEmpty()) {
                return -1;
            }
            return dqQueue.getFirst(); // view front element
        }
    }

    public static void main(String[] args) {

        // -------- Stack Demo --------
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }

        // -------- Queue Demo --------
        Queue q = new Queue();
        q.add(5);
        q.add(10);
        q.add(12);
        q.add(13);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
