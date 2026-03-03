package Graph;

import java.util.*;

/*
===========================================================
TITLE
===========================================================
Check if Path Exists Between Two Vertices (DFS Based)

===========================================================
PROBLEM STATEMENT
===========================================================
Given an undirected graph represented using an adjacency list,
determine whether there exists a path between a source vertex
and a destination vertex.

Input:
• Graph represented as ArrayList<Edge>[]
• int src → source vertex
• int dest → destination vertex

Output:
• true  → if a path exists between src and dest
• false → otherwise

Constraints:
• 1 ≤ V ≤ 10^5
• Graph may be connected or disconnected
• Graph may contain cycles

Edge Cases:
• src == dest → always true
• No path between src and dest
• Disconnected graph
• Single vertex graph

===========================================================
INTUITION
===========================================================
• To check if a path exists, we explore the graph from source
• If during traversal we reach destination → path exists
• DFS is ideal because:
   - It explores deep paths quickly
   - Recursion simplifies traversal
• visited[] prevents infinite loops in cyclic graphs

===========================================================
APPROACH (DFS RECURSION)
===========================================================
1) If src == dest → return true
2) Mark current node as visited
3) Traverse all neighbors:
   - If neighbor not visited:
       • Recursively check if path exists from neighbor to dest
       • If true → return true immediately
4) If no path found → return false

===========================================================
EXAMPLE
===========================================================
Graph:

        0
      /   \
     1     2
      \   /
        3
       / \
      4   5
           \
            6

Check: hasPath(0, 5)

Traversal:
0 → 1 → 3 → 5
Destination reached → return true

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
• Recursion call stack (worst case V)

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• Works for both directed and undirected graphs
• visited[] is mandatory to avoid infinite recursion
• DFS stops early once destination is found
• For large graphs, iterative DFS can avoid stack overflow
===========================================================
*/

public class G4 {

    /*
     * Edge class representing a weighted edge
     */
    static class Edge {
        int s; // source
        int d; // destination
        int w; // weight

        public Edge(int s, int d, int w) {
            this.s = s;
            this.d = d;
            this.w = w;
        }
    }

    /*
     * Creates the graph using adjacency list representation
     */
    static void createGraph(ArrayList<Edge>[] graph) {

        // Initialize adjacency lists
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adding edges (undirected graph)

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    /*
     * Returns true if a path exists from src to dest
     */
    public static boolean hasPath(ArrayList<Edge>[] graph,
                                  int src,
                                  int dest,
                                  boolean[] vis) {

        // Base case: destination reached
        if (src == dest) return true;

        // Mark current node as visited
        vis[src] = true;

        // Explore all neighbors
        for (int i = 0; i < graph[src].size(); i++) {

            Edge e = graph[src].get(i);

            // If neighbor not visited, recursively check
            if (!vis[e.d] && hasPath(graph, e.d, dest, vis)) {
                return true; // Path found
            }
        }

        // No path found
        return false;
    }

    public static void main(String[] args) {

        int v = 7;

        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph);

        System.out.println(hasPath(graph, 0, 5, new boolean[v]));
    }
}