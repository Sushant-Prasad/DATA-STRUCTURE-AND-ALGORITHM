package String;
public class string2 {
    public static void shortestPath(String str){
        int i, x=0,y=0;
        for(i=0;i<str.length();i++){
            if(str.charAt(i)=='E'){
                x++;
            }
             else if(str.charAt(i)=='W'){
                x--;
            }
             else if(str.charAt(i)=='N'){
                y++;
            }
             else if(str.charAt(i)=='S'){
                y--;
            }
        }
        float disp = (float)Math.sqrt(x*x+y*y);
        System.out.println("Shortest path is "+disp);
    }
    public static void main(String args[]){
        String str = "WNEENESENNN";
        shortestPath(str);
    }
    
}
