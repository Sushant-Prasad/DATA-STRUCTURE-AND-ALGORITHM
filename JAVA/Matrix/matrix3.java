package Matrix;
public class matrix3 {
    public static void staircaseSearch(int a[][], int key){
        int row=0,col=a[0].length-1;
        while(row <= (a.length-1) && col>=0){
            if(key==a[row][col]){
                System.out.println("found key at "+"("+row+","+col+")");
                break;
            }
            if(key>a[row][col]){
                row++;
            }
            else if(key<a[row][col]){
                col--;
             }

        }
    }
    public static void main(String args[]){
        int a[][]={{10,20,30,40},
                    {15,25,35,45},
                    {27,29,37,48},
                    {32,33,39,50}};
int key = 33;
staircaseSearch(a,key);
    
}
}
