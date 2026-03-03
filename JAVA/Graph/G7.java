package Graph;

import java.util.*;

/*
===========================================================
TITLE
===========================================================
Check if an Undirected Graph is Bipartite (BFS Coloring)

===========================================================
PROBLEM STATEMENT
===========================================================
Given an undirected graph represented using an adjacency list,
determine whether the graph is Bipartite.

A graph is Bipartite if:
• Its vertices can be divided into two sets
• No two adjacent vertices belong to the same set
• Equivalent to: graph can be colored using 2 colors
  such that no adjacent nodes share same color

Input:
• Graph represented as ArrayList<Edge>[]
• V vertices numbered from 0 to V-1

Output:
• true  → if graph is bipartite
• false → otherwise

Constraints:
• 1 ≤ V ≤ 10^5
• Graph may be connected or disconnected
• Graph is undirected

Edge Cases:
• Single vertex graph (always bipartite)
• Disconnected graph
• Graph with odd-length cycle (not bipartite)
• Graph with even-length cycle (bipartite)

===========================================================
PROBLEM RESOURCE
===========================================================
• https://leetcode.com/problems/is-graph-bipartite/

===========================================================
INTUITION
===========================================================
• A graph is bipartite if it has NO odd-length cycle
• We can try coloring nodes using 2 colors (0 and 1)
• If during BFS:
   - We find a neighbor with same color → not bipartite
• BFS ensures level-by-level coloring

===========================================================
APPROACH (BFS + 2-COLORING)
===========================================================
1) Create color[] array and initialize with -1
   (-1 means not colored)
2) For each vertex:
   - If not colored:
       • Start BFS
       • Assign color 0
3) During BFS:
   - For each neighbor:
       • If uncolored → assign opposite color
       • If already colored and same as current → return false
4) If no conflicts found → return true

===========================================================
EXAMPLE
===========================================================
Graph:
0 - 1 - 2 - 3 - 4 - 0

This forms a cycle of length 5 (odd cycle)

Output:
false

===========================================================
DRY RUN
===========================================================
Graph:
0 - 1
1 - 2
2 - 3
3 - 4
4 - 0

Step 1:
color[0] = 0
Queue = [0]

Step 2:
Visit 0 → color neighbors (1,4) with 1
Queue = [1,4]

Step 3:
Visit 1 → color 2 with 0
Queue = [4,2]

Step 4:
Visit 4 → color 3 with 0
Queue = [2,3]

Step 5:
Visit 2 → neighbor 3 already colored 0
But current node 2 also color 0
Conflict detected → return false

===========================================================
KEY POINTS
===========================================================
• Bipartite ⇔ No odd-length cycle
• BFS or DFS both can be used
• Must handle disconnected components
• Color array replaces visited array
• Opposite color logic is crucial

===========================================================
TIME COMPLEXITY
===========================================================
Best Case: O(V)
Average Case: O(V + E)
Worst Case: O(V + E)

Justification:
• Each vertex visited once
• Each edge processed once

===========================================================
SPACE COMPLEXITY
===========================================================
O(V)
• Color array
• Queue storage in worst case

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• Color array initialized with -1
• Opposite color logic:
     nextColor = (currentColor == 0 ? 1 : 0)
• Works for disconnected graphs
• For directed graphs, bipartite logic differs
===========================================================
*/

public class G7 {

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
     * Creates the graph (undirected)
     */
    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 - 1
        graph[0].add(new Edge(0, 1, 1));
        graph[1].add(new Edge(1, 0, 1));

        // 1 - 2
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 1, 1));

        // 2 - 3
        graph[2].add(new Edge(2, 3, 1));
        graph[3].add(new Edge(3, 2, 1));

        // 3 - 4
        graph[3].add(new Edge(3, 4, 1));
        graph[4].add(new Edge(4, 3, 1));

        // 4 - 0
        graph[4].add(new Edge(4, 0, 1));
        graph[0].add(new Edge(0, 4, 1));
    }

    /*
     * Checks if graph is bipartite using BFS
     */
    public static boolean isBipartite(ArrayList<Edge>[] graph) {

        int[] color = new int[graph.length];

        // Initialize all vertices as uncolored
        Arrays.fill(color, -1);

        Queue<Integer> q = new LinkedList<>();

        // Handle disconnected graph
        for (int i = 0; i < graph.length; i++) {

            if (color[i] == -1) {

                q.add(i);
                color[i] = 0;

                while (!q.isEmpty()) {

                    int curr = q.remove();

                    for (int j = 0; j < graph[curr].size(); j++) {

                        Edge e = graph[curr].get(j);

                        // If neighbor not colored
                        if (color[e.d] == -1) {

                            int nextColor = (color[curr] == 0) ? 1 : 0;

                            color[e.d] = nextColor;

                            q.add(e.d);
                        }

                        // If neighbor has same color → not bipartite
                        else if (color[e.d] == color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int v = 5;

        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph);

        System.out.println(isBipartite(graph));  // Expected: false (odd cycle)
    }
}