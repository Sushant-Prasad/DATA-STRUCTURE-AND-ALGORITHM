package Arrays;
// passing aray as a argument in function
public class array2 {
    public static void update(int marks[], int nonChangable){
        for(int i=0;i<marks.length;i++){
            marks[i]=marks[i]+5;
        }
        nonChangable=20;
    }
    public static void main(String args[]){
        int nonChangable = 10;
        int marks[]={55,65,75,85,95};
        update(marks,nonChangable);
        System.out.println("updated marks are :");
         for(int i=0;i<marks.length;i++){
            System.out.println(marks[i]);
         }
            System.out.println("nonchangable is :"+nonChangable);
         


    }
    
}
