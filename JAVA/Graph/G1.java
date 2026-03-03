package Graph;

import java.util.*;

/*
===========================================================
TITLE
===========================================================
Graph Representation Using Adjacency List (Weighted Graph)

===========================================================
PROBLEM STATEMENT
===========================================================
Create a graph with `v` vertices using an adjacency list representation.

Each edge contains:
• Source vertex (s)
• Destination vertex (d)
• Weight of the edge (w)

Then print all neighbors of a specific vertex (vertex 2 in this example).

Input:
• Number of vertices v
• Manually added edges

Output:
• Print destination vertices connected to vertex 2

Constraints:
• 0 ≤ vertices ≤ 10^5
• Graph can be directed or undirected
• Weighted edges

Edge Cases:
• Vertex with no neighbors
• Single vertex graph
• Disconnected graph

===========================================================
INTUITION
===========================================================
• Adjacency List is efficient for sparse graphs
• Each index represents a vertex
• Each list at index `i` stores edges originating from vertex `i`
• Accessing neighbors of a vertex becomes easy

===========================================================
APPROACH
===========================================================
1) Create an array of ArrayList<Edge> of size v
2) Initialize each index with a new ArrayList
3) Add edges manually
4) To print neighbors of vertex X:
   - Traverse graph[X]
   - Print destination vertex of each edge

===========================================================
EXAMPLE
===========================================================
Vertices = 5

Edges:
0 → 1 (5)
1 → 2 (1)
2 → 4 (2)
...

Neighbors of vertex 2:
1
4
3

===========================================================
TIME COMPLEXITY
===========================================================
Graph Creation:
• O(V + E)

Printing neighbors of vertex 2:
• O(degree of vertex 2)

===========================================================
SPACE COMPLEXITY
===========================================================
O(V + E)
• Adjacency list stores all vertices and edges

===========================================================
SPECIAL NOTES FOR LOGIC
===========================================================
• Array of ArrayList must be initialized before use
• graph[i] is null until explicitly assigned
• For undirected graph, add edges in both directions
===========================================================
*/

public class G1 {

    /*
     * Edge class representing a weighted edge
     */
    static class Edge {
        int s; // source vertex
        int d; // destination vertex
        int w; // weight of edge

        public Edge(int s, int d, int w) {
            this.s = s;
            this.d = d;
            this.w = w;
        }
    }

    public static void main(String[] args) {

        int v = 5; // number of vertices

        // Create adjacency list (initially null)
        ArrayList<Edge>[] graph = new ArrayList[v];

        // Initialize each vertex with an empty list
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        // Adding edges (undirected graph example)

        // Vertex 0
        graph[0].add(new Edge(0, 1, 5));

        // Vertex 1
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // Vertex 2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 4, 2));
        graph[2].add(new Edge(2, 3, 1));

        // Vertex 3
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // Vertex 4
        graph[4].add(new Edge(4, 2, 2));

        // Print neighbors of vertex 2
        System.out.println("Neighbors of vertex 2:");
        for (int i = 0; i < graph[2].size(); i++) {
            System.out.println(graph[2].get(i).d);
        }
    }
}