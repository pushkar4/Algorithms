
public class Graph {
	int V, E;
	Edge[] edge;
	int[] distTo;
	int[] distTo_mod;
	int[] parent;
	
	public Graph(int v) {
		V = v;
		E = 0;
		distTo = new int[V];
		distTo_mod = new int[V];
		parent = new int[V];
		edge = new Edge[100];
	}
	
	public void addEdge(int s, int d, int w) {
		edge[E] = new Edge(s, d, w);
		E++;
	}

	public void bellmanFord(int source) {
		
		boolean solvable = true;
		
		for(int i = 0; i < V; i++) {
			distTo[i] = Integer.MAX_VALUE/2;
			parent[i] = -1;
		}
		
		distTo[source] = 0;
		int u, v, w;
		
		for(int i = 0; i < V-1; i++) {
			System.arraycopy(distTo, 0, distTo_mod, 0, V);
			for (int j = 0; j < E; j++) {
				Edge e = edge[j];
				u = e.src;
				v = e.dst;
				w = e.wt;
				relax(u, v, w, true);
			}
			System.arraycopy(distTo_mod, 0, distTo, 0, V);
		}
		
		for (int j = 0; j < E; j++) {
			Edge e = edge[j];
			u = e.src;
			v = e.dst;
			w = e.wt;
			
			boolean changed = relax(u, v, w, false);
			if(changed) {
				solvable = false;
				break;
			}
		}
		
		if( ! solvable )
			System.out.println("WARNING: Graph contains negative weight cycle.");
			
		System.out.println("Shortest path distance from ");
		for(int i = 0; i < V; i++) {
			if(i == source)
				continue;
			System.out.println(source + " to " + i + " is " + distTo[i]);
		}
		
		System.out.print("\nShortest paths are\n");
		for(int i = 0; i < V; i++) {
			if(i == source)
				continue;
			printPath(i, source);
			System.out.println();
		}				
	}

	private boolean relax(int u, int v, int w, boolean update) {
		
		int oldDist = distTo[v];
		int newDist = distTo[u] + w;
		boolean changed = false;
		
		if(newDist < oldDist) {
			changed = true;
			if(update) {
				distTo_mod[v] = distTo[u] + w;
				parent[v] = u;
			}
		}
		
		return changed;
	}

	private boolean printPath(int i, int source) {
		
		if(i == -1)
			return false;
		
		if(i == source) {
			System.out.print(i + " ");
			return true;
		} else {
			boolean res = printPath(parent[i], source);
			if(res) {
				System.out.print(i + " ");
				return true;
			} else {
				return false;
			}				
		}
	}
}
