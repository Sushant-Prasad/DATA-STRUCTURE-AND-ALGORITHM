package LinkedList;
public class linkedlist2 {
    public static class Node{
        int data;
        Node next;
         Node(int data){ // creating a constructor which will create a node object
            this.data = data;
            this.next = null;
        }
    }
    public static class sLinkedlist{
    public static Node head = null;
    public static Node tail = null;
    void insertAtEnd(int data){ // this method will add a new node to the list 
        Node newNode = new Node(data); //Creating a new node 
        if(head == null){
            //If list is empty, both head and tail will point to new node 
            head = tail = newNode;
        }
        else{
      tail.next = newNode;// new node will add at the end of list
      tail = newNode;    //newNode will become new tail of the list 
        }
    }
    public static void displayRecursive(Node head){// printing the list using recusive function
        Node temp= head;
        if(temp == null){
             return;
        }
        System.out.print(temp.data + "->");
        displayRecursive(temp.next);

    }
}
}
    

    

        public static void main(String args[]){
            sLinkedlist ll = new sLinkedlist();
            ll.insertAtEnd(5);
            ll.insertAtEnd(10);
            ll.insertAtEnd(15);
            ll.insertAtEnd(20);
            ll.insertAtEnd(25);
             ll.insertAtEnd(55);
            ll.displayRecursive(a.next);
    }
    

