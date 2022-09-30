
public class VertexMinHeap {

  int capacity;
  int currentHeapSize;
  VertexHeapNode[] A;
  int[] index;

  public VertexMinHeap(int capacity) {

    this.capacity = capacity;
    A = new VertexHeapNode[capacity];
    index = new int[capacity];
    currentHeapSize = 0;
  }

  public int heapSize() {
    return currentHeapSize;
  }

  public boolean isEmpty() {
    return currentHeapSize == 0;
  }

  private void minHeapify(int i) {

    int l = 2 * i + 1;
    int r = 2 * i + 2;
    int minPos = i;

    if (l < currentHeapSize && A[l].dist < A[i].dist)
      minPos = l;

    if (r < currentHeapSize && A[r].dist < A[minPos].dist)
      minPos = r;

    if (minPos != i) {
      swap(minPos, i);
      minHeapify(minPos);
    }
  }

  private void swap(int i, int j) {
    VertexHeapNode currNode = A[i];
    VertexHeapNode parentNode = A[j];

    int t = index[parentNode.vertex];
    index[parentNode.vertex] = index[currNode.vertex];
    index[currNode.vertex] = t;

    VertexHeapNode t2 = A[i];
    A[i] = A[j];
    A[j] = t2;
  }

  private void bubbleUp(int i) {

    int currPos = i;
    int parentPos = (i - 1) / 2;

    while (parentPos >= 0 && A[currPos].dist < A[parentPos].dist) {

      swap(currPos, parentPos);

      currPos = parentPos;
      parentPos = (parentPos - 1) / 2;
    }
  }

  public void insert(VertexHeapNode node) {
    currentHeapSize++;
    int pos = currentHeapSize - 1;
    A[pos] = node;
    index[node.vertex] = pos;
    bubbleUp(pos);
  }

  public VertexHeapNode popMinDistVertex() {

    VertexHeapNode node = A[0];
    VertexHeapNode lastNode = A[currentHeapSize - 1];

    index[lastNode.vertex] = 0;

    A[0] = lastNode;
    A[currentHeapSize - 1] = null;

    currentHeapSize--;

    minHeapify(0);

    return node;
  }

  public void decreaseKey(int newDist, int v) {

    int pos = index[v];
    A[pos].dist = newDist;

    bubbleUp(pos);
  }
}
