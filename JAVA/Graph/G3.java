package Graph;

import java.util.*;

/*
===========================================================
TITLE
===========================================================
Depth First Search (DFS) Traversal of Graph (Recursive)

===========================================================
PROBLEM STATEMENT
===========================================================
Given a graph represented using an adjacency list,
perform Depth First Search (DFS) traversal starting
from a source vertex (0 in this example).

The graph is represented as:
• Array of ArrayList<Edge>
• Each Edge contains:
  - source (s)
  - destination (d)
  - weight (w)

Input:
• Number of vertices v
• Predefined edges inside createGraph()

Output:
• Print DFS traversal order of vertices

Constraints:
• 1 ≤ V ≤ 10^5
• Graph may be connected or disconnected
• Graph may be weighted (weights unused in DFS)

Edge Cases:
• Single vertex graph
• Disconnected graph
• Vertex with no neighbors

===========================================================
INTUITION
===========================================================
• DFS explores as deep as possible before backtracking
• Recursion naturally follows graph depth
• We mark nodes visited to prevent infinite cycles
• For each node:
   - Visit node
   - Recursively visit all unvisited neighbors

===========================================================
APPROACH
===========================================================
1) Create a boolean visited[] array
2) Call dfs(graph, source, visited)
3) In DFS:
   - Print current node
   - Mark it visited
   - For each neighbor:
       • If not visited, recursively call DFS

===========================================================
EXAMPLE
===========================================================
Graph structure (simplified):

        0
      /   \
     1     2
      \   /
        3
       / \
      4   5
           \
            6

DFS Traversal (starting from 0):
0 1 3 4 2 5 6
(Note: Order may vary depending on adjacency list order)

===========================================================
TIME COMPLEXITY
===========================================================
O(V + E)
• Each vertex visited once
• Each edge processed once

===========================================================
SPACE COMPLEXITY
===========================================================
O(V)
• visited array
• Recursion call stack (worst case V in skewed graph)

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• DFS may cause stack overflow for very deep graphs
• visited[] is mandatory to prevent infinite recursion
• For disconnected graph, DFS must be called for each unvisited vertex
• Order depends on adjacency list insertion order
===========================================================
*/

public class G3 {

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
    static void createGraph(ArrayList<Edge> graph[]) {

        // Initialize each list
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
     * Performs DFS traversal starting from given vertex
     */
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis) {

        // Visit current node
        System.out.print(curr + " ");
        vis[curr] = true;

        // Traverse all neighbors
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // If neighbor not visited, recurse
            if (!vis[e.d]) {
                dfs(graph, e.d, vis);
            }
        }
    }

    public static void main(String[] args) {

        int v = 7;

        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph);

        // Start DFS from vertex 0
        dfs(graph, 0, new boolean[v]);
    }
}