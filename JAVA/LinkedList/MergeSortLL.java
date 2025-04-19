package LinkedList;
import java.util.LinkedList;
public class MergeSortLL {
  public static class Node{
    int data;
    Node next;
     Node(int data){ // creating a constructor which will create a node object
        this.data = data;
        this.next = null;
    }
    
}
public static Node head = null;
    public static Node tail = null;
 
  public Node midNode(Node head){
    Node slow=head;
    Node fast=head.next;
    while(fast!=null && fast.next!=null){
      slow=slow.next;
      fast=fast.next.next;
    }
    return slow;//mid node
  }
  public Node merge(Node headLeft,Node headRight){
    Node mergeLL = new Node(-1);//dummy node
    Node temp=mergeLL;
    while(headRight!=null && headLeft!=null){
      if(headRight.data>=headLeft.data){
        temp.next=headLeft;
        headLeft=headLeft.next;
        temp=temp.next;
      }else{
        temp.next=headRight;
        headRight=headRight.next;
        temp=temp.next;

      }
      while(headLeft!=null){
        temp.next=headLeft;
        headLeft=headLeft.next;
        temp=temp.next;
      }
      while(headRight!=null){
        temp.next=headRight;
        headRight=headRight.next;
        temp=temp.next;

      }
    }
    return mergeLL.next;

  }
    
  public Node mergeSort(Node head){
    if(head== null || head.next==null){
      return head;
    } 
   //find mid node
   Node mid = midNode(head);
   //left and right half ll
   Node rh = mid.next;// right half ll
   mid.next=null;
    // recursive call
   Node newLeftHalf=mergeSort(head);
   Node newRightHalf=mergeSort(rh);
   //merge both half
   return merge(newLeftHalf,newRightHalf);
  }
  public static void main(String[] args) {
     LinkedList<Integer> ll = new LinkedList<>();

     ll.addFirst(5);
     ll.addLast(10);
     ll.addLast(12);
     ll.addLast(15);
     ll.addLast(17);
     ll.addLast(19);
     System.out.println(ll);
     System.out.println(ll.mergeSort(ll.head));
  }
  
}
