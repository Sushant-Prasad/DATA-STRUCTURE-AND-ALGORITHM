package Graph;

import java.util.*;

/*
===========================================================
TITLE
===========================================================
Breadth First Search (BFS) Traversal of Graph

===========================================================
PROBLEM STATEMENT
===========================================================
Given a graph represented using an adjacency list,
perform Breadth First Search (BFS) traversal starting
from source vertex 0.

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
• Print BFS traversal order of vertices

Constraints:
• 1 ≤ V ≤ 10^5
• Graph may be connected or disconnected
• Graph may be weighted (weights unused in BFS)

Edge Cases:
• Single vertex graph
• Disconnected graph
• Vertex with no neighbors

===========================================================
INTUITION
===========================================================
• BFS explores level by level
• Uses a Queue (FIFO structure)
• First visit source node
• Then visit all its neighbors
• Then neighbors of neighbors
• Continue until all reachable nodes are visited

===========================================================
APPROACH
===========================================================
1) Create a boolean visited[] array
2) Create a Queue and insert source vertex (0)
3) While queue is not empty:
   - Remove front node
   - If not visited:
       • Print it
       • Mark as visited
       • Add all its neighbors to queue

===========================================================
EXAMPLE
===========================================================
Graph (simplified structure):

        0
      /   \
     1     2
      \   /
        3
       / \
      4   5
           \
            6

BFS Traversal (starting from 0):
0 1 2 3 4 5 6

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
• Queue storage in worst case

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• BFS guarantees shortest path in unweighted graph
• visited[] prevents infinite loops
• Works only for connected component of source
• For full traversal of disconnected graph,
  BFS must be called for each unvisited node
===========================================================
*/

public class G2 {

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
     * Performs BFS traversal starting from vertex 0
     */
    public static void bfs(ArrayList<Edge> graph[]) {

        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];

        // Start BFS from source vertex 0
        q.add(0);

        while (!q.isEmpty()) {

            int curr = q.remove();

            // Process only if not visited
            if (!visited[curr]) {

                System.out.print(curr + " ");

                visited[curr] = true;

                // Add all neighbors to queue
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.d);
                }
            }
        }
    }

    public static void main(String[] args) {

        int v = 7;

        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph);

        bfs(graph);
    }
}