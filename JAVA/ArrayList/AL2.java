package ArrayList;
//Container With Most Water
public class AL2 {
  //---------------BRUTE FORCE------------------------
  //TC:-O(n*n)
  // public static int maxArea(int[] height){
  //   int n=height.length;
  //   int ans=0;
  //   for(int i=0;i<n;i++){
  //     for(int j=i;j<n;j++){
  //       int area = (j-i)*Math.min(height[i],height[j]);
  //       if(ans<area){
  //         ans=area;
  //       }

  //     }

  //   }
  //   return ans;
  // }
  //--------------------OPTIMIZED CODE-------------------------
  //TC:-O(n)
    public static int maxArea(int[] height) {
        int left=0; // for left lines
        int right=height.length-1;// for right lines
        int maxArea=0;
        while(left<right){
            int currArea = Math.min(height[left],height[right])*(right-left);
            maxArea=Math.max(maxArea,currArea);
            if(height[left]<height[right]){
               
                 left++;
            }else{
                 right--;
            }

        }
        return maxArea;
        
    }
  public static void main(String[] args) {
    int[] arr ={1,12,6,2,3,4,8,3,10};
    System.out.println(maxArea(arr));
    
  }
  
}
