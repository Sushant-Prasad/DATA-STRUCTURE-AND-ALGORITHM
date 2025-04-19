package Queue;
//Queue implementation using array
public class Queue1 {
  static class Queue {
    int arr[];
    int size;
    int rear;

    Queue(int n) {
      arr = new int[n];
      size = n;
      rear = -1;

    }

    // isEmpty
    public boolean isEmpty() { 
      return rear == -1;
    }

    // add
    public void add(int data) {
      if (rear == size - 1) {
        System.out.println("queue is full");
        return;
      }
      rear = rear + 1;
      arr[rear] = data;
    }

    // remove
    public int remove() {
      if (rear == -1) {
        return -1;
      } 
      int front=arr[0];
      for(int i=0;i<rear;i++){
        arr[i]=arr[i+1];
      }
      rear=rear-1;
      return front;
    }

    // peak
    public int peek() {
      if (rear == -1)
        return -1;
      return arr[0];
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
    q.display();

  }

}
