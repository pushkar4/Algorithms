
public class TestHamiltonian {

  public static void main(String[] args) {
    Graph g = new Graph(4);
    g.addEde(0, 1);
    g.addEde(1, 2);
    g.addEde(2, 3);
    g.addEde(3, 0);
    g.addEde(0, 2);
    g.findHamiltonianCycle(0);

    System.out.println("=========================");

    Graph g2 = new Graph(4);
    g2.addEde(0, 1);
    g2.addEde(0, 2);
    g2.addEde(0, 3);
    g2.addEde(1, 2);
    g2.addEde(1, 3);
    g2.addEde(2, 3);
    g2.findHamiltonianCycle(0);

    System.out.println("=========================");

  }
}
