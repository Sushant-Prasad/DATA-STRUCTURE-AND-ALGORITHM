package Recursion;
//WAF to find first occurence of an element in an array
//TC:- O(n)
// if array has n element and stack call is also n then 
//space complexicity is O(n+n) which ultemetly give O(n).
public class recursion7 {
    public static int firstOccur(int arr[],int key,int i){
        if(i==arr.length){
            return -1;//-1 indicates that key is not found
        }
        if(key==arr[i]){
            return i;
        }
        return firstOccur(arr,key,i+1);
    }
    public static void main(String args[]){
        int arr[] = {8,3,6,9,5,10,2,5,3};
       int key = 5;
        int i = 0;//position from where we have to check
        System.out.println(firstOccur(arr,key,i));
    }
    
}
