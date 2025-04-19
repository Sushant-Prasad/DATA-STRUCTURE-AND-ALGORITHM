package Queue;
//Circular Queue implementation using array
public class Queue2 {
  static class Queue {
    int arr[];
    int size;
    int rear;
    int front;

    Queue(int n) {
      arr = new int[n];
      size = n;
      rear = -1;
      front = -1;

    }

    // isEmpty
    public boolean isEmpty() {
      return (rear == -1 && front == -1);
    }

    // isFull
    public boolean isFull() {
      return (rear + 1) % size == front;
    }

    // add
    public void add(int data) {
      if (isFull()) {
        System.out.println("queue is full");
        return;
      }
      if (front == -1)
        front = 0; // for adding first element
      rear = (rear + 1) % size;
      arr[rear] = data;
    }

    // remove
    public int remove() {
      if (isEmpty()) {
        return -1;
      }
      int result = arr[front];
      if (front == rear) { // for removing last element
        front = rear = -1;
      } else {
        front = (front + 1) % size;
      }
      return result;
    }

    // peak
    public int peek() {
      if (isEmpty())
        return -1;
      return arr[front];
    }
     // display
     public void display() {
      if (isEmpty()) {
        System.out.println("empty");
      } else {
        while (!isEmpty()) {
          System.out.print(remove() + " ");
        }
      }
    }

  }

  public static void main(String[] args) {
    Queue q = new Queue(5);
    q.add(5);
    q.add(10);
    q.add(18);
    q.add(20);
    q.add(25);
    System.out.println(q.remove());
    q.add(30);
    System.out.println(q.remove());
    q.add(35);
    q.display();


  }

}
