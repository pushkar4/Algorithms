
public class FractionalKnapsack {

  public static void main(String[] args) {

    // Inputs
    int n = 7;
    int p[] = {10, 5, 15, 7, 6, 18, 3};
    int w[] = {2, 3, 5, 7, 1, 4, 1};
    int capacity = 15;

    // Processing
    float pw[] = new float[n];
    int i;
    float profit = 0.0f;

    for (i = 0; i < n; i++)
      pw[i] = (float) p[i] / w[i];

    sort(pw, p, w, n);

    System.out.println("\nAdded items: ");
    for (i = 0; i < n; i++) {

      if (w[i] <= capacity) {
        profit += p[i];
        capacity -= w[i];
        System.out.println(w[i] + "\t p: " + p[i]);
      } else {
        break;
      }
    }

    if (capacity > 0 && i < n) {
      profit += pw[i] * capacity;
      System.out.println(w[i] + "(f)\t p: " + pw[i] * capacity);
      capacity = 0;
    }

    System.out.println("\nTotal profit: " + profit);
  }

  private static void sort(float[] pw, int[] p, int[] w, int n) {
    int i, j;

    for (i = 0; i < n; i++) {
      for (j = i; j < n; j++) {
        if (pw[i] < pw[j]) {
          float tf = pw[i];
          pw[i] = pw[j];
          pw[j] = tf;

          int t = p[i];
          p[i] = p[j];
          p[j] = t;

          t = w[i];
          w[i] = w[j];
          w[j] = t;
        }
      }
    }

    for (i = 0; i < n; i++)
      System.out.println(p[i] + "\t w: " + w[i] + "\t p/w: " + pw[i]);
  }

}
