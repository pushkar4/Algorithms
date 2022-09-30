
public class Edge {
  int src;
  int dst;
  int wt;

  public Edge() {
    src = dst = wt = 0;
  }

  public Edge(int s, int d, int w) {
    src = s;
    dst = d;
    wt = w;
  }
}
