/*
===========================================================
TITLE
===========================================================
Job Sequencing Problem (Greedy Algorithm)

===========================================================
PROBLEM STATEMENT
===========================================================
You are given a set of jobs, where each job has:
• a deadline
• a profit

Each job takes **exactly 1 unit of time** to complete.
Only **one job can be scheduled at a time**.

The objective is to:
• Schedule jobs in such a way that
• The **total profit is maximized**
• Each job is completed **before or on its deadline**

===========================================================
INPUT FORMAT
===========================================================
• A 2D integer array `jobInfo`
  where:
  - jobInfo[i][0] = deadline of ith job
  - jobInfo[i][1] = profit of ith job

===========================================================
OUTPUT FORMAT
===========================================================
• Return an ArrayList of job IDs representing
  the sequence of jobs selected to maximize profit

===========================================================
INTUITION
===========================================================
To maximize profit:
• Always prefer jobs with **higher profit**
• Schedule them as early as possible within their deadline

This naturally suggests a **Greedy Strategy**:
1) Sort jobs in **descending order of profit**
2) Try to schedule each job if time allows before its deadline

===========================================================
APPROACH
===========================================================
1) Create a Job class to store:
   - deadline
   - profit
   - job id
2) Convert input array into a list of Job objects
3) Sort the jobs in descending order of profit
4) Initialize a `time` counter (represents current slot)
5) For each job:
   - If job.deadline > time, schedule it
   - Increment time
6) Store scheduled job IDs in a result list
7) Return the result list

===========================================================
EXAMPLE
===========================================================
Input:
jobInfo = { {4,20}, {1,10}, {1,40}, {1,30} }

After sorting by profit:
Job 2 → profit 40, deadline 1
Job 3 → profit 30, deadline 1
Job 0 → profit 20, deadline 4
Job 1 → profit 10, deadline 1

Selected Jobs:
Job 2 (time = 0)
Job 0 (time = 1)

Output:
[2, 0]

===========================================================
DRY RUN
===========================================================
Sorted Jobs by profit:
(40, d=1), (30, d=1), (20, d=4), (10, d=1)

time = 0
• Job(40): deadline 1 > time → select → time = 1
• Job(30): deadline 1 > time ❌ skip
• Job(20): deadline 4 > time → select → time = 2
• Job(10): deadline 1 > time ❌ skip

===========================================================
KEY POINTS
===========================================================
• Greedy works because higher profit jobs should be prioritized
• Sorting by profit is essential
• Each job takes exactly 1 unit of time
• This version returns job IDs, not total profit

===========================================================
TIME COMPLEXITY
===========================================================
O(n log n)
- Sorting jobs by profit takes O(n log n)

===========================================================
SPACE COMPLEXITY
===========================================================
O(n)
- Extra space for Job objects and result list

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• `time` represents the current time slot
• Job is selected only if it fits before its deadline
• This is a simplified greedy version (not slot-based array)
===========================================================
*/

package GreedyAlgo;

import java.util.*;

public class GreedyAlgo7 {

    // Creating Job class to store job details
    static class Job {
        int deadline;
        int profit;
        int id;

        // Job constructor
        Job(int dl, int p, int i) {
            deadline = dl;
            profit = p;
            id = i;
        }
    }

    // Function to perform job sequencing
    public static ArrayList<Integer> jobSequence(int[][] jobInfo) {

        ArrayList<Job> jobs = new ArrayList<>();
        int n = jobInfo.length;

        // Convert jobInfo array into Job objects
        for (int i = 0; i < n; i++) {
            jobs.add(new Job(jobInfo[i][0], jobInfo[i][1], i));
        }

        // Sort jobs by profit in descending order
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0; // keeps track of scheduled jobs

        // Select jobs greedily
        for (int i = 0; i < n; i++) {
            if (jobs.get(i).deadline > time) {
                seq.add(jobs.get(i).id); // add job id
                time++;                 // move to next time slot
            }
        }

        return seq;
    }

    public static void main(String[] args) {

        int jobInfo[][] = { {4,20}, {1,10}, {1,40}, {1,30} };

        // Print selected job sequence
        System.out.println(jobSequence(jobInfo));
    }
}
