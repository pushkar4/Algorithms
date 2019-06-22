/*
 * O(n^2)			Worst case
 * O(n log n)		Average case
 * Omega(n log n)	Best case
 */
public class TestQuickSort {

	public static void main(String[] args) {
		int A[] = {9, 6, 5, 0, 8, 2, 4, 7, 1, 3};
		
		quickSort(A, 0, A.length-1);
		
		for(int i = 0; i < A.length; i++)
			System.out.print(A[i] + " ");
	}

	private static void quickSort(int[] A, int l, int r) {
		
		if(l < r) {
			int m = partition(A, l, r);
			// Position m has an element which is at it's correct position
			// Make recursive calls to sort the subarrays before and after m
			quickSort(A, l, m-1);
			quickSort(A, m+1, r);
		}		
	}

	private static int partition(int[] A, int l, int r) {
		
		// Set A[r] as the pivot element
		int pivot = A[r];
		int i = l-1;
		
		// Loop from the start to 1 element less than r
		for(int j = l; j < r; j++) {
			
			// If element is found less than key then 
			// we need to move it to the front part of array.
			if(A[j] <= pivot) {
				i++;
				int t = A[i];
				A[i] = A[j];
				A[j] = t;
			}
		}
		
		// At this point l to i inclusive have elements less than A[r]
		// and i+1 to r-1 have elements greater than A[r]
		// Correct position of A[r] is at i+1 in such a scenario
		// So do the swap and place A[r] at its final position
		int t = A[i+1];
		A[i+1] = A[r];
		A[r] = t;
		
		// Return the position of the element which just attained its final position
		return i+1;
	}
}
