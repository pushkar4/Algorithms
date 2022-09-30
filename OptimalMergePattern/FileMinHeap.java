
public class FileMinHeap {

  int N, heapSize;
  File[] A = new File[100];

  public FileMinHeap(File[] a, int len) {
    N = len;
    heapSize = 0;
    System.arraycopy(a, 0, A, 0, a.length);
  }

  public void printHeap() {
    Tree tree = new Tree();
    tree.createAndPrint(A, heapSize);
  }

  public void buildFileMinHeap() {

    heapSize = N;
    for (int i = (heapSize - 1) / 2; i >= 0; i--) {
      minHeapify(A, i);
    }
  }

  private void minHeapify(File[] A, int pos) {

    int l = 2 * pos + 1;
    int r = 2 * pos + 2;

    int minPos = pos;

    if (l < heapSize && A[l].records < A[pos].records)
      minPos = l;

    if (r < heapSize && A[r].records < A[minPos].records)
      minPos = r;

    if (minPos != pos) {
      File t = A[minPos];
      A[minPos] = A[pos];
      A[pos] = t;

      minHeapify(A, minPos);
    }
  }

  public File popMin() {

    if (heapSize < 1)
      return null;

    File file = A[0];

    A[0] = A[heapSize - 1];
    heapSize--;

    minHeapify(A, 0);

    return file;
  }

  public int size() {
    return heapSize;
  }

  public void insert(File file) {
    heapSize++;
    A[heapSize - 1] = file;

    int i = heapSize - 1;
    while (i >= 0 && A[(i - 1) / 2].records > A[i].records) {
      File t = A[(i - 1) / 2];
      A[(i - 1) / 2] = A[i];
      A[i] = t;
      i = (i - 1) / 2;
    }
  }
}
