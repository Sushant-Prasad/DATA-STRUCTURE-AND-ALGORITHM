package Recursion;
// checking a given array is sorted or not.
//TC:- O(n)
// if array has n element and stack call is also n then 
//space complexicity is O(n+n) which ultemetly give O(n).
public class recursion6 {
    public static boolean isSorted(int arr[],int i){
        if(i==arr.length-1){ // base case
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr,i+1);
    } 
     public static void main(String args[]){
        int arr[] = {1,2,3,4,5};
        int i = 0;//position from where we have to check
System.out.println(isSorted(arr,i));
    }
    
    
}
