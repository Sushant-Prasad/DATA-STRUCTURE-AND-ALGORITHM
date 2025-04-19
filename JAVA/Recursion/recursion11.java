package Recursion;
//Remove duplicates from string
public class recursion11 {
    public static void removeDuplicate(String str,int index,boolean map[],StringBuilder newString){
        if(index == str.length()){ //its base case means all character has been checked.
            System.out.println(newString);
            return;
        }
        //checking whether the character is present or not in map array
        char currChar = str.charAt(index);
        int mapIndex = currChar - 'a'; // finding index of map for the particular character
        if(map[mapIndex] == true){ // if character is already present in map array
            index++;
            removeDuplicate(str,index,map,newString); 
        }
         // if charcter is not present
        else{                 
            map[mapIndex]=true; // assigning true in map aaray
            newString.append(currChar); // appending the new character
            index++;
            removeDuplicate(str,index,map,newString);

        }

    }
    public static void main(String args[]){
        String str = "appnnacollege";
        int index = 0;
        boolean map[] = new boolean[26]; // bcoz alphabet has 26 letters
        StringBuilder newString = new StringBuilder("");
        removeDuplicate(str,index,map,newString);



    }
    
}
