//extreme print in array 
#include <iostream>
using namespace std;
int* extremePrint(int arr[],int size){
  int start = 0;
  int end=size-1;
  int i =0;
  int* result = new int[size];
  while(start <= end){

      result[i++] = arr[start];
      result[i++] = arr[end];
      start++;
      end--;

    
  }
  return result;
}
int main(){
  int arr[8]={1,2,3,4,5,6,7,8};
  //output:- 1,8,2,7,3,6,4,5
  int size = 8;
  int* result =extremePrint(arr,size);
  for(int i=0; i < size;i++){
    cout<<result[i]<<" ";
  }
 delete[] result;//free the memory
}