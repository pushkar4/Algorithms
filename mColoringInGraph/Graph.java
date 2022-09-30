
public class Graph {

  int V;
  int[][] adj;
  int[] color;

  public Graph(int vertices) {
    V = vertices;
    adj = new int[V][V];
    color = new int[V];
    for (int i = 0; i < V; i++) {
      color[i] = -1;
      for (int j = 0; j < V; j++)
        adj[i][j] = Integer.MAX_VALUE / 2;
    }
  }

  public void addEde(int s, int d) {
    adj[s][d] = adj[d][s] = 1;
  }

  public void findColors() {
    fillColor(0);
    for (int i = 0; i < V; i++) {
      System.out.print(color[i] + " ");
    }
  }

  private boolean fillColor(int u) {
    if (u == V)
      return true;

    for (int c = 1; c <= 10; c++) {  // 10 here hardcoded for number of colors to try with
      if (isSafeToColor(u, c)) {

        color[u] = c;

        if (fillColor(u + 1)) {
          return true;
        }

        color[u] = -1;
      }
    }

    return false;
  }

  private boolean isSafeToColor(int u, int c) {

    for (int i = 0; i < V; i++) {
      if (adj[u][i] == 1 && color[i] == c)
        return false;
    }

    return true;
  }
}
