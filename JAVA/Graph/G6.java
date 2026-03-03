package Graph;

import java.util.ArrayList;

/*
===========================================================
TITLE
===========================================================
Cycle Detection in Undirected Graph (DFS + Parent Tracking)

===========================================================
PROBLEM STATEMENT
===========================================================
Given an undirected graph represented using an adjacency list,
determine whether the graph contains a cycle.

The graph is represented as:
• Array of ArrayList<Edge>
• Each Edge contains:
  - source (s)
  - destination (d)
  - weight (w)

Input:
• Number of vertices V
• Undirected edges added in createGraph()

Output:
• true  → if cycle exists
• false → otherwise

Constraints:
• 1 ≤ V ≤ 10^5
• Graph may be connected or disconnected
• Graph is undirected

Edge Cases:
• Single vertex graph
• Graph with no edges
• Disconnected graph
• Multiple cycles

===========================================================
INTUITION
===========================================================
• In an undirected graph, every edge appears twice
• During DFS, if we reach a visited node that is NOT
  the parent of the current node → cycle exists
• Parent tracking avoids false detection due to
  bidirectional edges

===========================================================
APPROACH (DFS WITH PARENT)
===========================================================
1) Create visited[] array
2) For each unvisited vertex:
   - Call DFS utility
3) In DFS:
   - Mark current node visited
   - For each neighbor:
       • If not visited → recursively DFS
       • If visited AND neighbor != parent → cycle found
4) If any DFS call returns true → cycle exists

===========================================================
EXAMPLE
===========================================================
Graph:

      0
     / \
    1---2
     \
      3
       \
        4

Cycle exists between 0-1-2

Output:
true

===========================================================
TIME COMPLEXITY
===========================================================
O(V + E)
• Each vertex visited once
• Each edge explored once

===========================================================
SPACE COMPLEXITY
===========================================================
O(V)
• visited array
• Recursion stack in worst case

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• Parent parameter is mandatory in undirected graph
• Without parent check, every bidirectional edge
  would falsely appear as a cycle
• For directed graphs, cycle detection logic differs
===========================================================
*/

public class G6 {

    /*
     * Edge class representing a weighted edge
     */
    static class Edge {
        int s;
        int d;
        int w;

        public Edge(int s, int d, int w) {
            this.s = s;
            this.d = d;
            this.w = w;
        }
    }

    /*
     * Creates an undirected graph
     */
    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 - 1
        graph[0].add(new Edge(0, 1, 1));
        graph[1].add(new Edge(1, 0, 1));

        // 0 - 2
        graph[0].add(new Edge(0, 2, 1));
        graph[2].add(new Edge(2, 0, 1));

        // 1 - 2  (Cycle edge)
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 1, 1));

        // 0 - 3
        graph[0].add(new Edge(0, 3, 1));
        graph[3].add(new Edge(3, 0, 1));

        // 2 - 4
        graph[2].add(new Edge(2, 4, 1));
        graph[4].add(new Edge(4, 2, 1));
    }

    /*
     * Detects cycle in the graph
     */
    public static boolean detectCycle(ArrayList<Edge>[] graph) {

        boolean[] vis = new boolean[graph.length];

        // Check all components
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * DFS utility for cycle detection
     */
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph,
                                          boolean[] vis,
                                          int curr,
                                          int parent) {

        // Mark current node visited
        vis[curr] = true;

        // Traverse neighbors
        for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);

            // If neighbor not visited → DFS
            if (!vis[e.d]) {
                if (detectCycleUtil(graph, vis, e.d, curr)) {
                    return true;
                }
            }

            // If visited and not parent → cycle detected
            else if (e.d != parent) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int v = 5;

        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph);

        System.out.println(detectCycle(graph));  // Expected: true
    }
}