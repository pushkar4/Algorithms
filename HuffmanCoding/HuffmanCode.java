
public class HuffmanCode {

  MinHeap heap;
  HuffmanNode root = null;

  public void doHuffmanCoding(char[] C, int[] F) {
    setCharAndFreq(C, F);
    generateCodes();
    printCodes();
  }

  private void setCharAndFreq(char[] C, int[] F) {

    HuffmanNode[] hArray = new HuffmanNode[C.length];
    for (int i = 0; i < C.length; i++) {
      hArray[i] = new HuffmanNode(C[i], F[i]);
    }

    heap = new MinHeap(hArray);
  }

  private void generateCodes() {

    heap.buildMinHeap();

    HuffmanNode min1, min2;

    while (heap.getHeapSize() > 1) {

      HuffmanNode node = new HuffmanNode('1', -1);

      node.left = min1 = heap.popMin();
      node.right = min2 = heap.popMin();
      node.frequency = min1.frequency + min2.frequency;

      heap.insert(node);
    }

    root = heap.popMin();
  }

  private void printCodes() {
    printCode(root, "");
  }

  private void printCode(HuffmanNode node, String code) {

    if (node.left == null && node.right == null) {
      System.out.println(node.character + ": " + code);
      return;
    }

    printCode(node.left, code + "0");
    printCode(node.right, code + "1");
  }
}
