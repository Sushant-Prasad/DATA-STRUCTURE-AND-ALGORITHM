package Graph;
import java.util.*;

/*
------------------------------------------------------------------
TITLE: Graph Traversal (BFS & DFS) for Disconnected Graph

IMPORTANT CONCEPT: DISCONNECTED COMPONENTS

A graph is called DISCONNECTED if not all vertices are reachable
from a single starting vertex.

Example:
Component 1: 0 - 1 - 2
Component 2: 3 - 4
Component 3: 5

If we start traversal from 0,
vertices 3,4,5 will NEVER be visited.

Therefore:
We must run BFS/DFS from every unvisited vertex.

This ensures that ALL components are covered.

Without the outer loop in bfs() and dfs(),
only one connected component would be traversed.
------------------------------------------------------------------
*/

public class G5 {

    /*
    ------------------------------------------------------------------
    Edge Class

    Represents an edge in adjacency list.
    s → source
    d → destination
    w → weight
    ------------------------------------------------------------------
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
    ------------------------------------------------------------------
    METHOD: createGraph

    Creates an UNDIRECTED graph.

    NOTE:
    Since graph may contain multiple components,
    edges may not connect all vertices together.
    ------------------------------------------------------------------
    */
    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Component 1
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
    ------------------------------------------------------------------
    METHOD: bfs

    PURPOSE:
    Traverse entire graph including ALL disconnected components.

    WHY OUTER LOOP IS NECESSARY?

    Suppose:
    We start BFS from vertex 0.
    BFS will visit only vertices reachable from 0.

    If graph has another component not connected to 0,
    those vertices will remain unvisited.

    Therefore:
    We loop through all vertices.

    If a vertex is still unvisited,
    it means:
    → It belongs to a NEW disconnected component.
    → We must start BFS from there.

    This guarantees complete traversal of graph.

    TIME COMPLEXITY: O(V + E)
    Each vertex is visited once.
    ------------------------------------------------------------------
    */
    public static void bfs(ArrayList<Edge> graph[]) {

        boolean visited[] = new boolean[graph.length];

        // This loop ensures we handle disconnected components
        for (int i = 0; i < graph.length; i++) {

            if (!visited[i]) {
                // New component found
                System.out.println("\nStarting BFS for component from node: " + i);

                bfsUtil(graph, visited, i);
            }
        }
    }

    /*
    ------------------------------------------------------------------
    bfsUtil:
    Performs BFS for ONE connected component.

    Once this finishes,
    control returns to bfs(),
    which checks for any other unvisited vertex.
    ------------------------------------------------------------------
    */
    public static void bfsUtil(ArrayList<Edge> graph[],
                               boolean visited[],
                               int start) {

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {

            int curr = q.remove();

            if (!visited[curr]) {

                System.out.print(curr + " ");
                visited[curr] = true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.d);
                }
            }
        }
    }

    /*
    ------------------------------------------------------------------
    METHOD: dfs

    Same disconnected component logic applies here.

    Outer loop ensures:
    Every vertex is checked.

    If not visited:
    → It belongs to a new component.
    → Start DFS from that vertex.
    ------------------------------------------------------------------
    */
    public static void dfs(ArrayList<Edge>[] graph) {

        boolean vis[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {

            if (!vis[i]) {
                System.out.println("\nStarting DFS for component from node: " + i);

                dfsUtil(graph, i, vis);
            }
        }
    }

    /*
    ------------------------------------------------------------------
    dfsUtil:
    Recursive DFS for a single connected component.

    DFS explores as deep as possible before backtracking.
    ------------------------------------------------------------------
    */
    public static void dfsUtil(ArrayList<Edge>[] graph,
                               int curr,
                               boolean[] vis) {

        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if (!vis[e.d]) {
                dfsUtil(graph, e.d, vis);
            }
        }
    }

    /*
    ------------------------------------------------------------------
    MAIN METHOD

    Demonstrates traversal for disconnected graph.
    ------------------------------------------------------------------
    */
    public static void main(String[] args) {

        int v = 7;

        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph);

        System.out.println("BFS Traversal:");
        bfs(graph);

        System.out.println("\n\nDFS Traversal:");
        dfs(graph);
    }
}