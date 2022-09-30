/*
 * Works for negative weight directed graph.
 * Time = O(v^3)
 * Space = O(v^2)
 */

import java.util.Arrays;

public class Graph {

  private int V;
  private int[][] cost;
  private int[][] path;
  private boolean isDirected;

  public Graph(int vertices, boolean isDirected) {

    V = vertices;
    this.isDirected = isDirected;
    cost = new int[V][V];
    path = new int[V][V];
    for (int[] row : cost) {
      Arrays.fill(row, Integer.MAX_VALUE / 2);
    }
  }

  public void addEdge(int s, int d, int w) {
    cost[s][d] = w;
    cost[s][s] = 0;
    cost[d][d] = 0;
    if (!isDirected)
      cost[d][s] = w;
  }

  private void initPaths() {
    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++) {
        if (i == j)
          path[i][j] = 0;
        else if (cost[i][j] == Integer.MAX_VALUE / 2)
          path[i][j] = -1;
        else
          path[i][j] = i;
      }
    }
  }

  public void floydWarshall() {

    int[][] A = new int[V][V];
    int[][] B = new int[V][V];

    initPaths();

    for (int i = 0; i < cost.length; i++)
      System.arraycopy(cost[i], 0, A[i], 0, cost[i].length);

    for (int k = 0; k < V; k++) {

      for (int i = 0; i < V; i++) {
        for (int j = 0; j < V; j++) {

          if (A[i][j] > A[i][k] + A[k][j]) {
            B[i][j] = A[i][k] + A[k][j];
            path[i][j] = path[k][j];
          } else {
            B[i][j] = A[i][j];
          }
        }
      }

      for (int i = 0; i < cost.length; i++)
        System.arraycopy(B[i], 0, A[i], 0, B[i].length);
    }

    System.out.println("Floyd Warshall Result");
    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++) {
        if (B[i][j] < Integer.MAX_VALUE / 2)
          System.out.print(B[i][j] + "\t");
        else
          System.out.print("-\t");
      }
      System.out.println();
    }

    System.out.println("Shortest path");
    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++) {

        if (i != j && B[i][j] < Integer.MAX_VALUE / 2) {
          System.out.print("from " + i + " to " + j + " is " + i + " ");
          printPath(i, j);
          System.out.println(j);
        }
      }
    }
  }

  private void printPath(int u, int v) {
    if (path[u][v] == u) {
      return;
    }

    printPath(u, path[u][v]);
    System.out.print(path[u][v] + " ");
  }
}
