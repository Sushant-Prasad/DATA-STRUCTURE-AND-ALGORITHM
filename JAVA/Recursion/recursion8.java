package Recursion;
//WAF to find last occurence of an element in an array
//TC:- O(n)
// if array has n element and stack call is also n then 
//space complexicity is O(n+n) which ultemetly give O(n).
public class recursion8{
    public static int lastOccur(int arr[],int key,int i){
        if(i==arr.length){
            return -1;//-1 indicates that key is not found
        }
        int isFound = lastOccur(arr,key,i+1);// checking forward conditions.
        if(isFound ==-1 && arr[i]==key){ //key is not found in forward indexes so comparing 
                                        //with cuurent index
            return i;
        }
        
            return isFound;
        }
    public static void main(String args[]){
        int arr[] = {8,3,6,9,5,10,2,5,3};
       int key = 5;
        int i = 0;//position from where we have to check
        System.out.println(lastOccur(arr,key,i));
    }
    
}
