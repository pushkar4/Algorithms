import java.util.LinkedList;
import java.util.Stack;

public class Graph {

	int V;
	LinkedList<Integer>[] adjList;
	
	public Graph(int v) {
		V = v;
		adjList = new LinkedList[V];
		
		for(int  i = 0; i < V; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int u, int v) {
		adjList[u].addFirst(v);
	}

	public void topologicalSort() {
		
		boolean[] visited = new boolean[V];
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int u = 0; u < V; u++) {
			if( ! visited[u] ) {
				doDfs(u, visited, stack);
			}
		}
		
		System.out.println("Topological order is:");
		while( ! stack.isEmpty() ) {
			System.out.print(stack.pop() + " ");
		}
	}

	private void doDfs(int u, boolean[] visited, Stack<Integer> stack) {
		
		visited[u] = true;
		
		for (Integer v : adjList[u]) {
			if( ! visited[v] ) {
				doDfs(v, visited, stack);
			}
		}
		
		stack.push(u);
	}
}
