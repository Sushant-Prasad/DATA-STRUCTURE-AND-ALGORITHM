//hollow rectangle
#include<iostream>
using namespace std;
int main(){
  for(int row=0;row<3;row++){
    if(row==0 || row==2){ // for first and last row
      for(int col=0;col<5;col++){
        cout<< "* ";
      }
    }else{//for remaining row
      cout<< "* ";// * for first col
      for(int col=1;col<4;col++){
        cout<< "  ";
      }
      cout<< "* ";// * for last col

    }
    cout<<endl;
  }
}
