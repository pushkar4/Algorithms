/*
 * O(n^2)		Worst case
 * Omega(n)		Best case
 */
public class InsertionSort {

  public static void main(String[] args) {

    int a[] = {9, 6, 5, 0, 8, 2, 7, 1, 3};

    int i, j, key;

    for (i = 1; i < a.length; i++) {
      key = a[i];
      j = i - 1;

      while (j >= 0 && a[j] > key) {
        a[j + 1] = a[j];
        j--;
      }

      a[j + 1] = key;
    }

    for (i = 0; i < a.length; i++)
      System.out.print(a[i] + " ");
  }
}
