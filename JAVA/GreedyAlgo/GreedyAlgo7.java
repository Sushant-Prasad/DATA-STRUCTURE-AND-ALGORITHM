//Jab sequence problem;
//TC:- O(nlogn)
package GreedyAlgo;

import java.util.*;

public class GreedyAlgo7 {
  //crating Job class
  static class Job {
    int deadline;
    int profit;
    int id;
    //Job cunstructor
    Job(int dl, int p, int i) {
      deadline = dl;
      profit=p;
      id = i;

    }
  }
  public static ArrayList<Integer> jobSequence(int[][] jobInfo) {
    ArrayList<Job> jobs = new ArrayList<>(); // creating arraylist of Job class
    int n= jobInfo.length;
    for(int i=0;i<n;i++){
      jobs.add(new Job(jobInfo[i][0], jobInfo[i][1], i ));

    }
    // sorting
    //Collections.sort(jobs, (Obj1,Obj2)->Obj1.profit-Obj2.profit);// ascending order
    Collections.sort(jobs, (Obj1,Obj2)->Obj2.profit-Obj1.profit);// descending order

    ArrayList<Integer> seq = new ArrayList<>();
    int time=0;
    for(int i=0;i<n;i++){
      if(jobs.get(i).deadline>time){
        seq.add(jobs.get(i).id);
        time++;
      }
    }
    return seq;


  }

  public static void main(String[] args) {
    int jobInfo[][]={{4,20},{1,10},{1,40},{1,30}};
    System.out.println(jobSequence(jobInfo));

  

  }

}
