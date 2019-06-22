
public class TestKruskals {

	public static void main(String[] args) {
		
		Graph g = new Graph(8);
		g.addEdge(1,3,7);
		g.addEdge(1,2,1);
		g.addEdge(3,4,2);
		g.addEdge(2,4,5);
		g.addEdge(2,5,6);
		g.addEdge(5,7,9);
		g.addEdge(5,6,3);
		g.addEdge(7,8,4);
		g.addEdge(6,8,8);
		g.kruskals();
		
		System.out.println();
		
		Graph g2 = new Graph(7);
		g2.addEdge(1,2,28);
		g2.addEdge(1,6,10);
		g2.addEdge(2,7,14);
		g2.addEdge(6,5,25);
		g2.addEdge(7,5,24);
		g2.addEdge(2,3,16);
		g2.addEdge(7,4,18);
		g2.addEdge(5,4,22);
		g2.addEdge(3,4,12);
		g2.kruskals();
		
		System.out.println();
		
		Graph g3 = new Graph(7);
		g3.addEdge(1,2,10);
		g3.addEdge(2,3,15);
		g3.addEdge(3,4,4);
		g3.addEdge(4,1,6);
		g3.addEdge(1,3,5);
		g3.kruskals();		
	}
}
