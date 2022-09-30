
public class TestOptimalMergePattern {

  public static void main(String[] args) {

    OptimalMergePattern ob = new OptimalMergePattern();
    ob.addFile("a", 5);
    ob.addFile("b", 6);
    ob.addFile("c", 4);
    ob.addFile("d", 2);
    ob.findOptimalMergePattern();

    OptimalMergePattern ob2 = new OptimalMergePattern();
    ob2.addFile("a", 10);
    ob2.addFile("b", 20);
    ob2.addFile("c", 30);
    ob2.findOptimalMergePattern();

    OptimalMergePattern ob3 = new OptimalMergePattern();
    ob3.addFile("a", 40);
    ob3.addFile("b", 10);
    ob3.addFile("c", 20);
    ob3.addFile("d", 15);
    ob3.addFile("e", 25);
    ob3.addFile("f", 30);
    ob3.findOptimalMergePattern();

  }
}
