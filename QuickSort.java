/*		Programming Assignment #1
 * 		Date 11/8/2013
 * 		Name: Jake Crane
 * 		Program: This class contains all the necessary functions to Quicksort an integer array.
 * 		
 */

public class QuickSort {

	public static void randomizedQuickSort(int[] array, int p, int r) {
		if (p < r) {
			int q = randomizedPartition(array, p - 1, r - 1);

			randomizedQuickSort(array, p, q - 1);
			randomizedQuickSort(array, q + 1, r);
		}
	}

	public static int getRandomInt(final int min, final int max) {
		return (int)( min + Math.random() * (1 + max - min) );
	}

	public static int randomizedPartition(int[] array, int p, int r) {

		int i = getRandomInt(p, r);

		int temp = array[r];
		array[r] = array[i];
		array[i] = temp;

		return partition(array, p, r);
	}

	public static void quickSort(int[] array, int p, int r) {
		if (p < r) {
			int q = partition(array, p - 1, r - 1);

			quickSort(array, p, q - 1);
			quickSort(array, q + 1, r);
		}
	}

	public static int partition(int[] array, int p, int r) {
		int x = array[r];
		int i = p - 1;
		for (int j = p; j <= r-1; j++) {
			if (array[j] <= x) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		int temp = array[i + 1];
		array[i + 1] = array[r];
		array[r] = temp;
		return i + 2;
	}

}
