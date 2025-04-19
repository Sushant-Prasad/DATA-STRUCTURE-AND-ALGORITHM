package LinkedList;
// singly linkedlist

import java.util.LinkedList;
import java.util.Scanner;

public class linkedlist {
    public static class Node{
        int data;
        Node next;
         Node(int data){ // creating a constructor which will create a node object
            this.data = data;
            this.next = null;
        }
    }
    private static linkedlist.Node head;
    private static linkedlist.sLinkedlist ll;
    Scanner sc = new Scanner(System.in);
    public static class sLinkedlist{ // data structure
    public static Node head = null;
    public static Node tail = null;
    
    void createList(int n){ // this method will create a linkedlist of size n. 
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
    void insertAtBeg(int data){
        Node newNode = new Node(data);
        if(head == null){//If list is empty, both head and tail will point to new node 
            head = tail = newNode;

        }
        else{
            newNode.next= head;
            head = newNode;
            
        }
    }
    void insertAtPos(int data, int pos){
         Node newNode = new Node(data);
         Node temp = head;
         if(head == null){//If list is empty, both head and tail will point to new node 
            head = tail = newNode;
            return;

        }else if(pos ==  countNode()){
            insertAtEnd(data);
            return;

        }
        else if(pos == 0){
            insertAtBeg(data);
            return;
        }
        else if(pos<0 || pos>countNode()){
            System.out.println("invalid position");
        }
        else{
            for(int i= 1;i<=pos-1;i++){
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next= newNode;

        }
    }
    int getElement(int pos){ // return the element of any given index
        Node temp = head;
        if(head == null){
            System.out.println("no element");
            return -1;

        } else if(pos<0 || pos>countNode()){
            System.out.println("invalid position");
            return -1;
        }
        else{
           for(int i=1;i<=pos;i++){
            temp = temp.next;
           }
          
        }
         return temp.data;
    }
    void deletAtPos(int pos){
        if(pos == 0){
            head = head.next;
            return;
        }
         Node temp = head;
         if(head == null){
            System.out.println("no node");
         }else if(pos<0 || pos>countNode()){
            System.out.println("invalid position");
        }else{
        for(int i=1;i<=pos-1;i++){
            temp=temp.next;
        }
        temp.next = temp.next.next;
        tail = temp;
    
    }
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

    public static void displayRecursive(Node head){// printing the list using recusive function
        Node temp= head;
        if(temp == null){
             return;
        }
        System.out.print(temp.data + "->");
        displayRecursive(temp.next);

    }
     public static void displayReverse(Node head){// printing the list in reverse order
        Node temp= head;
        if(temp == null){
             return;
        }
        displayReverse(temp.next);
        System.out.print(temp.data + "->");
      

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
    public static int itrSearch(int key){//return the position of given key/value
        Node temp=head;
        int count=0;
        while(temp!=null){
            if(key==temp.data){
                return count;
            }
            temp=temp.next;
            count++;

        }
        return -1;// if key is not found
    }
    //--------RECURSIVE APPROACH FOR FINDING POSITION OF A GIVEN KEY---------------
    public static int helper(Node head,int key){
        //base case
        if(head==null){
            return -1;
        }
        if(head.data==key){// head as index 0
            return 0;
        }
        int index=helper(head.next,key);// recursive call
        return index+1;
    }
    public static int recursiveSearch(int key){//return the position of given key/value
        return helper(head,key);
    }
    //----------RECURSIVE APPROACH FOR FINDING POSITION OF A GIVEN KEY--------------
     void deleteNthFromEnd(int n){
        int size= countNode();
        if(size==n){
            head=head.next;//removing first node
        }
        int a = size-n+1;
        Node temp = head;

        for(int i = 0;i<a-2;i++){// go prev node of required node

            temp = temp.next;
        }
        temp.next=temp.next.next;

    }
    public void reverse(){
        Node prev =null;
        Node curr= head;
        Node nextNode;
        while(curr!=null){
            nextNode=curr.next;
            prev=curr.next;
            prev=curr;
            curr=nextNode;
        }
    }
    Node findMid(Node head){ // slow-fast technique
        Node slow=head;//+1 step 
        Node fast=head;//+2 step 
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;// slow is midNode
    }
    public boolean isPalindrome(){
        //step-1:- find mid node
        Node midNode= findMid(head);
        //step-2:- reverse 2nd half
        Node prev=null;
        Node curr=midNode;
        Node nextNode;
        while(curr!=null){
            nextNode=curr.next;
            prev=curr.next;
            prev=curr;
            curr=nextNode;
        }
        //step-3:- check left half & right half
        Node rightHead=prev;// head of right half
        Node leftHead = head;// head of left half
        while(rightHead!=null){
            if(rightHead.data!=leftHead.data)return false;
            leftHead=leftHead.next;
            rightHead=rightHead.next;
        }
        return true;
        }
        //Floyd cycle finding algorithm:- 
        public boolean isCycle(){
            Node fast=head;
            Node slow=head;
             while(fast!=null && fast.next!=null){
                // dont check fast==slow for head 
                slow=slow.next;
                fast=fast.next.next;
                //if there exist a cxycle in LL then after sometime slow == fast
                if(fast==slow)return true;//cycle/loop is present     
            }
            return false;//cycle/loop is absent 
        }
        public void removeCycle(){
            //step-1:-detect cycle
            Node slow=head;
            Node fast=head;
            boolean cycle=false;
            while(fast!=null && fast.next!=null ){
                slow=slow.next;
                fast=fast.next.next;
                if(slow==fast){
                    cycle = true;
                    break;
                }
            }
            if(cycle==false)return;
           
            //step-2:-find last node
            slow=head;
            Node prev=null;
            while(slow != fast){
                slow=slow.next;
                prev=fast;
                fast=fast.next;
            }
            Node lastNode=prev;
            //step-3:- remove cycle by setting lastNOde.next=null;
            lastNode.next=null; 
        }
        //-------------MERGE SORT---------------------------
       public static Node midNode(Node head){
         // Your code here.
      Node  slow = head;
      Node fast = head.next;
      while(fast!=null && fast.next != null){
          slow = slow.next;
          fast=fast.next.next;
      }
      return slow;// mid node
    }
    // for combining the two linked lists 
    public static Node merger(Node head1 , Node head2){
          Node dummynode = new Node(-1);
          Node temp = dummynode;
          while(head1 != null && head2 != null){
                 if(head1.data <head2.data){
                     temp.next=head1;
                     temp = head1;
                     head1 = head1.next;
                 }else{
                     temp.next=head2;
                     temp = head2;
                     head2 = head2.next;
                 }
          }
        if(head1 !=null){
            temp.next = head1;
        }else{
            temp.next = head2;
        }
        
        return dummynode.next;
    }
    //Function to sort the given linked list using Merge Sort.
    public static Node mergeSort(Node head)
    {
        // add your code here
        if(head == null || head.next == null){
            return head;
        }
        Node mid = midNode(head);
        Node right = mid.next;// right half
        mid.next = null;
        Node newleft = mergeSort(head);// head is left part
        Node newright=mergeSort(right);
        return  merger(newleft , newright);
    }
//--------------------MERGE SORT-------------------------
public void zigzag(Node head){
    //find mid node
    Node mid=midNode(head);
    //reverse second half
    Node prev=null;
    Node curr= head;
    Node nextNode;
    while(curr!=null){
        nextNode=curr.next;
        prev=curr.next;
        prev=curr;
        curr=nextNode;
    }
    //alternate merging
    Node left=head;
    Node right=prev;// head of right half
    Node nextL,nextR;//nextleft and nextRight
    while(left!=null && right!=null){
        nextL=left.next;
        left.next= right;
        nextR=right.next;
        right.next=nextL;
        //update
        right=nextR;
        left=nextL;

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
       ll.zigzag();
    //     System.out.println();
        // //ll.deletAtPos(0);
        //  //System.out.println();
        //  System.out.println("tail is :"+ll.tail.data);
        //   System.out.println("head is "+ll.head.data);
        // //System.out.println(ll.getElement(10));
        // // displayRecursive(a);
        //  System.out.println();
        // // displayReverse(a);
        // // System.out.println();
        // System.out.println(ll.countNode());
        //System.out.println(linkedlist.sLinkedlist.recursiveSearch(15));
    //     ll.reverse();
    //     System.out.println();
    //    System.out.println(ll.isPalindrome());
        // head = new Node(1);
        // head.next= new Node(2);
        // Node temp = new Node(3);
        // head.next.next= temp;
        // head.next.next.next= new Node(4);
        // head.next.next.next.next= new Node(5);
        // head.next.next.next.next.next= temp;
        // ll.display();
        //1->2->3->4->5->3
        // System.out.println(ll.isCycle());
    //     LinkedList<Integer> ll2 = new LinkedList<>();

    //  ll2.addLast(5);
    //  ll2.addLast(10);
    //  ll2.addLast(12);
    //  ll2.addLast(15);
    //  ll2.addLast(17);
    //  ll2.addLast(19);
    //  System.out.println(ll);

    
    // 
       
    }
}
    
    

