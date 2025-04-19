//count 0's and 1's
#include<iostream>
using namespace std;
void count(int arr[],int size){
  int countZero=0;
  int countOne=0;
  for(int i=0;i<size;i++){
    if(arr[i]==0){
      countZero++;
    }
    if(arr[i]==1){
      countOne++;
    } 
  }
   cout << "1's : " <<countOne << " and 0's : " <<countZero;

}
int main(){
  int arr[9] = {0,0,1,0,1,1,1,0,0};
  int size = 9 ;
  count(arr,size);

}