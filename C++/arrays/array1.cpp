//linear search
#include<iostream>
using namespace std;
bool linearSearch(int arr[],int size,int key){
  for(int i=0;i<size;i++){
    if(arr[i]==key){
      cout<<"Found";
      return true;
    }
  }
  cout<<"Not Found";
  return false;
}
int main(){
  int arr[10]={4,6,8,10,12,15,7,3,46,16};
  int size = 10;
  int key = 5;
 linearSearch(arr,size,key);

}