
public class TestMaxHeap {

  public static void main(String[] args) {

    int A[] = {9, 6, 5, 0, 8, 2, 7, 1, 3};
    MaxHeap heap = new MaxHeap(A);

    heap.buildMaxHeap();

    heap.printMaxHeap();

    int max = heap.popMax();
    System.out.print("Max is: " + max + "\n");

    heap.printMaxHeap();

    heap.changeKeyAtPos(1, 2);
    heap.printMaxHeap();

    heap.insert(6);
    heap.printMaxHeap();


    MaxHeap heap2 = new MaxHeap(new int[]{100, 20, 30, 10, 15, 7, 16});
    heap2.heapSort();
    heap2.showMaxHeapAsArray();

  }
}
