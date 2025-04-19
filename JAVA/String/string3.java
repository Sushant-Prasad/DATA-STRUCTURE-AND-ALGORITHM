package String;
public class string3 {
    public static void largestString(String fruits[]){
        String largest = fruits[0];
        for(int i=0;i<fruits.length;i++){
          if(largest.compareToIgnoreCase(fruits[i])<0){
            largest = fruits[i];
          }
        }
        System.out.println("largest string is "+largest);
    }
    public static void main(String args[]){

        String fruits[] ={"mango","banana","apple"};
        largestString(fruits);
   
    }
}
    
