
public class TestTsp {

	public static void main(String[] args) {

		Graph g = new Graph(4, false);
		g.addEdge(0,1,20);
		g.addEdge(0,2,42);
		g.addEdge(0,3,25);
		g.addEdge(1,2,30);
		g.addEdge(1,3,34);
		g.addEdge(2,3,10);
		g.findRoute(0);
		
		System.out.println("=================================");
		
		Graph g2 = new Graph(4, true);
		g2.addEdge(0,1,1);
		g2.addEdge(0,2,2);
		g2.addEdge(0,3,3);
		g2.addEdge(1,2,4);
		g2.addEdge(1,3,2);
		g2.addEdge(2,3,5);
		g2.addEdge(1,0,1);
		g2.addEdge(2,0,1);
		g2.addEdge(2,1,2);
		g2.addEdge(3,0,3);
		g2.addEdge(3,1,4);
		g2.addEdge(3,2,1);
		g2.findRoute(0);
		
		System.out.println("=================================");
		
		
	}
}
