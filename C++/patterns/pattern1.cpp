//solid pattern
#include<iostream>
using namespace std;
int main(){
  for(int i=0;i<4;i++){// outer loop ; i->row
    for(int j=0;j<4;j++){ // inner loop ; j->col
      cout<<"* ";
    }
    cout<<endl;// for next line
  }
}