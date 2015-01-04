/*		Programming Assignment #1
 * 		Date 11/8/2013
 * 		Name: Jake Crane
 * 		Program: This class contains all the necessary functions to Merge Sort an integer array.
 * 		
 */

public class MergeSort {
	
	public static void mergeSort(int[] array, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(array, p, q);
			mergeSort(array, q + 1, r);
			merge(array, p, q, r);
		}
	}
	
	public static void merge(int[] array, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		
		int[] left = new int[n1 + 1];
		int[] right = new int[n2 + 1];
		
		int i = 0;
		for (; i < n1; i++) {
			left[i] = array[p + i - 1];
		}
		
		int j = 0;
		for (; j < n2; j++) {
			right[j] = array[q + j];
		}

		left[n1] = Integer.MAX_VALUE;
		right[n2] = Integer.MAX_VALUE;
		
		i = 0;
		j = 0;
		
		for (int k = p; k <= r; k++) {
			if (left[i] <= right[j]) {
				array[k - 1] = left[i];
				i++;
			} else {
				array[k - 1] = right[j];
				j++;
			}
		}
		
	}
}
