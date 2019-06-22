import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {

	int V;
	LinkedList<AdjNode>[] adjList;
	
	public Graph(int v) {
		V = v;
		adjList = new LinkedList[V];
		
		for(int i = 0; i < V; i++) 
			adjList[i] = new LinkedList<AdjNode>();
	}
	
	public void addEdge(int u, int v, int w) {
		AdjNode node = new AdjNode(v, w);
		adjList[u].addFirst(node);
	}

	private int[] topologicalSort() {
		boolean[] visited = new boolean[V];
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int u = 0; u < V; u++) {
			if( ! visited[u] ) {
				doDfs(u, visited, stack);
			}
		}
		
		int k = 0;
		int[] vertex = new int[V];
		
		while( ! stack.isEmpty() )
			vertex[k++] = stack.pop();	
		
		return vertex;
	}
	
	private void doDfs(int u, boolean[] visited, Stack<Integer> stack) {
		
		visited[u] = true;
		
		for (AdjNode node : adjList[u]) {
			int v = node.vertex;
			if( ! visited[v] ) {
				doDfs(v, visited, stack);
			}
		}
		
		stack.push(u);
	}

	public void shortestPath(int source) {
		
		int[] vertex = topologicalSort();
		
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE/2);
		dist[source] = 0;
		
		for(int i = 0; i < V; i++) {
			
			int u = vertex[i];
			
			for (AdjNode node : adjList[u]) {
				int v = node.vertex;
				int w = node.weight;
				relax(u, v, w, dist);
			}
		}
		
		System.out.println("Shortest paths from " + source + " to");
		for(int u = 0; u < V; u++)
			System.out.println(u + " is " + dist[u]);
	}

	private void relax(int u, int v, int w, int[] dist) {
		
		int newDist = dist[u] + w;
		int oldDist = dist[v];
		
		if(newDist < oldDist) {
			dist[v] = dist[u] + w;
		}
	}
}
