//Chocola Problem
package GreedyAlgo;
import java.util.*;

public class GreedyAlgo8 {
  public static int minCost(Integer[] vc,Integer[] hc){
    
    Arrays.sort(vc,Collections.reverseOrder()); // descending order
    Arrays.sort(hc,Collections.reverseOrder());
    int cost=0;
    int h=0,v=0,hp=1,vp=1;// hc index,vc index,horizontal piece, vertical piece
    while(v<vc.length && h<hc.length ){
      if(vc[v]<=hc[h]){// horizontal cut
        cost+= vp*hc[h];
        hp++;
        h++;

      }else{ // vertical cut
        cost+= hp*vc[v];
        vp++;
        v++;
      }
    }
      //rest horizontal cut
      while(h<hc.length){
        cost+= vp*hc[h];
        hp++;
        h++;

      }
    
      
      //Rest vertical cut
      while(v<vc.length){
        cost+= hp*vc[v];
        vp++;
        v++;

      }

    
    return cost;
  }
  public static void main(String[] args) {
    Integer vc[]={2,1,3,1,4}; // horizontal cuts
    Integer hc[]={4,1,2};// vertical cuts
    System.out.println(minCost(vc, hc));
    
  }
  
}
