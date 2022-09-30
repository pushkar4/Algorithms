
public class TestKmp {

  public static void main(String[] args) {

    KMP k = new KMP();
    k.search("tepatternxt", "pattern");
    k.search("abcxabcdabcdabcy", "abcdabcy");
    k.search("aaaaaaa", "aaaa");

  }
}
