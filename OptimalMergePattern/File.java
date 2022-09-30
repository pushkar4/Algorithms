import io.github.pushkar4.TreePrinter.PrintableNode;

public class File implements PrintableNode {
  String name;
  int records;
  File left, right;

  File(String name, int records) {
    this.name = name;
    this.records = records;
    this.left = this.right = null;
  }

  @Override
  public PrintableNode getLeft() {
    return this.left;
  }

  @Override
  public PrintableNode getRight() {
    return this.right;
  }

  @Override
  public String getText() {
    return this.name + ":" + this.records;
  }
}
