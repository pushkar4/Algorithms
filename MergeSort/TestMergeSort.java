/* O(n log n) all cases
 */
public class TestMergeSort {

  public static void main(String[] args) {

    int A[] = {9, 6, 5, 0, 8, 2, 7, 1, 3};

    mergeSort(A, 0, A.length - 1);

    for (int i = 0; i < A.length; i++)
      System.out.print(A[i] + " ");
  }

  private static void mergeSort(int[] A, int l, int r) {

    if (l < r) {
      int m = (l + r) / 2;
      mergeSort(A, l, m);
      mergeSort(A, m + 1, r);
      merge(A, l, m, r);
    }
  }

  private static void merge(int[] A, int l, int m, int r) {

    int len1 = m - l + 1;
    int len2 = r - m;

    int a[] = new int[len1];
    int b[] = new int[len2];

    for (int i = 0; i < len1; i++)
      a[i] = A[i + l];

    for (int i = 0; i < len2; i++)
      b[i] = A[i + m + 1];

    int i = 0, j = 0, k = l;

    while (i < len1 && j < len2) {
      if (a[i] <= b[j]) {
        A[k] = a[i];
        i++;
      } else {
        A[k] = b[j];
        j++;
      }
      k++;
    }

    while (i < len1) {
      A[k] = a[i];
      i++;
      k++;
    }

    while (j < len2) {
      A[k] = b[j];
      j++;
      k++;
    }
  }
}
