
public class TestFloydWarshall {

  public static void main(String[] args) {

    Graph g = new Graph(4, true);
    g.addEdge(0, 1, 5);
    g.addEdge(1, 2, 3);
    g.addEdge(2, 3, 1);
    g.addEdge(0, 3, 10);
    g.floydWarshall();

    System.out.println("--------------------------------");

    Graph g2 = new Graph(4, true);
    g2.addEdge(0, 2, 3);
    g2.addEdge(1, 0, 2);
    g2.addEdge(2, 1, 7);
    g2.addEdge(2, 3, 1);
    g2.addEdge(3, 0, 6);
    g2.floydWarshall();

    System.out.println("--------------------------------");

    Graph g3 = new Graph(4, true);
    g3.addEdge(0, 2, -2);
    g3.addEdge(1, 0, 4);
    g3.addEdge(1, 2, 3);
    g3.addEdge(2, 3, 2);
    g3.addEdge(3, 1, -1);
    g3.floydWarshall();
  }
}
