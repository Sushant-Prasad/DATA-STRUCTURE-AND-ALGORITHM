package Queue;
//Queue implementation using linkedlist
public class Queue3 {
  static class Node {
    int data;
    Node next;
    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }
  static class Queue {
    Node head = null;
    Node tail = null;

    // isEmpty
    public boolean isEmpty() {
      return (head == null && tail == null);
    }
    // add
    public void add(int data) {
      Node newNode = new Node(data);
      // for 1st element
      if (head == null) {
        head = tail = newNode;
        return;
      }
      tail.next = newNode;
      tail = newNode;

    }

    // remove
    public int remove() {
      if (isEmpty()) {
        return -1;
      }
      int result = head.data;
      // for removing single last element
      if (head == tail) {
        head = tail = null;  
      }else{
      head = head.next;
    }
      return result;
    }

    // peak
    public int peek() {
      if (isEmpty())
        return -1;
      return head.data;
    }

    // display
    public void display() {
      if (isEmpty()) {
        System.out.println("empty");
      } else {
        while (!isEmpty()) {
          System.out.print(peek() + " ");
          remove();
        }
      }
    }
  }

  public static void main(String[] args) {
    Queue q = new Queue();
    q.add(5);
    q.add(10);
    q.add(18);
    q.add(20);
    q.add(25);
    
    q.display();

  }

}
