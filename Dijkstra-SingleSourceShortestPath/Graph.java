import java.util.LinkedList;

@SuppressWarnings("unchecked")
public class Graph {

  int V;
  LinkedList<Edge> adjListOfEdges[];
  int[] parent;

  public Graph(int v) {
    V = v;
    adjListOfEdges = new LinkedList[V];
    parent = new int[V];

    for (int i = 0; i < V; i++) {
      adjListOfEdges[i] = new LinkedList<Edge>();
      parent[i] = 0;
    }
  }

  public void addEdge(int s, int d, int w) {

    Edge edge = new Edge(s, d, w);
    adjListOfEdges[s].addFirst(edge);

    edge = new Edge(d, s, w);
    adjListOfEdges[d].addFirst(edge);
  }

  private void relax(VertexMinHeap heap, VertexHeapNode[] vertexArr, int u, int v, int w) {
    int newDist = vertexArr[u].dist + w;
    int oldDist = vertexArr[v].dist;

    if (newDist < oldDist) {
      heap.decreaseKey(newDist, v);
      vertexArr[v].dist = newDist;
      parent[v] = u;
    }
  }

  public void dijkstra(int source) {

    parent[source] = -1;
    boolean[] isInMst = new boolean[V];
    VertexHeapNode[] vertexArr = new VertexHeapNode[V];

    for (int i = 0; i < V; i++) {
      vertexArr[i] = new VertexHeapNode(i, Integer.MAX_VALUE / 2);
    }

    vertexArr[source].dist = 0;

    VertexMinHeap heap = new VertexMinHeap(V);

    for (int i = 0; i < V; i++) {
      heap.insert(vertexArr[i]);
    }

    while (!heap.isEmpty()) {
      VertexHeapNode unode = heap.popMinDistVertex();

      int u = unode.vertex;

      isInMst[u] = true;

      LinkedList<Edge> edgeList = adjListOfEdges[u];

      for (int i = 0; i < edgeList.size(); i++) {
        Edge edge = edgeList.get(i);
        int v = edge.dst;
        int w = edge.wt;

        if (!isInMst[v]) {
          relax(heap, vertexArr, u, v, w);
        }
      }
    }

    System.out.println("Shortest path distance from ");
    for (int i = 0; i < V; i++) {
      if (i == source)
        continue;
      System.out.println(source + " to " + i + " is " + vertexArr[i].dist);
    }

    System.out.print("\nShortest paths are\n");
    for (int i = 0; i < V; i++) {
      if (i == source)
        continue;
      printPath(i, source);
      System.out.println();
    }
  }

  private void printPath(int i, int source) {
    if (i == source) {
      System.out.print(i + " ");
      return;
    } else {
      printPath(parent[i], source);
      System.out.print(i + " ");
    }
  }
}
