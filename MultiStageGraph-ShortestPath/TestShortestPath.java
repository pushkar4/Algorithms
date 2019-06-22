
public class TestShortestPath {

	public static void main(String[] args) {
		
		Graph g = new Graph(8);
		g.addEdge(0,1,1);
		g.addEdge(0,2,2);
		g.addEdge(0,3,5);
		g.addEdge(1,4,4);
		g.addEdge(1,5,11);
		g.addEdge(2,4,9);
		g.addEdge(2,5,5);
		g.addEdge(2,6,16);
		g.addEdge(3,6,2);
		g.addEdge(4,7,18);
		g.addEdge(5,7,13);
		g.addEdge(6,7,2);
		g.findShortestPath();
	}
}
