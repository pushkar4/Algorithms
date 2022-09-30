import java.util.Arrays;

public class Graph {

  int V;
  int[][] cost;

  public Graph(int vertices) {
    V = vertices;
    cost = new int[V][V];
    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++)
        cost[i][j] = Integer.MAX_VALUE / 2;
    }
  }

  public void addEdge(int s, int d, int w) {
    cost[s][d] = w;
  }

  public void findShortestPath() {

    int[] path = new int[V];
    int[] T = new int[V];
    Arrays.fill(T, Integer.MAX_VALUE / 2);

    T[V - 1] = 0;

    for (int i = V - 2; i >= 0; i--) {

      for (int j = i + 1; j < V; j++) {

        if (cost[i][j] + T[j] < T[i]) {
          T[i] = cost[i][j] + T[j];
          path[i] = j;
        }
      }
    }

    System.out.println("Shortest path length is " + T[0]);
    int p = path[0];
    System.out.print("0 ");
    while (p != 0) {
      System.out.print(p + " ");
      p = path[p];
    }
  }
}
