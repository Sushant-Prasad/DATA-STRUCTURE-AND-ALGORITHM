package LinkedList;
// finding nth Node from the end of the linked list
import java.util.Scanner;

public class LinkedList3 {
        public static class Node{
            int data;
            Node next;
             Node(int data){ //creating a constructor which will create a node object
                this.data = data;
                this.next = null;
            }
        }
        public static class sLinkedlist{ // data structure
            public static Node head = null;
            public static Node tail = null;
            void createList(int n){ // this method will add a new node to the list 
               for(int i=0;i<n;i++){
                System.out.println("Enter data");
                Scanner sc = new Scanner(System.in);
                int data= sc.nextInt();
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
        }
        int countNode(){
            Node temp = head;
            int count = 0;
            if(head == null){
                return 0;
    
            }
            else{
                while(temp != null){
                    count++;
                    temp = temp.next;
                }
            }
            return count;
        }
        int NthNodeFromLast(int n){
            int size = countNode();
            int a = size-n+1;
            Node temp = head;
            for(int i = 1;i<=a-1;i++){
                temp = temp.next;
            }
            return temp.data;
        }
        void display(){ // printing the list
            Node temp = head;
            if(head == null){
                System.out.println("empty list");
                return;
            }
            else{
            while(temp != null){
                System.out.print(temp.data +"->");
                temp = temp.next;
            }
            System.out.print("X");
        }
    }
    }
        public static void main(String args[]){
            sLinkedlist ll = new sLinkedlist();
            System.out.println("Enter size of linked list");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            ll.createList(n);
            ll.display();
            System.out.println();
            System.out.println(ll.NthNodeFromLast(4));
          
    }
}
    
