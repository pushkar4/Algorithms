
public class Graph {
	
	int V;
	int[][] adj;
	
	public Graph(int vertices) {
		V = vertices;
		adj = new int[V][V];
		
		for(int i = 0; i < V; i++) {
			for(int j = 0; j < V; j++)
				adj[i][j] = Integer.MAX_VALUE/2;
		}
	}
	
	public void addEde(int s, int d) {
		adj[s][d] = adj[d][s] = 1;
	}
	
	public void findHamiltonianCycle(int source) {
		
		int[] path = new int[V];
		for(int i = 0; i < V; i++) {
			path[i] = -1;
		}
		
		path[0] = source;
		
		findCycle(1, path, source);
	}

	private boolean findCycle(int pos, int[] path, int source) {

		if(pos == V) {
			// We have processed all vertices. Check if there is a back edge to source.
			if(adj[path[pos-1]][source] == 1) {
				printPath(path);
				return false;
			}
			else
				return false;
		}
		
		for(int u = 0; u < V; u++) {
			
			if(isSafe(u, pos, path)) {
				
				path[pos] = u;
				
				if(findCycle(pos + 1, path, source) == true)
					return true;
				
				path[pos] = -1;
			}
		}
		
		return false;
	}

	private boolean isSafe(int u, int pos, int[] path) {
		
		if(adj[path[pos-1]][u] != 1)
			return false;
		
		for(int i = 0; i < pos; i++) {
			if(path[i] == u)
				return false;
		}
		
		return true;
	}

	private void printPath(int[] path) {
		for(int i = 0; i < V; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}
}
