package String;
import java.util.*;
public class string {
    public static void isPalindrome(String str) {
       int  flag=0;
        for(int i = 0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                flag=1;
                break;
            }
        }
        if(flag==1){
            System.out.println("Not Palindrome");
         }
         else{
        System.out.println("Palindrom");
    }
}
    public static void main(String args[]){
        String str;
        System.out.println("Enter a string ");
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        isPalindrome(str);
    }
}
