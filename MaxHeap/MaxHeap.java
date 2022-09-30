
public class MaxHeap {

  private int N, heapSize;
  private int A[] = new int[100];

  MaxHeap(int[] a) {
    this.N = a.length;
    this.heapSize = 0;
    System.arraycopy(a, 0, A, 0, a.length);
  }

  public void printMaxHeap() {
    for (int i = 0; i < heapSize; i++)
      System.out.print(A[i] + " ");
    System.out.println();

    Tree tree = new Tree();
    tree.createAndPrint(A, heapSize);
  }

  // O(log n)  ----- CHECK
  private void buildMaxHeap(int[] A) {

    heapSize = N;

    /* In an almost complete binary tree the leaves will always be
     * from floor(n/2)+1 to n.
     * So the last element with at least 1 child will be at floor(n/2)
     * from where we have to start the maxHeapify() upto the root
     */
    for (int i = heapSize / 2; i >= 0; i--) {
      maxHeapify(A, i);
    }
  }

  // O(log n)
  private void maxHeapify(int[] A, int i) {

    int l = 2 * i + 1;
    int r = 2 * i + 2;

    int maxPos = i;

    if (l < heapSize && A[l] > A[i])
      maxPos = l;

    if (r < heapSize && A[r] > A[maxPos])
      maxPos = r;

    if (maxPos != i) {
      int t = A[maxPos];
      A[maxPos] = A[i];
      A[i] = t;

      maxHeapify(A, maxPos);
    }
  }

  // O(log n)
  public void buildMaxHeap() {
    buildMaxHeap(A);
  }

  // O(1)
  public int findMax() {
    if (heapSize < 0)
      return -1;
    return A[0];
  }

  // O(log n)
  public int popMax() {
    return popMax(A);
  }

  // O(log n)
  private int popMax(int[] A) {

    if (heapSize < 1) {
      // Heap underflow
      return -1;
    }

    int max = A[0];
    A[0] = A[heapSize - 1];
    heapSize--;
    maxHeapify(A, 0);

    return max;
  }

  public void changeKeyAtPos(int pos, int val) {
    /*
     * 2 cases can arise.
     * We might we wanting to change the value at pos to a greater value
     * Or the new value might be a smaller one.
     */
    increaseKeyAtPos(A, pos, val);
    decreaseKeyAtPos(A, pos, val);
  }

  // O(log n)
  private void increaseKeyAtPos(int[] A, int pos, int val) {

    A[pos] = val;

    // As the value is changed to a greater value
    // need to keep comparing and pushing it upwards to it's correct position
    while (pos >= 0 && A[(pos - 1) / 2] < A[pos]) {

      int t = A[(pos - 1) / 2];
      A[(pos - 1) / 2] = A[pos];
      A[pos] = t;
      pos = (pos - 1) / 2;
    }
  }

  // O(log n)
  private void decreaseKeyAtPos(int[] A, int pos, int val) {

    // When a key is changed to a smaller value
    // then the heap property below it may be broken
    // So call maxHeapify to heapify it again
    A[pos] = val;
    maxHeapify(A, pos);
  }

  // O(log n)
  public void insert(int val) {

    heapSize++;
    A[heapSize - 1] = Integer.MIN_VALUE;
    increaseKeyAtPos(A, heapSize - 1, val);
  }

  // O(n log n)
  public void heapSort() {

    buildMaxHeap(A);
    for (int i = heapSize - 1; i > 0; i--) {
      int t = A[0];
      A[0] = A[i];
      A[i] = t;
      heapSize--;
      maxHeapify(A, 0);
    }
  }

  public void showMaxHeapAsArray() {
    for (int i = 0; i < N; i++)
      System.out.print(A[i] + " ");
    System.out.println();
  }
}
