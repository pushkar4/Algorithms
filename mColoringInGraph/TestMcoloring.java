
public class TestMcoloring {

  public static void main(String[] args) {
    Graph g = new Graph(4);
    g.addEde(0, 1);
    g.addEde(1, 2);
    g.addEde(2, 3);
    g.addEde(3, 0);
    g.addEde(0, 2);
    g.findColors();
  }
}
