
public class Graph {
	
	private int V;
	private int[][] cost;
	private boolean isDirected;
	private int[] parent;
	
	private static int ALL_VISITED;
	
	public Graph(int vertices, boolean isDirected) {
		
		V = vertices;
		cost = new int[V][V];
		parent = new int[V];
		this.isDirected = isDirected;
		
		for(int i = 0; i < V; i++) {
			parent[i] = -1;
			for(int j = 0; j < V; j++)
				cost[i][j] = Integer.MAX_VALUE/2;
		}
		
		ALL_VISITED = (1 << V) - 1;
	}

	public void addEdge(int s, int d, int w) {
		cost[s][d] = w;
		if( ! isDirected )
			cost[d][s] = w;
	}
	
	public void findRoute(int source) {
		
		int vmask = (1 << source);
		
		int finalCost = tsp(source, vmask, source);
		System.out.println("Cost of route is " + finalCost);
	}
	
	private int tsp(int source, int mask, int u) {
		
		if(mask == ALL_VISITED)
			return cost[u][source];
		
		int c = Integer.MAX_VALUE;
		
		for(int v = 0; v < V; v++) {
			
			if((mask & (1 << v)) == 0) {
				
				int cNew = cost[u][v] + tsp(source, mask | (1 << v), v);
				if(cNew < c) {
					c = cNew;
					parent[v] = u;
				}
			}
		}
		
		return c;
	}
}
