
public class TestBellmanFord {

	public static void main(String[] args) {

		Graph g = new Graph(6);
		g.addEdge(0, 1, 4);
		g.addEdge(0, 2, 3);
		g.addEdge(1, 2, 1);
		g.addEdge(1, 3, 2);
		g.addEdge(2, 3, 4);
		g.addEdge(3, 4, 2);
		g.addEdge(4, 5, 6);
		g.bellmanFord(0);
		
		System.out.println("---------------------------------");
		
		Graph g2 = new Graph(9);
		g2.addEdge(0, 1, 4);
		g2.addEdge(0, 7, 8);
		g2.addEdge(1, 2, 8);
		g2.addEdge(1, 7, 11);
		g2.addEdge(2, 3, 7);
		g2.addEdge(2, 8, 2);
		g2.addEdge(2, 5, 4);
		g2.addEdge(3, 4, 9);
		g2.addEdge(3, 5, 14);
		g2.addEdge(4, 5, 10);
		g2.addEdge(5, 6, 2);
		g2.addEdge(6, 7, 1);
		g2.addEdge(6, 8, 6);
		g2.addEdge(7, 8, 7);
		g2.bellmanFord(0);
		
		System.out.println("---------------------------------");
		
		Graph g3 = new Graph(11);
		g3.addEdge(0, 2, 1);
		g3.addEdge(0, 1, 3);
		g3.addEdge(1, 4, 5);
		g3.addEdge(1, 3, 3);
		g3.addEdge(2, 4, 8);
		g3.addEdge(2, 5, 5);
		g3.addEdge(3, 4, 1);
		g3.addEdge(3, 6, 10);
		g3.addEdge(4, 5, 2);
		g3.addEdge(4, 7, 8);
		g3.addEdge(4, 6, 2);
		g3.addEdge(5, 7, 15);
		g3.addEdge(6, 7, 5);
		g3.addEdge(8, 10, 2);
		g3.bellmanFord(0);
	}
}
