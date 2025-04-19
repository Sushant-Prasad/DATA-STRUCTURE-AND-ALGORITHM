package String;
import java.util.*;
public class string5 {
    public static String compressedString(String str){
        StringBuilder sb = new StringBuilder(""); // initializing with empty string.
        for(int i=0;i<str.length();i++){
            Integer count =1; // creating 'count' as a class so that it can be converted into string
         while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
          count++;// counting repetitive letters
          i++;  
         }
         sb.append(str.charAt(i));
         if(count>1){
            sb.append(count);
         }
        }
        return sb.toString();
    }
    public static void main(String args[]){

        String str;
        System.out.println("enter any string ");
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        System.out.println(compressedString( str));

    }
    
}
