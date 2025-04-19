package String;
public class string4 {
    public static String toUpperCase(String str){
        StringBuilder sb = new StringBuilder(""); // initializing with empty string
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for(int i=1;i<str.length();i++){ // bcoz 1st character is already checked
            if(str.charAt(i)==' '){
                sb.append(str.charAt(i)); // to append space 
                i++;                // letter after space
                sb.append(Character.toUpperCase(str.charAt(i))); // to append after converting letter to uppercase

            }
            else{
                sb.append(str.charAt(i));
            }

        }
        return sb.toString();

    }
    public static void main(String args[]){
        String str = "hi, my name is sushant";
        System.out.println(toUpperCase(str));
    }
    
}
