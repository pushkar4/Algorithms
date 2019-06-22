import java.util.LinkedList;

public class Graph {

	int V, k, heapSize;
	Edge[] A = new Edge[100];
	int[] parent;
	int[] size;
	
	public Graph(int v) {
		V = v;
		k = 1;
		heapSize = 0;
	}
	
	public void addEdge(int s, int d, int w) {
		A[k] = new Edge(s, d, w);
		k++;
	}
	
	private void buildEdgeMinHeap() {
		
		heapSize = k-1;
		
		for(int i = heapSize/2; i >= 1; i--) {
			minHeapify(i);
		}
	}

	private void minHeapify(int i) {
		
		int l = 2*i;
		int r = 2*i + 1;
		
		int minPos = i;
		
		if(l <= heapSize && A[l].wt < A[i].wt) 
			minPos = l;
		
		if(r <= heapSize && A[r].wt < A[minPos].wt)
			minPos = r;
		
		if(minPos != i) {
			Edge t = A[i];
			A[i] = A[minPos];
			A[minPos] = t;
			
			minHeapify(minPos);
		}
	}
	
	private Edge popMinEdge() {

		Edge e = A[1];
		A[1] = A[heapSize];
		heapSize--;
		minHeapify(1);
		
		return e;
	}
	
	private int find(int x) {
		
		int root = x;
		while(root != parent[root])
			root = parent[root];
		
		while(x != parent[x]) {
			int next = parent[x];
			parent[x] = root;
			x = next;
		}
		
		return root;
	}
	
	private boolean unify(int x, int y) {
		
		int root1 = find(x);
		int root2 = find(y);
		
		if(root1 == root2)
			return false;
		
		if(size[root1] < size[root2]) {
			parent[root1] = parent[root2];
			size[root2] += size[root1];
		} else {
			parent[root2] = parent[root1];
			size[root1] += size[root2];
		}
		
		return true;
	}

	public void kruskals() {
		
		buildEdgeMinHeap();
		
		parent = new int[V+1];
		size   = new int[V+1];
		
		for(int i = 1; i <= V; i++) {
			parent[i] = i;
			size[i] = 1;
		}
		
		LinkedList<Edge> mst = new LinkedList<Edge>();
		
		while(heapSize != 0) {
			
			Edge e = popMinEdge();
			
			boolean res = unify(e.src, e.dst);;
			if(res)
				mst.add(e);
		}
		
		System.out.println("Edges in MST are:");
		for (Edge e : mst) {
			System.out.println(e.src + " -> " + e.dst + "  (" + e.wt + ")");
		}
	}
}
