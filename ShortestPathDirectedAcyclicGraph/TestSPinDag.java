
public class TestSPinDag {

	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.addEdge(0, 1, 5); 
        g.addEdge(0, 2, 3); 
        g.addEdge(1, 3, 6); 
        g.addEdge(1, 2, 2); 
        g.addEdge(2, 4, 4); 
        g.addEdge(2, 5, 2); 
        g.addEdge(2, 3, 7); 
        g.addEdge(3, 4, -1); 
        g.addEdge(4, 5, -2); 
        g.shortestPath(1);
        
        System.out.println("\n");
        
        Graph g2 = new Graph(5);
        g2.addEdge(0,1,9);
        g2.addEdge(0,2,6);
        g2.addEdge(0,3,5);
        g2.addEdge(0,4,3);
        g2.addEdge(2,1,2);
        g2.addEdge(2,3,4);
        g2.shortestPath(0);
        
        System.out.println("\n");
                
        Graph g3 = new Graph(5);
        g3.addEdge(0,1,2);
        g3.addEdge(0,2,3);
        g3.addEdge(1,2,5);
        g3.addEdge(1,3,-3);
        g3.addEdge(3,4,4);
        g3.addEdge(2,4,1);
		g3.shortestPath(0);
		
		System.out.println("\n");
        
//		Graph g4 = new Graph(7);
//		g4.addEdge(0, 2);
//		g4.shortestPath(0);
	}
}
