
public class TestTopSort {

  public static void main(String[] args) {

    Graph g = new Graph(6);
    g.addEdge(5, 2);
    g.addEdge(5, 0);
    g.addEdge(4, 0);
    g.addEdge(4, 1);
    g.addEdge(2, 3);
    g.addEdge(3, 1);
    g.topologicalSort();

    System.out.println("\n");

    Graph g2 = new Graph(8);
    g2.addEdge(4, 1);
    g2.addEdge(4, 2);
    g2.addEdge(1, 3);
    g2.addEdge(2, 1);
    g2.addEdge(2, 3);
    g2.addEdge(2, 6);
    g2.addEdge(2, 5);
    g2.addEdge(3, 6);
    g2.addEdge(6, 7);
    g2.addEdge(5, 7);
    g2.topologicalSort();

    System.out.println("\n");

    Graph g3 = new Graph(8);
    g3.addEdge(7, 6);
    g3.addEdge(7, 5);
    g3.addEdge(6, 4);
    g3.addEdge(6, 3);
    g3.addEdge(5, 4);
    g3.addEdge(5, 2);
    g3.addEdge(3, 1);
    g3.addEdge(2, 1);
    g3.addEdge(1, 0);
    g3.topologicalSort();

    System.out.println("\n");

    Graph g4 = new Graph(7);
    g4.addEdge(0, 2);
    g4.addEdge(0, 5);
    g4.addEdge(0, 1);
    g4.addEdge(3, 2);
    g4.addEdge(3, 5);
    g4.addEdge(3, 6);
    g4.addEdge(6, 4);
    g4.addEdge(6, 0);
    g4.addEdge(1, 4);
    g4.topologicalSort();

    Graph g5 = new Graph(2);
    g5.addEdge(1, 0);
    g5.addEdge(0, 1);
    g5.topologicalSort();
  }
}
